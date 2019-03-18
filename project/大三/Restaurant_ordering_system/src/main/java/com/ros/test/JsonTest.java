package com.ros.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ros.bean.Food;
import com.ros.bean.Foodtype;
import com.ros.dao.FoodMapper;
import com.ros.service.FoodTypeService;
import com.ros.service.UserService;
@Controller
public class JsonTest {
	@Autowired
	FoodMapper foodMapper;
	@Autowired
	private FoodTypeService foodTypeService;
	@Autowired
	private UserService userService;
	@RequestMapping(value="/json",method=RequestMethod.GET)
    @ResponseBody
	public Map<String, Object>  returnJson(HttpServletRequest req) {
		System.out.println(req.getMethod());
		System.out.println("接收到页面发来的json请求！！");
		List<Food> foods  =foodMapper.selectByExample(null);
		Map<String, Object> modelmap=new HashMap<String, Object>();
		modelmap.put("Foods",foods );
		return modelmap;
	}
	@RequestMapping(value="/alltype",method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getAlltype() {
		/*FoodtypeExample example=new FoodtypeExample();
	    Criteria criteria=example.createCriteria();
		criteria.andFoodtypeNameIsNotNull();*/
		Map<String, Object> modelmap=new HashMap<String, Object>();
		List<Foodtype> foodtypes=foodTypeService.getAlltype();
		modelmap.put("Types",foodtypes );
		return modelmap;
	}
	@RequestMapping(value="/xxx",method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getAlltype1() {
		userService.getUserId("Hey");
		Map<String, Object> modelmap = null;
		return modelmap;
	}
}

