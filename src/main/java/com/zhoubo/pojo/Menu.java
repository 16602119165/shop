package com.zhoubo.pojo;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Menu {
	
	int id;
	int menuType;
	int menuParentId;
	int stat;
	String menuName;
	String creator;
	Timestamp createDate;
	Timestamp updateTime;
	private String pageUrl;
	
	public String getPageUrl() {
		return pageUrl;
	}
	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMenuType() {
		return menuType;
	}
	public void setMenuType(int menuType) {
		this.menuType = menuType;
	}
	public int getMenuParentId() {
		return menuParentId;
	}
	public void setMenuParentId(int menuParentId) {
		this.menuParentId = menuParentId;
	}
	public int getStat() {
		return stat;
	}
	public void setStat(int stat) {
		this.stat = stat;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public Menu(int menuType, int menuParentId, int stat, String menuName,
			String creator, Timestamp createDate, Timestamp updateTime) {
		super();
		this.menuType = menuType;
		this.menuParentId = menuParentId;
		this.stat = stat;
		this.menuName = menuName;
		this.creator = creator;
		this.createDate = createDate;
		this.updateTime = updateTime;
	}
	public Menu() {
		super();
	}
	@Override
	public String toString() {
		return "Menu [id=" + id + ", menuType=" + menuType + ", menuParentId="
				+ menuParentId + ", stat=" + stat + ", menuName=" + menuName
				+ ", creator=" + creator + ", createDate=" + createDate
				+ ", updateTime=" + updateTime + "]";
	}
	

}
