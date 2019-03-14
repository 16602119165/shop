package com.zhoubo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhoubo.basic.Result;
import com.zhoubo.pojo.CurrentUser;
import com.zhoubo.pojo.ShopAdmin;
import com.zhoubo.service.LoginService;


@Controller
public class Login{
	
	private static Logger logger = LoggerFactory.getLogger(Login.class);
	
	@Autowired
	@Qualifier("ls")
	LoginService ls;

	@RequestMapping("/loginPage")
	public String loginPage(HttpServletRequest request,HttpServletResponse response){
		return "/page/login";
	}
	
	@ResponseBody
	@RequestMapping("/login")
	public Result login(HttpServletRequest request, HttpServletResponse response){
		
		logger.info("登录请求");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		logger.info("登录用户名："+ name);
		logger.info("登录密码："+ pass);
		Result result = new Result();
		if(null == name || null == pass){
			result.setStatus(1);
			result.setMessage("用户名密码不能为空，程序错误");
			return result;
		}
		ShopAdmin shopAdmin = ls.selectByName(name, pass);
		logger.info("shopAdmin =", shopAdmin);
		if(null == shopAdmin){
			result.setStatus(1);
			result.setData(shopAdmin);
			result.setMessage("用户不存在，请重试");
			return result;
		}
		result.setStatus(0);
		result.setData(shopAdmin);
		result.setMessage("登录成功");
		CurrentUser cu = new CurrentUser(shopAdmin.getType(), shopAdmin.getName());
		HttpSession session = request.getSession();
		session.setAttribute("cu", cu);
 		return result;
	}
	
	
	
}
