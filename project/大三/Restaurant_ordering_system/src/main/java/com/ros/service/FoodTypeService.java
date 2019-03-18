package com.ros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ros.bean.Foodtype;

import com.ros.dao.FoodtypeMapper;
@Service
public class FoodTypeService {
	/*
	 * 取菜类表下所有数据
	 */
	@Autowired
	private FoodtypeMapper foodtypeMapper;
	
	public List<Foodtype> getAlltype() {
		/*FoodtypeExample example=new FoodtypeExample();
	    Criteria criteria=example.createCriteria();
		criteria.andFoodtypeNameIsNotNull();*/
		List<Foodtype> foodtypes=foodtypeMapper.selectByExample(null);
		return foodtypes;
	}
}
