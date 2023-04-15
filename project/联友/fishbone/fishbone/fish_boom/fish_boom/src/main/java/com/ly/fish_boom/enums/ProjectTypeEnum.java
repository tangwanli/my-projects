package com.ly.fish_boom.enums;

import java.io.Serializable;


import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ProjectTypeEnum implements IEnum{
	WATERFALL(0,"瀑布"),
	QUICK(1,"敏捷"),
	BOARD(2,"看板");
	
	
	private int code;
	private String desc;
	ProjectTypeEnum(final int code,final String desc){
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
