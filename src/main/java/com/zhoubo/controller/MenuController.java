package com.zhoubo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhoubo.basic.Result;
import com.zhoubo.pojo.UITree;
import com.zhoubo.service.LoginService;
import com.zhoubo.service.MenuService;

@Controller
public class MenuController {
	private static Logger logger = LoggerFactory.getLogger(MenuController.class);
	
	@Autowired
	@Qualifier(value="MenuServiceImp")
	MenuService msi;
	
	@Autowired
	@Qualifier("ls")
	LoginService ls;
	
	@RequestMapping("/menuTree")
	@ResponseBody
	public Result getMenuUITree(HttpServletRequest request, HttpServletResponse response){
		logger.info("主页请求");
		Result result = new Result();
		List<UITree> menuTree = msi.getMenuTree(request, response);
		System.out.println(menuTree);
		result.setData(menuTree);
		result.setStatus(0);
		result.setMessage("ok");
		return result;
	}

}
