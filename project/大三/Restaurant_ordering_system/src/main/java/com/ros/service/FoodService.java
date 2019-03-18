package com.ros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ros.bean.Food;
import com.ros.bean.FoodExample;
import com.ros.bean.FoodExample.Criteria;
import com.ros.dao.FoodMapper;

@Service
public class FoodService {
	@Autowired
	private FoodMapper foodMapper;

	/*
	 * ��ȡ���в���
	 */
	public List<Food> getAllfood() {
		List<Food> foods = foodMapper.selectByExample(null);
		return foods;
	}
	
	/*
	 * �����µ�����
	 */
	
	public void updateOrdertime(int foodId) {
		 Food food=foodMapper.selectByPrimaryKey(foodId);
		 System.out.println(food.toString());
		 int foodOrdertimes=food.getFoodOrdertimes()+1;
		 food.setFoodOrdertimes(foodOrdertimes);
		  foodMapper.updateByPrimaryKeySelective(food);
		  System.out.println(food.toString());
	}
	/*
	 * ���µ������Բ�������
	 */
	public List<Food> gethotfood() {
		FoodExample example = new FoodExample();
		example.setOrderByClause("food_ordertimes");
		List<Food> foods = foodMapper.selectByExample(example);
		return foods;
	}
	/*
	 * ��ȡָ�������µ����в���
	 */
	public List<Food> getAllfoodbyType(int typeid) {
		FoodExample example = new FoodExample();
		Criteria criteria = example.createCriteria();
		criteria.andFoodtypeIdEqualTo(typeid);
		List<Food> foods = foodMapper.selectByExample(example);
		return foods;
	}

	/*
	 * ��Ӳ���Ϣ
	 */
	public boolean addfood(Food food) {
		if (foodMapper.insertSelective(food) == 1) {
			return true;
		} else {
			return false;
		}
	}
	/*
	 * ɾ������Ϣ
	 */
	public boolean deletefood(int foodId) {
		if (foodMapper.deleteByPrimaryKey(foodId) == 1) {
			return true;
		} else {
			return false;
		}
	}
	/*
	 * �޸Ĳ���Ϣ
	 */
	
	public boolean updatefood(Food food) {
		if(foodMapper.updateByPrimaryKeySelective(food)==1) {
			return true;
		}
		else {
			return false;
		}		
	}

}