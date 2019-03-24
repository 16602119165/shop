/**
 * 
 */
package com.zhoubo.enums;

/**
 * @author Administrator
 *
 */
public enum FileUpload {

	productDir(10,"F:\\Photo\\");
	
	private Integer code;
	private String dir;
	
	public Integer getCode() {
		return code;
	}
	
	public void setCode(Integer code) {
		this.code = code;
	}
	
	public String getDir() {
		return dir;
	}
	
	public void setDir(String dir) {
		this.dir = dir;
	}

	private FileUpload(Integer code, String dir) {
		this.code = code;
		this.dir = dir;
	}
	
	
}
