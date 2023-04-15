package com.ly.fish_boom.mapper;

import com.ly.fish_boom.entity.Proj;
import com.ly.fish_boom.vo.ProjectVo;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lizhyi
 * @since 2019-10-10
 */
public interface ProjMapper extends BaseMapper<Proj> {
	//public List<ProjectVo> projectList(Page<Proj> page);
}
