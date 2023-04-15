package com.ly.fish_boom.UserTest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ly.fish_boom.entity.User;
import com.ly.fish_boom.mapper.UserMapper;
import com.ly.fish_boom.service.impl.UserServiceImpl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
	@Autowired
	public UserMapper um;
	@Autowired
	public UserServiceImpl usi;
	@Test
	public void inserUserByExcel() {
		ExcelReader er=ExcelUtil.getReader(FileUtil.file("D:\\user.xlsx"));
		List<User> userlist=er.readAll(User.class);
		for(User u:userlist) {
			Console.log(u);
			um.insert(u);
		}
		Console.log(um.selectList(null));
	}
	@Test
	public void insertUSer(){
		User u=new User();
		u.setName("King");
		u.setPassword("123");
		u.setPosition("项目经理");
		u.setSalt("awsl");
		um.insert(u);
	} 
	@Test
	public void updateUser(){
		User u=new User();
		um.update(u, null);
	}
	@Test 
	public void deptUserList(){
		
	}
	@Test
	public void userSave() {
		User u= new User();
		u.setDept("Test");
		u.setName("leegenn");
		u.setPassword("21");
		usi.save(u);
		
	}
}
