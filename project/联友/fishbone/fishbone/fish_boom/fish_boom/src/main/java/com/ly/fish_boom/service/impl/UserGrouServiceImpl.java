package com.ly.fish_boom.service.impl;

import com.ly.fish_boom.entity.UserGrou;
import com.ly.fish_boom.mapper.UserGrouMapper;
import com.ly.fish_boom.service.IUserGrouService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.apache.poi.hssf.util.HSSFColor.TURQUOISE;
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
public class UserGrouServiceImpl extends ServiceImpl<UserGrouMapper, UserGrou> implements IUserGrouService {

	/** 
	 * @param Gid
	 * @return
	 * @see com.ly.fish_boom.service.IUserGrouService#removeByGid(java.lang.Integer)
	 * @author ly-lizhyi 2019年10月19日 上午11:06:28
	 * @version 1.0
	 */
	@Override
	public boolean removeByGid(Integer Gid) {
		QueryWrapper<UserGrou> wrapper=new QueryWrapper<UserGrou>().eq("gid", Gid);
		super.remove(wrapper);
		return true;
	}

}
