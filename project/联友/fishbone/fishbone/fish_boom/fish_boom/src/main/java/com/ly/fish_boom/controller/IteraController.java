package com.ly.fish_boom.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.ly.fish_boom.entity.Itera;
import com.ly.fish_boom.mapper.IteraMapper;
import com.ly.fish_boom.util.Result;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lizhyi
 * @since 2019-10-10
 */
@RestController
@RequestMapping("/itera")
public class IteraController {
	@Autowired
	private IteraMapper im;
	@PostMapping("/add")
	public Result add(@RequestBody Itera itera) {
		im.insert(itera);
		return Result.success();
	}
	@GetMapping("/list")
	public Result select() {
		List<Itera> ls=im.selectList(null);
		return Result.success(ls);
		
	}
	
}
