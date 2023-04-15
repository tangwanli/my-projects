package com.ly.fish_boom.enums;

import java.io.Serializable;


import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TaskTypeEnum implements IEnum{
	ORDINARY(0,"普通"),
	BATCH(1,"批量");
	
	private int code;
	private String desc;
	TaskTypeEnum(final int code,final String desc){
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
