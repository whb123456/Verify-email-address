package com.zhangwei.entity;

import java.io.Serializable;
import java.util.Date;

public class WorkDataEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer index;
	private String workName;
	private String describe;
	private String level;
	private Date lastTime;
	private Integer status;
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public String getWorkName() {
		return workName;
	}
	public void setWorkName(String workName) {
		this.workName = workName;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Date getLastTime() {
		return lastTime;
	}
	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "WorkDataEntity [index=" + index + ", workName=" + workName + ", describe=" + describe + ", level="
				+ level + ", lastTime=" + lastTime + ", status=" + status + "]";
	}
	

	
	
}
