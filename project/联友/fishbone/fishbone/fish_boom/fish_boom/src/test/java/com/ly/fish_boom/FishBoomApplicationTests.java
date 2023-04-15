package com.ly.fish_boom;

import java.lang.annotation.Annotation;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.datetime.joda.DateTimeFormatterFactory;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ly.fish_boom.entity.Itera;
import com.ly.fish_boom.entity.User;
import com.ly.fish_boom.enums.IteraEnum;
import com.ly.fish_boom.mapper.IterateMapper;
import com.ly.fish_boom.mapper.UserMapper;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.EnumUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FishBoomApplicationTests {
	@Autowired
	private UserMapper um;
	@Autowired
	private IterateMapper im;
	@Test
	public void UserList(){
		Page<User> page=new Page<>(0, 5);
		Page<User> result=(Page<User>) um.selectPage(page, null);
		Console.log(result);
	}
	@Test
	public void userInsert(){
		User u=new User();
		u.setDept("智能网联");
		u.setName("King");
		u.setPosition("软件工程师");
		u.setPassword("123");
		um.insert(u);
	}
	@Test
	public void addTest() {
		Itera it=new Itera();
		it.setCreatDate(LocalDateTime.now());
		String status="进行中";
		Map<String, Object> enumMap=EnumUtil.getNameFieldMap(IteraEnum.class, "desc");
		Console.log((IteraEnum)enumMap.get(status));
		it.setStatus((IteraEnum)enumMap.get(status));
		im.insert(it);
	}
	@Test
	public void selectTest() {
		List<Itera> ls=im.selectList(null);
		Console.log(ls);
	}
}
