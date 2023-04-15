package com.ly.fish_boom.enums;

import java.io.Serializable;


import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TaskPriorityEnum implements IEnum{
	ORDINARY(0,"普通"),
	IMPORTANT(1,"重要"),
	EMERGENCY(2,"紧急"),
	URGENT(3,"重要紧急");
	
	private int code;
	private String desc;
	TaskPriorityEnum(final int code,final String desc){
		this.code=code;
		this.desc=desc;
		
	}
	@JsonValue
	public String getDesc() {
		return desc;
	}

	@Override
	public Serializable getValue() {
		// TODO Auto-generated method stub
		return this.code;
}
}
