package com.ly.fish_boom.service.impl;

import com.ly.fish_boom.entity.Grou;
import com.ly.fish_boom.entity.User;
import com.ly.fish_boom.entity.UserGrou;
import com.ly.fish_boom.mapper.GrouMapper;
import com.ly.fish_boom.service.IGrouService;
import com.ly.fish_boom.service.IUserGrouService;

import cn.hutool.core.lang.Console;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
public class GrouServiceImpl extends ServiceImpl<GrouMapper, Grou> implements IGrouService {
	@Autowired
	private IUserGrouService iugs;
	@Override
	public Integer addGroup(List<User> ul) {
		Grou g=new Grou();
		g.setName("");
	
		super.save(g);
		
		Integer gId=g.getId();
		for(User u:ul) {
			UserGrou ug=new UserGrou();
			ug.setGid(gId);
			ug.setUid(u.getId());
			
			iugs.save(ug);
			
		}
		return gId;
	}

}
