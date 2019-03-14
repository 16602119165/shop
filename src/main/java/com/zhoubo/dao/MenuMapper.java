package com.zhoubo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zhoubo.pojo.Menu;
@Repository
public interface MenuMapper {
	
	List<Menu> selectAll(int menuType);

}
