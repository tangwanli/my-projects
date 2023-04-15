package com.ly.fish_boom.controller;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ly.fish_boom.entity.User;
import com.ly.fish_boom.service.IUserService;
import com.ly.fish_boom.util.Result;

import cn.hutool.core.lang.Console;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lizhyi
 * @since 2019-10-10
 */
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService ius;
	@GetMapping("/list")
	public Result userList(@RequestParam(value = "start", defaultValue = "1") int start,@RequestParam(value = "size", defaultValue = "5") int size){
		Page<User> page=new Page<User>(start, size);
		ius.page(page);
		return Result.success(page.getRecords());
	}
	//通过名字查找
	@GetMapping("/listByName")
	public Result listone(String name) {
		List<User> u=ius.list(new QueryWrapper<User>().like("name",name));
		return Result.success(u);
		
	}
	@PostMapping("/addByExcel")
	public Result addUserByExcel(MultipartFile excelFile,HttpServletRequest request){
		ExcelReader er;
		try {
			er = ExcelUtil.getReader(excelFile.getInputStream());
		} catch (IOException e) {
			return Result.fail("发生错误");
		}
		List<User> userlist=er.readAll(User.class);
		for(User u:userlist) {
			Console.log(u);
			addUser(u);
		}
		return Result.success();
	}
	@PostMapping("/add")
	public Result add(@RequestBody User u) {
		return addUser(u);
	}
	//加人
	public Result addUser(User u) {
		if(u.getAcco()==null||u.getPassword()==null)
			return Result.fail("用户名密码不能为空");
		String acco=u.getAcco();
		if(ius.isExist(acco))
			return Result.fail("用户已存在");
		String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        String algorithmName = "md5";
        String encodedPassword = new SimpleHash(algorithmName, u.getPassword(), salt, times).toString();
        u.setSalt(salt);
        u.setPassword(encodedPassword);
        ius.save(u);		
		return Result.success();
	}
}
