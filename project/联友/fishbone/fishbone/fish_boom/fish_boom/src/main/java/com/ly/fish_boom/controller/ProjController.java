package com.ly.fish_boom.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ly.fish_boom.aop.MyLog;
import com.ly.fish_boom.entity.Grou;
import com.ly.fish_boom.entity.Opera;
import com.ly.fish_boom.entity.Proj;
import com.ly.fish_boom.entity.Task;
import com.ly.fish_boom.entity.User;
import com.ly.fish_boom.entity.UserGrou;
import com.ly.fish_boom.mapper.GrouMapper;
import com.ly.fish_boom.service.IGrouService;
import com.ly.fish_boom.service.IOperaService;
import com.ly.fish_boom.service.IProjService;
import com.ly.fish_boom.service.ITaskService;
import com.ly.fish_boom.service.IUserGrouService;
import com.ly.fish_boom.util.Result;
import com.ly.fish_boom.vo.ProjectVo;

import cn.hutool.core.lang.Console;
import cn.hutool.db.handler.RsHandler;
import cn.hutool.db.sql.Query;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lizhyi
 * @since 2019-10-10
 */
@RestController
@RequestMapping("/proj")
public class ProjController {
	@Autowired
	private IProjService ips;
	@Autowired
	private IGrouService igs;
	@Autowired
	private IUserGrouService iugs;
	@Autowired
	private GrouMapper gm;
	@Autowired
	private ObjectMapper om;
	@Autowired
	private ITaskService its;
	@Autowired
	private IOperaService ios;
	@PostMapping("/add")
	public Result creatProject(@RequestBody ProjectVo pvo,HttpSession session) {
		User creator=(User) session.getAttribute("user");
		pvo.setCreator(creator.getName());
		try {
			Integer id=ips.creatProject(pvo);
			Opera log=new Opera();
			if(pvo.getName()!=null)
				log.setContent("新建项目："+pvo.getName());
			log.setCreator(creator.getName());
			log.setTid(id);
			ios.save(log);
		} catch (Exception e) {
			return Result.fail("创建失败");
		}
		return Result.success();
	}
	@GetMapping("/list")
	public Result select(@RequestParam(value = "start", defaultValue = "1") int start,@RequestParam(value = "size", defaultValue = "5") int size
			,@RequestParam(value="sorters",required=true)String sorters
			,HttpServletResponse response, @RequestParam(value="status",defaultValue="all") String status) {
	
		JSONObject orderMap=JSONUtil.parseObj(sorters);
		String column=(String) orderMap.get("column");
		String direction=(String) orderMap.get("direction");
		List<OrderItem> items=new ArrayList<OrderItem>(3);
		//判断项目的排序
		switch (column) {
		case "last_Update":
			items.add(direction.equals("asc")?OrderItem.asc("last_Update"):OrderItem.desc("last_Update"));
			break;
		case "end_Date":
			items.add(direction.equals("asc")?OrderItem.asc("end_Date"):OrderItem.desc("end_Date"));
			break;
		case "priority":
			items.add(direction.equals("asc")?OrderItem.asc("priority"):OrderItem.desc("priority"));
			break;
		default:
			break;
		}
		QueryWrapper<Proj> query=new QueryWrapper<Proj>();
		//判断项目进行，完成，全部
		if(status.equals("running"))
				query.ne("percent", "100%");
		else if(status.equals("finish")) {
				query.eq("percent","100%");
				Console.log("完成状态");
		}
		Page<Proj> page=new Page<Proj>().addOrder(items);
		page.setCurrent(start);
		page.setSize(size);
		Page<ProjectVo> voPage;
		try {
			voPage=ips.projectList(page,query);
		} catch (Exception e) {
			return Result.fail("查询失败。请联系管理员");
		}
		return Result.success(voPage.getRecords(),voPage.getTotal());
	}
	//通过名字查找项目
	@GetMapping("/listByName")
	public Result listone(String name) {
		List<Proj> p=ips.list(new QueryWrapper<Proj>().like("name", name));
		return Result.success(p);
		
	}
	
	//获取项目中的任务
	@GetMapping("/listTask")
	public Result listTask(@RequestParam(value="pid",required=true)Integer id) {
		QueryWrapper<Task> query=new QueryWrapper<Task>().eq("pid", id);
		return Result.success(its.taskList(new Page<Task>().setSize(100),query).getRecords());
		
	}
	//删除项目
	@DeleteMapping("/delete/{id}")
	public Result delete(@PathVariable(value="id") Integer id) {
		try {
			ips.deleteProject(id);
		} catch (Exception e) {
			return Result.fail("删除失败");
		}
		return Result.success();
		
	}
	//修改一个项目
	@PutMapping("/update/{id}")
	@MyLog(operation="修改项目",entity=ProjectVo.class)
	public Result update(@PathVariable(value="id") Integer id,@RequestBody String params) {
		ProjectVo pvo;
		try {
			pvo = om.readValue(params, ProjectVo.class);
		} catch (IOException e) {
			return Result.fail("请输入正确参数");
		}
	
		if(pvo.getCc()!=null) {
			Integer cGid=igs.addGroup(pvo.getCc());
			pvo.setcGid(cGid);
		}
		if(pvo.getPartner()!=null) {
			Integer partnerGid=igs.addGroup(pvo.getPartner());
			 pvo.setPartnerGid(partnerGid);
		}
		if(pvo.getPm()!=null) {
			 pvo.setPmUid(pvo.getPm().getId());
		}
		pvo.setId(id);
		ips.updateById(pvo);
		return Result.success();
	}
}
