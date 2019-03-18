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
	 * �û���¼
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Msg login(User user) {
		int id=userservice.getUserId(user.getUserName());
		User rUser=userservice.getUserbyID(id);
		if (userservice.checkUser(user)) {
			return Msg.success().add("userId", id).add("userRole", rUser.getUserRole());
		} else {
			return Msg.fail().add("Failed", "�û������벻��ȷ");
		}
	}

	/*
	 * ����û����Ƿ����
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
	 * �û�ע��
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public Msg register(User user) {
		if (userservice.existUser(user.getUserName())) {
			return Msg.fail().add("ע��ʧ��", "�û����Ѵ���");
		}
		if (userservice.insertUser(user)) {
			return Msg.success().add("ע��ɹ�", user);
		} else {
			return Msg.fail().add("ע��ʧ��", user);
		}
	}

	/*
	 * �޸��û�
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
	 * ɾ���û�
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
	 * ��ѯ�����û�
	 */
	@RequestMapping(value = "/getAllUser", method = RequestMethod.POST)
	@ResponseBody
	public Msg getAllUser() {
		List<User> users = userservice.getAllUser();
		return Msg.success().add("Users", users);
	}

	/*
	 * ��ѯ�����û�
	 */
	@RequestMapping(value = "/getUserbyId", method = RequestMethod.POST)
	@ResponseBody
	public Msg getUserbyId(int userId) {
		User user = userservice.getUserbyID(userId);
		return Msg.success().add("User", user);
	}
	/*
	 * �����֤���Ƿ���ȷ
	 */

	@RequestMapping(value = "/checkcode", method = RequestMethod.POST)
	public String checkcode(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().setAttribute("message", "");
		// 1. ��ȡ�������: CHECK_CODE_PARAM_NAME
		String paramCode = request.getParameter("CHECK_CODE_PARAM_NAME");

		// 2. ��ȡ session �е� CHECK_CODE_KEY ����ֵ
		String sessionCode = (String) request.getSession().getAttribute("CHECK_CODE_KEY");

		System.out.println(paramCode);
		System.out.println(sessionCode);

		// 3. �ȶ�. ���Ƿ�һ��, ��һ��˵����֤����ȷ, ����һ��, ˵����֤�����
		if (!(paramCode != null && paramCode.equals(sessionCode))) {
			request.getSession().setAttribute("message", "��֤�벻һ��!");
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}

		System.out.println("��������!");
		return ("success");

	}

	/*
	 * ��ȡ��֤��
	 */
	@RequestMapping(value = "/getcode", method = RequestMethod.POST)
	public void getVcode(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HashMap<String, Object> map = new HashMap<String, Object>();
		ValidateCode validateCode = new ValidateCode();
		map = validateCode.getCode();
		// ��ȡ��֤���ַ�
		String CHECK_CODE_KEY = (String) map.get("CHECK_CODE_KEY");

		BufferedImage buffImg = (BufferedImage) map.get("IMG");

		System.out.println(CHECK_CODE_KEY);
		// �Ѵ������������ַ��� StringBuffer ��Ӧ���ַ������뵽 HttpSession ��
		request.getSession().setAttribute("CHECK_CODE_KEY", CHECK_CODE_KEY);
		// ��ֹͼ�񻺴�
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		// ��ͼ��������������
		ServletOutputStream sos = null;
		sos = response.getOutputStream();
		ImageIO.write(buffImg, "jpeg", sos);
		sos.close();

	}

}
