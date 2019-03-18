package com.zhoubo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhoubo.dao.ProductMapper;
import com.zhoubo.dto.ProductDTO;
import com.zhoubo.pojo.Product;
import com.zhoubo.pojo.UIDatagrid;
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


	@Override
	public UIDatagrid<Product> getDatagrid(ProductDTO productDTO) {
		UIDatagrid<Product> datagrid = new UIDatagrid<Product>();
		long count = productMapper.count1(productDTO);
		List<Product> products = productMapper.seleProducts(productDTO);
		datagrid.setTotal(count);
		datagrid.setRows(products);
		return datagrid;
	}

}
