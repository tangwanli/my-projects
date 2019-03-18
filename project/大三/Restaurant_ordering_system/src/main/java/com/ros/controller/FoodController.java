package com.ros.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ros.bean.Food;
import com.ros.bean.Foodtype;
import com.ros.bean.Msg;
import com.ros.service.FoodService;
import com.ros.service.FoodTypeService;

@Controller
public class FoodController {
	@Autowired
	private FoodService foodService;
	@Autowired
	private FoodTypeService foodTypeService;

	/*
	 * 获取所有菜品（分类）
	 */
	@RequestMapping(value = "/getAllfoodWithType", method = RequestMethod.POST)
	@ResponseBody
	public Msg getAllfoodWithType() {
		Map<String, Object> modelmap = new HashMap<String, Object>();
		List<Foodtype> foodtypes = foodTypeService.getAlltype();
		for (int i = 0; i < foodtypes.size(); i++) {
			List<Food> foods = foodService.getAllfoodbyType(foodtypes.get(i).getFoodtypeId());
			modelmap.put(foodtypes.get(i).getFoodtypeName(), foods);
		}
		return Msg.success().add("FoodsWithType", modelmap);
	}

	/*
	 * 获取所有菜品（不分类）
	 */
	@RequestMapping(value = "/getAllfood", method = RequestMethod.POST)
	@ResponseBody
	public Msg getAllfood() {
		List<Food> foods = foodService.getAllfood();
		return Msg.success().add("Foods", foods);

	}

	/*
	 * 获取热门菜品前五（不分类）
	 */
	@RequestMapping(value = "/gethotfood", method = RequestMethod.POST)
	@ResponseBody
	public Msg gethotfood() {
		List<Food> foods = foodService.gethotfood();
		List<Food> hotfoods = new ArrayList<Food>();
		for (int i = foods.size(); hotfoods.size() < 5; i--) {
			hotfoods.add(foods.get(i - 1));
		}
		return Msg.success().add("HotFoods", hotfoods);

	}

	/*
	 * 删除菜品
	 */
	@RequestMapping(value = "/deletefood", method = RequestMethod.POST)
	@ResponseBody
	public Msg deletefood(int foodId) {
		if (foodService.deletefood(foodId)) {
			return Msg.success().add("deletefood", foodId);
		} else {
			return Msg.fail().add("deletefood", foodId);
		}

	}

	/*
	 * 增加菜品
	 */
	@RequestMapping(value = "/addfood", method = RequestMethod.POST)
	@ResponseBody
	public Msg addfood(Food food) {
		if (foodService.addfood(food)) {
			return Msg.success().add("addFood", food);
		} else {
			return Msg.fail().add("addFood", food);
		}

	}

	/*
	 * 修改菜品
	 */
	@RequestMapping(value = "/updatefood", method = RequestMethod.POST)
	@ResponseBody
	public Msg updatefood(Food food) {
		if (foodService.updatefood(food)) {
			return Msg.success().add("updateFood", food);
		}
		return Msg.fail().add("updateFood", food);

	}

}
