package com.ros.controller;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ros.bean.Msg;
import com.ros.bean.Order;
import com.ros.bean.User;
import com.ros.service.FoodService;
import com.ros.service.OrderService;
import com.ros.service.UserService;

@Controller
public class OrderController {
	@Autowired
	OrderService orderService;
	@Autowired
	FoodService foodService;
	@Autowired
	UserService userService;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date date = new Date();

	/*
	 * ���ɶ���
	 * 
	 */
	@RequestMapping(value = "/addOrder", method = RequestMethod.POST)
	@ResponseBody
	public Msg addOrder(Order order) {
		System.out.println("ready to add order��" + order.toString());

		if (orderService.addOrder(order)) {
			// �����µ�����
			String[] foodIds = order.getOrderFoodId().split(",");
			for (int i = 0; i < foodIds.length; i++) {
				System.out.println("update foodordertimes. foodId:  " + Integer.parseInt(foodIds[i]));
				foodService.updateOrdertime(Integer.parseInt(foodIds[i]));
			}
			return Msg.success().add("addOrder", order);
		} else {
			return Msg.fail();
		}
	}

	/*
	 * ��ȡ���ж���
	 */

	@RequestMapping(value = "/getAllorder", method = RequestMethod.POST)
	@ResponseBody
	public Msg getAllorder() {
		System.out.println(date.toString());
		List<Order> orders = orderService.getAllOrder();
		System.out.println(orders.toString());
		return Msg.success().add("Orders", orders);
	}

	/*
	 * ��ȡָ���û����� �����û�Id �����û���+�û�����
	 */
	@RequestMapping(value = "/getorderByuserId", method = RequestMethod.POST)
	@ResponseBody
	public Msg getorderByuserId(int userId) {
		System.out.println(userId);
		User user = userService.getUserbyID(userId);
		List<Order> orders = orderService.getOrderbyUserId(userId);
		return Msg.success().add("userName", user.getUserName()).add("Orders", orders);
	}

	/*
	 * ��ɶ��� ����ָ������״̬ 0>1 ���� orderId
	 */
	@RequestMapping(value = "/finishOrder", method = RequestMethod.POST)
	@ResponseBody
	public Msg updateOrder(int orderId) {
		// SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
		// String date = df.format(new Date());
		if (orderService.finishOrder(orderId)) {
			return Msg.success().add("finishOrder", orderId);
		} else {
			return Msg.fail();
		}
	}
	/*
	 * ��ע��������ñ��������Ĳ�������ֵ
	 */
	// @InitBinder
	// public void initBinder(WebDataBinder binder){
	// binder.setDisallowedFields("lastName");
	// }
}
