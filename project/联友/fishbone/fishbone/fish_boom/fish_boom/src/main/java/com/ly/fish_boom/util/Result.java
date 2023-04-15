package com.ly.fish_boom.util;

import java.util.Collection;
import java.util.List;

public class Result {
	public static int SUCCESS_CODE = 0;
	public static int FAIL_CODE = 1;
	
	Object list;
	int code;
	String message;
	int count;
	long total;
	private Result(int code, String message, Object list) {
		this.code = code;
		this.message = message;
		this.list = list;
		if(list instanceof Collection)
		   this.count = ((Collection) list).size();
	}
	private Result(int code, String message, Object list,long total) {
		this.code = code;
		this.message = message;
		this.list = list;
		this.total=total;
		if(list instanceof Collection)
			this.count = ((Collection) list).size();
	}

	public static Result success() {
		return new Result(SUCCESS_CODE,"",null);
	}
	public static Result success(Object list) {
		return new Result(SUCCESS_CODE,"",list);
	}
	public static Result success(Object list,long total) {
		return new Result(SUCCESS_CODE,"",list,total);
	}
	public static Result fail(String message) {
		return new Result(FAIL_CODE,message,null);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getList() {
		return list;
	}

	public void setList(Object list) {
		this.list = list;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
}
