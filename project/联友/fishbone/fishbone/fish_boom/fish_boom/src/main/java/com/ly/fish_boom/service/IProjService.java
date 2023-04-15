package com.ly.fish_boom.service;

import com.ly.fish_boom.entity.Proj;
import com.ly.fish_boom.vo.ProjectVo;

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
public interface IProjService extends IService<Proj> {
	public Page<ProjectVo> projectList(Page<Proj> page,QueryWrapper<Proj> query);
	public Integer creatProject(ProjectVo pvo);
	public boolean deleteProject(Integer pid);
	public ProjectVo listOneById(Integer id);
}
