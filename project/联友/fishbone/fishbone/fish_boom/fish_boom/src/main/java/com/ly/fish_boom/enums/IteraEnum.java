package com.ly.fish_boom.enums;

import java.io.Serializable;


import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;

public enum IteraEnum implements IEnum{
	CLOSE(0,"已关闭"),
	RUNNING(1,"进行中"),
	FINISH(2,"已完成");
	
	private int code;
	private String desc;
	IteraEnum(final int code,final String desc){
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
