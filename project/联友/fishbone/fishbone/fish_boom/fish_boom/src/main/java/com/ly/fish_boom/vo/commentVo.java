/**
 * File commentVo.java
 * Data	Author	Changes
 * 2019年11月6日 下午3:31:31	ly-lizhyi	
 */
package com.ly.fish_boom.vo;

import org.apache.log4j.Logger;

import com.ly.fish_boom.entity.Opera;

/**
 * 
 * @author ly-lizhyi 2019年11月6日 下午3:31:31
 * @version 1.0
 */
public class commentVo extends Opera{
	private static Logger LOG = Logger.getLogger(commentVo.class);
	private Integer subject_id;
	private String type;
	private String subject_name;
	
	public Integer getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(Integer subject_id) {
		this.subject_id = subject_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getSubject_name() {
		return subject_name;
	}
	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}
	@Override
	public String toString() {
		return "commentVo [type=" + type + "]";
	}
	
}
