package com.zhoubo.service;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhoubo.pojo.UITree;

public interface MenuService {
	List<UITree> getMenuTree(HttpServletRequest request,HttpServletResponse response); 
}
