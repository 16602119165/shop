package com.zhoubo.service;

import java.util.List;

import com.zhoubo.dto.ProductDTO;
import com.zhoubo.pojo.Product;
import com.zhoubo.pojo.UIDatagrid;

public interface ProductService {

	UIDatagrid<Product> getDatagrid(ProductDTO productDTO);
	
	List<Product> getProducts(ProductDTO productDTO);
	long getCount(ProductDTO productDTO);
	
	
	
}
