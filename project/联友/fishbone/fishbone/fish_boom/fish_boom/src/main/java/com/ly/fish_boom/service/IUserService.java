package com.ly.fish_boom.service;

import com.ly.fish_boom.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lizhyi
 * @since 2019-10-10
 */
public interface IUserService extends IService<User> {
	public boolean isExist(String acco);
}
