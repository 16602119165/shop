package com.zhoubo.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Attr;
import com.zhoubo.basic.Result;
import com.zhoubo.dto.ProductDTO;
import com.zhoubo.pojo.Product;
import com.zhoubo.pojo.UIDatagrid;
import com.zhoubo.service.FileService;
import com.zhoubo.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	private static Logger log = LoggerFactory.getLogger(ProductController.class);
	@Autowired
	@Qualifier("psi")
	ProductService psi;
	
	@Autowired
	@Qualifier("downloadImp")
	FileService downloadImp;
	
	@Autowired
	ProductService productServiceImp;
	
	@RequestMapping("/information")
	@ResponseBody
	public UIDatagrid<Product> queryProduct(HttpServletRequest request,HttpServletResponse response){
		log.info("商品信息请求");
		ProductDTO productDTO = new ProductDTO();
		String dateFormat = "yyyy-mm-dd HH-mm-ss";
		String categoryID = request.getParameter("categoryId");
		System.out.println("categoryId =" +categoryID);
		String categoryName = request.getParameter("categoryName");
		System.out.println("categoryName = " + categoryName);
		String productStatString = request.getParameter("productStat");
		String productName = request.getParameter("productName");
		String productCreateDateFrom = request.getParameter("productCreateDateFrom");
		String productCreateDateTproductStatStringo = request.getParameter("productCreateDateTo");
		
//		if(null != categoryID && !categoryID.equals("") || 
//				   null != categoryName && !categoryName.equals("")||
//				   null != productName && !productName.equals("") ||
//				   null != productStatString && !productStatString.equals("")) {
//					UIDatagrid<Product> datagrid = new UIDatagrid<Product>();
//				};
		
		if(null != categoryID && !categoryID.equals("")) {
				productDTO.setCategoryId(Integer.parseInt(categoryID));
				System.out.println("int categoryId" + productDTO.getCategoryId());
				
			};
			if(null != categoryName && !categoryName.equals("")) {
				productDTO.setCategoryName(categoryName);
				
			};
			if(null != productName && !productName.equals("")) {
				productDTO.setProductName(productName);
				
			};
			
			if(null != productStatString && !productStatString.equals("")) {
				int pStat = Integer.parseInt(productStatString);
				productDTO.setProductStat(pStat);
				log.info("productStat", pStat);
			};
//		if(null != productCreateDateFrom && productCreateDateFrom.equals("")) {
//			Timestamp productcreate = DateUtil.stringToTimestamp(productCreateDateFrom, dateFormat);
//			productDTO.setProductCreateDate(productcreate);
//		};
//		if(null != productCreateDateTo && productCreateDateTo.equals("")) {
//			Timestamp productUpdate = DateUtil.stringToTimestamp(productCreateDateTo, dateFormat);
//			productDTO.setProductUpdateTime(productUpdate);
//		};
		
		UIDatagrid<Product> datagrid = new UIDatagrid<Product>();
		System.out.println("productStat = "+productDTO.getProductStat());
		System.out.println("productDTO" + productDTO);
		long count = psi.getCount(productDTO);
		log.info("count =", String.valueOf(count));
		List<Product> products = psi.getProducts(productDTO);
		datagrid.setTotal(count);
		if(null != products && products.size() > 0){
			datagrid.setRows(products);
		}
//		Result result = new Result();
//		result.setStatus(0);
//		result.setData(datagrid);
		return datagrid;
	}
	//初始化商品信息页面，默认查询所有在售商品
	@RequestMapping("init")
	@ResponseBody
	public UIDatagrid<Product> productInit(){
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductStat(10);
		UIDatagrid<Product> datagrid = productServiceImp.getDatagrid(productDTO);
		if(null != datagrid) {
			return datagrid;
		}	
		return null;
	};
	//下载商品信息模板
	@RequestMapping("/downloadFile")
	@ResponseBody
	public void downloadFile(HttpServletRequest request,HttpServletResponse response) {
		response.setContentType("charset=UTF-8");
		downloadImp.getProductInformationFile(response);
	};
	
	public Result uploadFile(HttpServletRequest request) {
		return null;
	}
	
	
	
}
