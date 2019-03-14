package com.zhoubo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhoubo.basic.Result;
import com.zhoubo.pojo.User;
import com.zhoubo.rabbit.Product;
import com.zhoubo.service.UserService;

@Controller
public class Register {
	@Autowired
	@Qualifier("usi")
	UserService usi;
	
	@Autowired
	Product product;
	
	private static Logger logger = LoggerFactory.getLogger(Register.class);
	
	@RequestMapping("/registerPage")
	public String registerPage(HttpServletRequest request, HttpServletResponse response){
		System.out.println("注册页面超链接请求");
		/*
		 * spring mvc 中页面跳转，直接使用return若是在有视图解析器的条件下，则会加上视图解析器的前缀，
		 * 若是没有视图解析器，则会根据return的值进行查找。
		 * 
		 */
		return "/page/register";
	}
	
	
	@RequestMapping("/register")
	@ResponseBody
	public Result tokenName(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="registerName",required = true) String registerName,
			@RequestParam(value="registerPsw", required=true) String registerPsw){
		/*System.out.println("注册请求");
		System.out.println(registerName);
		System.out.println(registerPsw);*/
		logger.info("注册请求"+"registerName = "+registerName+"registerPsw ="+registerPsw);
		Result result =usi.selectByName(registerName);
		/*System.out.println("Register:"+result);*/
		logger.info("result = " + result);
		int i = 10;
		while(i < 10){
			product.send(registerName, registerPsw);
		}
		//String tokenUuid = UUID.randomUUID().toString().replace("-", "");
		if(result.getStatus() == 0){
			User user = new User(registerName, registerPsw);
			int count = usi.addUser(user);
			logger.info("插入用户数=" + count);
			if(count != 0){
				/*result.setMessage("注册成功");*/
				logger.info("注册成功"+count);
				System.out.println(result);
				//return result;
			}else if(count == 0){
				/*result.setMessage("重复注册，请重试");*/
				logger.info("注册失败" + count);
				System.out.println(result);
				//return result;
			}
			return result;
		}else {
			/*result.setMessage("该用户名已被注册");*/
			logger.info("该用户名已被注册");
			return result;
		}
	}
	

}
