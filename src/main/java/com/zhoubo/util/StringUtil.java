package com.zhoubo.util;

public class StringUtil {
	
	public static boolean isEmpty(String string){
		if(null == string || "".equals(string)){
			return true;
		}
		return false;
	}
	
	
	public static String nullToEmpty(String string){
		if(null == string){
			return "";
		}
		return string;
	}

}
