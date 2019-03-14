package com.zhoubo.dao;

import org.springframework.stereotype.Repository;

import com.zhoubo.pojo.User;

@Repository
public interface UserMapper {
	
	int selectByName(String registerName);
	int addUser(User user);

}
