package com.zhoubo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhoubo.dao.CategoryMapper;
import com.zhoubo.pojo.Category;
@Service("csi")
public class CategoryServiceImp implements CategoryService {

	@Autowired
	CategoryMapper categoryMapper;
	
	@Override
	public List<Category> getCategoryS() {
		List<Category> categories = categoryMapper.getCategoryS();
		return categories;
	}

}
