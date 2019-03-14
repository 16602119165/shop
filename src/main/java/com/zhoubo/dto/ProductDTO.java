package com.zhoubo.dto;

import java.sql.Timestamp;

public class ProductDTO {

	String productName;
	int productStat = 0;
	int categoryId = 0;
	Timestamp productCreateDate;
	Timestamp productUpdateTime;
	String categoryName;
	
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductStat() {
		return productStat;
	}
	public void setProductStat(int productStat) {
		this.productStat = productStat;
	}
	public Timestamp getProductCreateDate() {
		return productCreateDate;
	}
	public void setProductCreateDate(Timestamp productCreateDate) {
		this.productCreateDate = productCreateDate;
	}
	public Timestamp getProductUpdateTime() {
		return productUpdateTime;
	}
	public void setProductUpdateTime(Timestamp productUpdateTime) {
		this.productUpdateTime = productUpdateTime;
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
	public ProductDTO(String productName, int productStat, int categoryId, Timestamp productCreateDate,
			Timestamp productUpdateTime, String categoryName) {
		super();
		this.productName = productName;
		this.productStat = productStat;
		this.categoryId = categoryId;
		this.productCreateDate = productCreateDate;
		this.productUpdateTime = productUpdateTime;
		this.categoryName = categoryName;
	}
	public ProductDTO() {
		super();
	}
	@Override
	public String toString() {
		return "ProductDTO [productName=" + productName + ", productStat=" + productStat + ", categoryId=" + categoryId
				+ ", productCreateDate=" + productCreateDate + ", productUpdateTime=" + productUpdateTime
				+ ", categoryName=" + categoryName + "]";
	}
	
	
	
}
