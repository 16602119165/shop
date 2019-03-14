package com.zhoubo.pojo;

public class CurrentUser {
	
	int userType;
	String userName;
	
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public CurrentUser(int userType, String userName) {
		super();
		this.userType = userType;
		this.userName = userName;
	}
	public CurrentUser() {
		super();
	}
	@Override
	public String toString() {
		return "CurrentUser [userType=" + userType + ", userName=" + userName
				+ "]";
	}
	

}
