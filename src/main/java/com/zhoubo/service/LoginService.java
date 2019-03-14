package com.zhoubo.service;
import com.zhoubo.pojo.ShopAdmin;


public interface LoginService {
	
	//public String creatToken();
	//后台管理系统登录验证
	public ShopAdmin selectByName(String name, String pass);
}
