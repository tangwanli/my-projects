package com.ly.fish_boom.service;

import com.ly.fish_boom.entity.Grou;
import com.ly.fish_boom.entity.User;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lizhyi
 * @since 2019-10-10
 */
public interface IGrouService extends IService<Grou> {
	public Integer addGroup(List<User> ul);
}
