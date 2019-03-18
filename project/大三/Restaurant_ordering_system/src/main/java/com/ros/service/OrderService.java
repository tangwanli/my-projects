package com.ros.service;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ros.bean.Order;
import com.ros.bean.OrderExample;
import com.ros.bean.OrderExample.Criteria;
import com.ros.dao.OrderMapper;

@Service
public class OrderService {
	@Autowired
	OrderMapper orderMapper;

	/*
	 * ���ɶ���
	 */
	public boolean addOrder(Order order) {
		if (orderMapper.insertSelective(order)==1) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * ɾ������
	 */
	public boolean deleteOrderbyOrderId(int orderId) {
		if (orderMapper.deleteByPrimaryKey(orderId) == 1) {
			return true;
		} else {
			return false;
		}
	}

	
	/*
	 * ����orderId�޸Ķ���״̬Ϊ1
	 */
	public boolean finishOrder(int orderId) {
		Order order=new Order();
		order.setOrderId(orderId);
		order.setOrderStatus(1);
		order.setOderFinishtime(new Date());
		if(orderMapper.updateByPrimaryKeySelective(order)==1)
		{return true;	
		}
		else {
			return false;		
		}
	}

	/*
	 * ��ѯ���ж���
	 */
	public List<Order> getAllOrder() {
		List<Order> orders=orderMapper.selectByExample(null);
		return orders;
	}

	/*
	 * ��ѯָ���û�����
	 */
	public List<Order> getOrderbyUserId(int userId) {
		OrderExample example = new OrderExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		List<Order> orders=orderMapper.selectByExample(example);
		return orders;	
	}

}
