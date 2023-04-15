package com.ly.fish_boom.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ly.fish_boom.entity.User;
import com.ly.fish_boom.service.IUserService;
import com.ly.fish_boom.util.Result;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.lang.Console;

@RestController
public class foreControll {
	@Autowired
	private IUserService ius;
	@PostMapping("/login")
	public Result login(@RequestBody User u, HttpSession session,@RequestParam(value="verifyCode",required=true) String verifyCode) {
		Console.log(verifyCode);
		if(u.getAcco()==null||u.getPassword()==null)
			return Result.fail("账号密码不能为空");
		Console.log(session.getAttribute("verifyCode"));
		if(!verifyCode.equals(session.getAttribute("verifyCode")))
			return Result.fail("验证码不正确");
		Subject subject=SecurityUtils.getSubject();
		String acco=u.getAcco();
		UsernamePasswordToken token = new UsernamePasswordToken(acco, u.getPassword());
		try {
			subject.login(token);
			QueryWrapper<User> q=new QueryWrapper<User>().eq("acco", acco);
			User user=ius.getOne(q);
			session.setAttribute("user", user);
			session.removeAttribute("verifyCode");
		} catch (Exception e) {
				return Result.fail("账号不存在密码错误");
		}
		Result r=Result.success();
		r.setMessage(acco);
		return Result.success(session.getAttribute("user"));
	}
	
	@PutMapping("/logout") 
	public Result logout(HttpSession session) {
		Subject subject=SecurityUtils.getSubject();
		User u=(User) session.getAttribute("user");
		if(u==null)
			return Result.fail("无用户登录");
		session.removeAttribute("user");
		subject.logout();
		Result r=Result.success();
		r.setMessage(u.getAcco()+"退出登录");
		return r;
	}
}
