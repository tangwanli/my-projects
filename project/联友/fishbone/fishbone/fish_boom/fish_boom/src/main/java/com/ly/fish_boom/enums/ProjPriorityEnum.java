package com.ly.fish_boom.enums;

import java.io.Serializable;


import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ProjPriorityEnum implements IEnum{
	LOW(0,"低"),
	ORDINARY(1,"普通"),
	HIGH(2,"高"),
	IMPORTANT(3,"非常重要");
	
	private int code;
	private String desc;
	ProjPriorityEnum(final int code,final String desc){
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
