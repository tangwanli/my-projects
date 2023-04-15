package com.ly.fish_boom.controller;


import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
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

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ly.fish_boom.aop.MyLog;
import com.ly.fish_boom.entity.Opera;
import com.ly.fish_boom.entity.Task;
import com.ly.fish_boom.entity.User;
import com.ly.fish_boom.enums.PercentEnum;
import com.ly.fish_boom.enums.TaskStatusEnum;
import com.ly.fish_boom.service.IGrouService;
import com.ly.fish_boom.service.IOperaService;
import com.ly.fish_boom.service.ITaskService;
import com.ly.fish_boom.service.IUserGrouService;
import com.ly.fish_boom.util.Result;
import com.ly.fish_boom.vo.TaskVo;

import cn.hutool.core.lang.Console;
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
@RequestMapping("/task")
public class TaskController {
	@Autowired
	private ObjectMapper om; 
	@Autowired
	private ITaskService its;
	@Autowired
	private IGrouService igs;
	@Autowired
	private IOperaService ios;
	//增加
	@PostMapping("/add")
	public Result addTask(@RequestBody TaskVo tvo,HttpSession session) {
		User creator=(User) session.getAttribute("user");
		if(creator==null)
			return Result.fail("请先登录");
		tvo.setCreator(creator.getName());
		//tvo.setStatus(TaskStatusEnum.WAITING);
		try {
			Integer id=its.addTask(tvo);
			Opera log=new Opera();
			log.setContent("新建任务："+tvo.getName());
			log.setCreator(creator.getName());
			log.setTid(id);
			ios.save(log);
		} catch (Exception e) {
			return Result.fail("添加失败");
		}
		
		return Result.success();
	}
	//查
	@GetMapping("/list")
	public Result listTask(@RequestParam(value = "start", defaultValue = "1") int start,@RequestParam(value = "size", defaultValue = "5") int size
			,@RequestParam(value="sorters",required=true)String sorters
			,HttpServletRequest request,HttpSession session
								) {
		
		User user=(User) session.getAttribute("user");
		if(user==null)
			return Result.fail("请登录");
		Integer uid=user.getId();
		String username=user.getName();
		JSONObject orderMap=JSONUtil.parseObj(sorters);
		
		String column=(String) orderMap.get("column");
		String direction=(String) orderMap.get("direction");
		
		List<OrderItem> items=new ArrayList<OrderItem>(3);
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
		Page<Task> page=new Page<Task>().addOrder(items).setSize(size).setCurrent(start);
		QueryWrapper<Task> query=new QueryWrapper<>();
		//判断任务归属
		if(request.getParameter("task_type").equals("2"))
			query.eq("creator",username);
		else if(request.getParameter("task_type").equals("1"))
			query.inSql("f_gid","select gid from user_grou where uid="+uid);
		else if(request.getParameter("task_type").equals("3"))
			query.inSql("c_gid","select gid from user_grou where uid="+uid);
		//项目状态
		if(request.getParameter("status").equals("running"))
			query.in("status",0,1);//status0的时候就是0和1
		if(request.getParameter("status").equals("finish"))
			query.eq("status",2);
		Page<TaskVo> pageVo=its.taskList(page,query);
		return Result.success(pageVo.getRecords());
	}
	@DeleteMapping("/delete/{id}")
	public Result delete(@PathVariable(value="id") Integer id) {
		try {
			its.remove(id);
		} catch (Exception e) {
		return Result.fail("删除失败");
		}	
		return Result.success();
		
	}
	@PutMapping("/update/{id}")
	@MyLog(operation="修改任务",entity=TaskVo.class)
	public Result update(@PathVariable(value="id") Integer id,@RequestBody String params){
		TaskVo tvo;
		try {
			tvo = om.readValue(params, TaskVo.class);
		} catch (Exception e) {
			return Result.fail("失败");
		}
		
		//如果是修改负责人，抄送人，还有项目
		if(tvo.getCc()!=null) {
			Integer cGid=igs.addGroup(tvo.getCc());
			tvo.setcGid(cGid);
		}
		if(tvo.getFf()!=null) {
			Integer fGid=igs.addGroup(tvo.getFf());
			 tvo.setfGid(fGid);
		}
		if(tvo.getProject()!=null) {
			Integer pid=tvo.getProject().getId();
			tvo.setPid(pid);
		}
		tvo.setId(id);
		//改变状态和进度
		if(tvo.getPercent()!=null) {
			tvo.setStatus(tvo.getPercent()==PercentEnum.HUNDRED?TaskStatusEnum.FINISH:TaskStatusEnum.RUNNING);
		}
		
		its.updateById(tvo);
		return Result.success();
	}
	//批量调整正在进行中任务的到期时间
	@PutMapping("/update/many")
	@MyLog(operation="批量调整任务时间")
	public Result updateMany(Integer id,int days) {
		QueryWrapper<Task> queryWrapper=new QueryWrapper<Task>();
		queryWrapper.eq("pid", id).and(i->i.eq("status", 1));
		List<Task> taskList=its.list(queryWrapper);
		for(Task task:taskList) {
			LocalDateTime ldt=task.getEndDate();
			LocalDateTime newone=ldt.plusDays(days);
			task.setEndDate(newone);
		}
		its.updateBatchById(taskList);
		return Result.success();
	}
}
