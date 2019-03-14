package com.zhoubo.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zhoubo.pojo.ShopAdmin;

@Repository
public interface ShopAdminMapper {
	
	ShopAdmin selectByNameAndPass(@Param("name")String name, @Param("pass")String pass);
	
}
