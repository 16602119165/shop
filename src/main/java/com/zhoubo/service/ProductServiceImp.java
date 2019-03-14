package com.zhoubo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhoubo.dao.ProductMapper;
import com.zhoubo.dto.ProductDTO;
import com.zhoubo.pojo.Product;
@Service("psi")
public class ProductServiceImp implements ProductService {

	@Autowired
	ProductMapper productMapper;
	
	@Override
	public List<Product> getProducts(ProductDTO productDTO) {
		List<Product> products = productMapper.seleProducts(productDTO);
		return products;
	}

	@Override
	public long getCount(ProductDTO productDTO) {
		long count = productMapper.count1(productDTO);
		return count;
	}

}
