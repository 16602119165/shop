package com.zhoubo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zhoubo.pojo.Category;

@Repository
public interface CategoryMapper {

	List<Category> getCategoryS();

}
