package com.ros.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ros.bean.Msg;
import com.ros.bean.User;
import com.ros.service.UserService;
import com.ros.utils.ValidateCode;

@Controller
public class UserController {
	@Autowired
	UserService userservice;

	/*
	 * 用户登录
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Msg login(User user) {
		int id=userservice.getUserId(user.getUserName());
		User rUser=userservice.getUserbyID(id);
		if (userservice.checkUser(user)) {
			return Msg.success().add("userId", id).add("userRole", rUser.getUserRole());
		} else {
			return Msg.fail().add("Failed", "用户名密码不正确");
		}
	}

	/*
	 * 检查用户名是否存在
	 */
	@RequestMapping(value = "/checkUsername", method = RequestMethod.POST)
	@ResponseBody
	public Msg checkUsername(String userName) {
		if (userservice.existUser(userName)) {
			return Msg.success().add("Success", "Exist User:" + userName);
		} else {
			return Msg.fail().add("Failed", "NO User:" + userName);
		}
	}

	/*
	 * 用户注册
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public Msg register(User user) {
		if (userservice.existUser(user.getUserName())) {
			return Msg.fail().add("注册失败", "用户名已存在");
		}
		if (userservice.insertUser(user)) {
			return Msg.success().add("注册成功", user);
		} else {
			return Msg.fail().add("注册失败", user);
		}
	}

	/*
	 * 修改用户
	 */
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	@ResponseBody
	public Msg updateUser(User user) {
		System.out.println(user);
		if (userservice.update(user)) {
			return Msg.success().add("updateUser", user);
		} else {
			return Msg.fail().add("updateUser", user);
		}
	}

	/*
	 * 删除用户
	 */
	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	@ResponseBody
	public Msg deleteUser(int userId) {
		if (userservice.deleteUser(userId)) {
			return Msg.success().add("deleteUser", userId);
		} else {
			return Msg.fail().add("deleteUser", userId);
		}
	}

	/*
	 * 查询所有用户
	 */
	@RequestMapping(value = "/getAllUser", method = RequestMethod.POST)
	@ResponseBody
	public Msg getAllUser() {
		List<User> users = userservice.getAllUser();
		return Msg.success().add("Users", users);
	}

	/*
	 * 查询单个用户
	 */
	@RequestMapping(value = "/getUserbyId", method = RequestMethod.POST)
	@ResponseBody
	public Msg getUserbyId(int userId) {
		User user = userservice.getUserbyID(userId);
		return Msg.success().add("User", user);
	}
	/*
	 * 检查验证码是否正确
	 */

	@RequestMapping(value = "/checkcode", method = RequestMethod.POST)
	public String checkcode(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().setAttribute("message", "");
		// 1. 获取请求参数: CHECK_CODE_PARAM_NAME
		String paramCode = request.getParameter("CHECK_CODE_PARAM_NAME");

		// 2. 获取 session 中的 CHECK_CODE_KEY 属性值
		String sessionCode = (String) request.getSession().getAttribute("CHECK_CODE_KEY");

		System.out.println(paramCode);
		System.out.println(sessionCode);

		// 3. 比对. 看是否一致, 若一致说明验证码正确, 若不一致, 说明验证码错误
		if (!(paramCode != null && paramCode.equals(sessionCode))) {
			request.getSession().setAttribute("message", "验证码不一致!");
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}

		System.out.println("受理请求!");
		return ("success");

	}

	/*
	 * 获取验证码
	 */
	@RequestMapping(value = "/getcode", method = RequestMethod.POST)
	public void getVcode(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HashMap<String, Object> map = new HashMap<String, Object>();
		ValidateCode validateCode = new ValidateCode();
		map = validateCode.getCode();
		// 获取验证码字符
		String CHECK_CODE_KEY = (String) map.get("CHECK_CODE_KEY");

		BufferedImage buffImg = (BufferedImage) map.get("IMG");

		System.out.println(CHECK_CODE_KEY);
		// 把存放有所有随机字符的 StringBuffer 对应的字符串放入到 HttpSession 中
		request.getSession().setAttribute("CHECK_CODE_KEY", CHECK_CODE_KEY);
		// 禁止图像缓存
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		// 将图像输出到输出流中
		ServletOutputStream sos = null;
		sos = response.getOutputStream();
		ImageIO.write(buffImg, "jpeg", sos);
		sos.close();

	}

}
