package com.ly.fish_boom.enums;

import java.io.Serializable;


import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PercentEnum implements IEnum{
	ZORE(0,"0%"),
	TEN(1,"10%"),
	TWENTY(2,"20%"),
	THRITY(3,"30%"),
	FORTY(4,"40%"),
	FIFTY(5,"50%"),
	SIXTY(6,"60%"),
	SEVENTY(7,"70%"),
	EIGHTY(8,"80%"),
	NINTY(9,"90%"),
	HUNDRED(10,"100%");
	
	
	private int code;
	private String desc;
	PercentEnum(final int code,final String desc){
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
