package com.zhoubo.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zhoubo.dto.ProductDTO;
import com.zhoubo.pojo.Product;
@Repository
public interface ProductMapper {
	
	List<Product> seleProducts(@Param("productDTO")ProductDTO productDTO);
	long count1(@Param("productDTO")ProductDTO productDTO);
	
	int insertByExcel(@Param(value="products")List<Product> products);
	
}
