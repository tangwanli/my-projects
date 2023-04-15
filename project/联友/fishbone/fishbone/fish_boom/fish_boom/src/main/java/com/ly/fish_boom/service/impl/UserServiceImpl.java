package com.ly.fish_boom.service.impl;

import com.ly.fish_boom.entity.User;
import com.ly.fish_boom.mapper.UserMapper;
import com.ly.fish_boom.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lizhyi
 * @since 2019-10-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
	
	@Override
	public boolean isExist(String acco) {
		QueryWrapper<User> queryWrapper=new QueryWrapper<User>().eq("acco", acco);
		return this.getOne(queryWrapper)!=null;
	}

}
