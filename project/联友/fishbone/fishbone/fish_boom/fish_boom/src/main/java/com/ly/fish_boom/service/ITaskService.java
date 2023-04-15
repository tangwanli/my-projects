package com.ly.fish_boom.service;


import com.ly.fish_boom.entity.Task;
import com.ly.fish_boom.vo.ProjectVo;
import com.ly.fish_boom.vo.TaskVo;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lizhyi
 * @since 2019-10-10
 */
public interface ITaskService extends IService<Task> {
	public Page<TaskVo> taskList(Page<Task> page,QueryWrapper<Task> query);
	public int addTask(TaskVo tvo);
	public boolean remove(Integer tid);
}
