package com.zhoubo.basic;

public class Result {
	int status; //0表示成功，1表示失败
	String message;
	Object data;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Result(int status, String message, Object data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}
	public Result() {
		super();
	}
	@Override
	public String toString() {
		return "Result [status=" + status + ", message=" + message + ", data="
				+ data + "]";
	}
	
	
	
	

}
