package com.zhoubo.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhoubo.basic.Result;
import com.zhoubo.dao.ProductMapper;
import com.zhoubo.dto.ProductDTO;
import com.zhoubo.pojo.Product;
import com.zhoubo.pojo.UIDatagrid;
import com.zhoubo.util.DateUtil;
@Service("psi")
public class ProductServiceImp implements ProductService,POIService {

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
	/* 
	 * @see com.zhoubo.service.POIService#read()
	 */
	@Override
	public Result read(List<String[]> strings) {
		List<Product> products = new ArrayList<Product>();
		Result result = new Result();
		for(String[] string : strings) {
			//该对象必须要在for循环里创建，不然只有一个product对象，赋值一直是for循环的最后一个值
			Product product = new Product();
			//product.setId(Integer.parseInt(string[0]));
			product.setCategoryParentId(new Double(Double.parseDouble(string[0])).intValue());
			product.setProductType(new Double(Double.parseDouble(string[1])).intValue());
			product.setProductStock(new Double(Double.parseDouble(string[2])).intValue());
			product.setProductCreateDate(DateUtil.dateToTimestamp(new Date(), "yyyy-mm-dd HH-mm-ss"));
			product.setProductUpdateTime(product.getProductCreateDate());
			//product.setProductUpdateTime(DateUtil.stringToTimestamp(n, "yyyy-mm-dd HH-mm-ss"));
			//product.setProductCreateDate(DateUtil.stringToTimestamp(string[4], "yyyy-mm-dd HH-mm-ss"));
			product.setProductPrice(new BigDecimal(string[3]));
			product.setProductActivityPrice(new BigDecimal(string[4]));
			product.setProductCreator(string[5]);
			product.setProductName(string[6]);
			product.setCategoryName(string[7]);
			products.add(product);
		}
		List<Product> productlList = productMapper.checkByName(products);
		if(productlList.size() == 0) {
			int total = productMapper.insertByExcel(products);
			if(total != 0) {				
				result.setStatus(0);
				result.setMessage("文件中不存在重复数据，且已读取成功；读取记录为:" + String.valueOf(total));
				return result;	
			}
			else {
				result.setStatus(1);
				result.setMessage("文件中不存在重复数据，但读取失败，请联系开发者");
				return result;	
			}
		}else {
			List<String> repeatNameList = new ArrayList<String>();
			result.setStatus(1);
			result.setMessage("文件中存在重复数据或与数据库有重复数据，请重新检查数据并重新上传");
			for(Product p : productlList) {
				String repeatName = p.getProductName();
				repeatNameList.add(repeatName);
			}
			result.setData(repeatNameList);
			return result;
		}
		
	}

}
