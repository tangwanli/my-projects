package com.ly.fish_boom.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ly.fish_boom.entity.User;
import com.ly.fish_boom.service.IUserService;

public class MyRealm extends AuthorizingRealm{
	@Autowired
	private IUserService ius;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		SimpleAuthorizationInfo s = new SimpleAuthorizationInfo();
		return s;
		
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String acco=token.getPrincipal().toString();
		Wrapper<User> query=new QueryWrapper<User>().eq("acco", acco);
		User user=ius.getOne(query);
		String passwordInDB=user.getPassword();
		String salt = user.getSalt();
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(acco, passwordInDB, ByteSource.Util.bytes(salt),
				getName());
		return authenticationInfo;
	}

}
