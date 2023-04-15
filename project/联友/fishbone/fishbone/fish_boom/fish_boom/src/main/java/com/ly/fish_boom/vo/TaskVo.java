/**
 * File TaskVo.java
 * Data	Author	Changes
 * 2019年10月17日 上午11:03:45	ly-lizhyi	
 */
package com.ly.fish_boom.vo;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.ly.fish_boom.aop.MyLog;
import com.ly.fish_boom.entity.Proj;
import com.ly.fish_boom.entity.Task;
import com.ly.fish_boom.entity.User;
import com.ly.fish_boom.enums.PercentEnum;
import com.ly.fish_boom.enums.TaskPriorityEnum;
import com.ly.fish_boom.enums.TaskStatusEnum;

import cn.hutool.core.lang.Console;

/**
 * 
 * @author ly-lizhyi 2019年10月17日 上午11:03:45
 * @version 1.0
 */
public class TaskVo extends Task {
	@MyLog(desc="负责人")
	private List<User> ff;
	@MyLog(desc="抄送人")
	private List<User> cc;
	@MyLog(desc="所属项目")
	private ProjectVo project;

	public List<User> getFf() {
		return ff;
	}
	public void setFf(List<User> ff) {
		this.ff = ff;
	}
	public List<User> getCc() {
		return cc;
	}
	public void setCc(List<User> cc) {
		this.cc = cc;
	}
	public ProjectVo getProject() {
		return project;
	}
	public void setProject(ProjectVo project) {
		this.project = project;
	}
	@Override
	public String toString() {
		return "TaskVo [ff=" + ff + ", cc=" + cc + ", project=" + project + "]";
	}
	
 }
