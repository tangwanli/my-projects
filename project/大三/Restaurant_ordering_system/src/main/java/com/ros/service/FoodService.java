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
	 * 获取所有菜名
	 */
	public List<Food> getAllfood() {
		List<Food> foods = foodMapper.selectByExample(null);
		return foods;
	}
	
	/*
	 * 更新下单次数
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
	 * 按下单次数对菜名排序
	 */
	public List<Food> gethotfood() {
		FoodExample example = new FoodExample();
		example.setOrderByClause("food_ordertimes");
		List<Food> foods = foodMapper.selectByExample(example);
		return foods;
	}
	/*
	 * 获取指定菜类下的所有菜名
	 */
	public List<Food> getAllfoodbyType(int typeid) {
		FoodExample example = new FoodExample();
		Criteria criteria = example.createCriteria();
		criteria.andFoodtypeIdEqualTo(typeid);
		List<Food> foods = foodMapper.selectByExample(example);
		return foods;
	}

	/*
	 * 添加菜信息
	 */
	public boolean addfood(Food food) {
		if (foodMapper.insertSelective(food) == 1) {
			return true;
		} else {
			return false;
		}
	}
	/*
	 * 删除菜信息
	 */
	public boolean deletefood(int foodId) {
		if (foodMapper.deleteByPrimaryKey(foodId) == 1) {
			return true;
		} else {
			return false;
		}
	}
	/*
	 * 修改菜信息
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