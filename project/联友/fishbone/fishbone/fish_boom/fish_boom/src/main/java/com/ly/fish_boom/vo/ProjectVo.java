package com.ly.fish_boom.vo;

import java.util.List;
import java.util.Map;

import com.ly.fish_boom.aop.MyLog;
import com.ly.fish_boom.entity.Proj;
import com.ly.fish_boom.entity.User;

public class ProjectVo extends Proj {
	@MyLog(desc="项目经理")
	private User pm;
	@MyLog(desc="项目成员")
	private List<User> partner;
	@MyLog(desc="抄送人")
	private List<User> cc;
	public User getPm() {
		return pm;
	}
	public void setPm(User pm) {
		this.pm = pm;
	}
	public List<User> getPartner() {
		return partner;
	}
	public void setPartner(List<User> partner) {
		this.partner = partner;
	}
	public List<User> getCc() {
		return cc;
	}
	public void setCc(List<User> cc) {
		this.cc = cc;
	}
	@Override
	public String toString() {
		return "ProjectVo [pm=" + pm + ", partner=" + partner + ", cc=" + cc + ", getId()=" + getId() + ", getName()="
				+ getName() + ", getCreator()=" + getCreator() + ", getPmUid()=" + getPmUid() + ", getCreatDate()="
				+ getCreatDate() + ", getEndDate()=" + getEndDate() + ", getPriority()=" + getPriority()
				+ ", getPartnerGid()=" + getPartnerGid() + ", getcGid()=" + getcGid() + ", getContent()=" + getContent()
				+ ", getPercent()=" + getPercent() + ", getType()=" + getType() + ", getLastUpdate()=" + getLastUpdate()
				+ ", getCode()=" + getCode() + ", getIsControl()=" + getIsControl() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
}
