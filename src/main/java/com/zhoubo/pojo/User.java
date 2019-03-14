package com.zhoubo.pojo;

public class User {
	
	int id;
	String userName;
	String password;
	String tokenUuid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTokenUuid() {
		return tokenUuid;
	}
	public void setTokenUuid(String tokenUuid) {
		this.tokenUuid = tokenUuid;
	}
	public User(int id, String userName, String password, String tokenUuid) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.tokenUuid = tokenUuid;
	}
	public User() {
		super();
	}
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
		
	}
	

}
