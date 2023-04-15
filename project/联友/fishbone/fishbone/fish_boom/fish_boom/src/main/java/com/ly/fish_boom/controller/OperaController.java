package com.ly.fish_boom.controller;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ly.fish_boom.entity.Opera;
import com.ly.fish_boom.entity.User;
import com.ly.fish_boom.service.IOperaService;
import com.ly.fish_boom.service.IProjService;
import com.ly.fish_boom.service.ITaskService;
import com.ly.fish_boom.util.Result;
import com.ly.fish_boom.vo.commentVo;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lizhyi
 * @since 2019-10-10
 */
@RestController
@RequestMapping("/opera")
public class OperaController {
	@Autowired
	private IOperaService ios;
	@Autowired
	private IProjService ips;
	@Autowired
	private ITaskService its;
	private Object String;
	//列出操作记录
	@GetMapping("/listById")
	public Result listById(@RequestParam(value="id",required=true)Integer subject_id,String type) {
		QueryWrapper<Opera> queryWrapper=new QueryWrapper<Opera>();
		if(type.equals("project"))
			queryWrapper.eq("pid", subject_id);
		else if(type.equals("task"))
			queryWrapper.eq("tid", subject_id);
		queryWrapper.orderByDesc("creat_time");
		return Result.success(ios.list(queryWrapper));
	}
	
	@GetMapping("/list")
	public Result list() {
		QueryWrapper<Opera> query=new QueryWrapper<Opera>();
		LocalDateTime lastWeek=LocalDateTime.now().minusDays(2);
		query.ge("creat_time", lastWeek);
		List<Opera> logs=ios.list(query);
		List<commentVo> ovo=new ArrayList<commentVo>();
		for(Opera o:logs) {
			ovo.add(transtocommentVo(o));
		}
		return Result.success(ovo);
		
	}
	private commentVo transtocommentVo(Opera o) {
		if(o.getPid()!=null) {
			commentVo cvo=new commentVo();
			BeanUtils.copyProperties(o, cvo);
			cvo.setSubject_name(ips.getById(o.getPid()).getName());
			cvo.setSubject_id(o.getPid());
			cvo.setType("project");
			return cvo;
		}
		if(o.getTid()!=null){
			commentVo cvo=new commentVo();
			BeanUtils.copyProperties(o, cvo);
			cvo.setSubject_name(its.getById(o.getTid()).getName());
			cvo.setSubject_id(o.getTid());
			cvo.setType("task");
			return cvo;
		}
		return null;
	}
	
	@PostMapping("/add")
	public Result aad(@RequestBody commentVo cvo,HttpSession session) {
		User creator=(User)session.getAttribute("user");
		Opera op=new Opera();
		BeanUtils.copyProperties(cvo, op);
		op.setCreator(creator.getName());
		if(cvo.getType().equals("project"))
			op.setPid(cvo.getSubject_id());
		else
			op.setTid(cvo.getSubject_id());
		ios.save(op);
		return Result.success("评论成功");
	}
}
