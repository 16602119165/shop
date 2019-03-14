package com.zhoubo.service;

import com.zhoubo.basic.Result;
import com.zhoubo.pojo.User;

public interface UserService {
	
	Result selectByName(String registerName);
	int addUser(User user);
	
}
