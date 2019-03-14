package com.zhoubo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhoubo.basic.Result;
import com.zhoubo.dao.UserMapper;
import com.zhoubo.pojo.User;
@Service("usi")
public class UserServiceImp implements UserService{

	@Autowired
	UserMapper um;
	
	@Override
	public Result selectByName(String registerName) {
		Result result = new Result();
		result.setStatus(um.selectByName(registerName));
		System.out.println(result);
		return result;
		}

	@Override
	public int addUser(User user) {
		int count = um.addUser(user);
		return count;
	}
	
	
}
