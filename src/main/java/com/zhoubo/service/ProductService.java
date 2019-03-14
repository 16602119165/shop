package com.zhoubo.service;

import java.util.List;

import com.zhoubo.dto.ProductDTO;
import com.zhoubo.pojo.Product;

public interface ProductService {

	List<Product> getProducts(ProductDTO productDTO);
	long getCount(ProductDTO productDTO);
}
