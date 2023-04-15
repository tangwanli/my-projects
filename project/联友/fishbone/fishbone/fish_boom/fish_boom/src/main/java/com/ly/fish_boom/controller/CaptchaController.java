package com.ly.fish_boom.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ly.fish_boom.util.Result;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;

@Controller
public class CaptchaController {
	@RequestMapping("/getCaptcha")
	public void getCaptcha(HttpServletResponse response,HttpSession session) {
		LineCaptcha lineCaptcha=CaptchaUtil.createLineCaptcha(130, 80);
		String verifyCode=lineCaptcha.getCode();
		session.setAttribute("verifyCode", verifyCode);
		response.setContentType("image/png");
		response.setHeader("Cache-Control", "no-cache, no-store");
	    response.setHeader("Pragma", "no-cache");
		try {
			lineCaptcha.write(response.getOutputStream());
		} catch (IOException e) {
			
		}

		
	}
}
