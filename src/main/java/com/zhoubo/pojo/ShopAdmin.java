package com.zhoubo.pojo;

import java.sql.Timestamp;

public class ShopAdmin {

	int id;
	String name;
	String pass;
	int type;
	Timestamp createDate;
	String creator;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public ShopAdmin(String name, String pass, int type, Timestamp createDate,
			String creator) {
		super();
		this.name = name;
		this.pass = pass;
		this.type = type;
		this.createDate = createDate;
		this.creator = creator;
	}
	public ShopAdmin() {
		super();
	}
	public ShopAdmin(String name, String pass) {
		super();
		this.name = name;
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "ShopAdmin [id=" + id + ", name=" + name + ", pass=" + pass
				+ ", type=" + type + ", createDate=" + createDate
				+ ", creator=" + creator + "]";
	}
	
	
	
	
}
