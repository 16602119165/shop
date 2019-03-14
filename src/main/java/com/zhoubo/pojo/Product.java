package com.zhoubo.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Product {

	int id;
	int categoryParentId;
	int productType;
	int productStock;
	Timestamp productCreateDate;
	Timestamp productUpdateTime;
	BigDecimal productPrice;
	BigDecimal productActivityPrice;
	String productCreator;
	String productName;
	String categoryName;
	
	public int getCategoryParentId() {
		return categoryParentId;
	}
	public void setCategoryParentId(int categoryParentId) {
		this.categoryParentId = categoryParentId;
	}
	public int getProductType() {
		return productType;
	}
	public void setProductType(int productType) {
		this.productType = productType;
	}
	public int getProductStock() {
		return productStock;
	}
	public void setProductStock(int productStock) {
		this.productStock = productStock;
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
	public BigDecimal getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}
	public BigDecimal getProductActivityPrice() {
		return productActivityPrice;
	}
	public void setProductActivityPrice(BigDecimal productActivityPrice) {
		this.productActivityPrice = productActivityPrice;
	}
	public String getProductCreator() {
		return productCreator;
	}
	public void setProductCreator(String productCreator) {
		this.productCreator = productCreator;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Product() {
		super();
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", categoryParentId=" + categoryParentId + ", productType=" + productType
				+ ", productStock=" + productStock + ", productCreateDate=" + productCreateDate + ", productUpdateTime="
				+ productUpdateTime + ", productPrice=" + productPrice + ", productActivityPrice="
				+ productActivityPrice + ", productCreator=" + productCreator + ", productName=" + productName
				+ ", categoryName=" + categoryName + "]";
	}
	public Product(int categoryParentId, int productType, int productStock, Timestamp productCreateDate,
			Timestamp productUpdateTime, BigDecimal productPrice, BigDecimal productActivityPrice,
			String productCreator, String productName, String categoryName) {
		super();
		this.categoryParentId = categoryParentId;
		this.productType = productType;
		this.productStock = productStock;
		this.productCreateDate = productCreateDate;
		this.productUpdateTime = productUpdateTime;
		this.productPrice = productPrice;
		this.productActivityPrice = productActivityPrice;
		this.productCreator = productCreator;
		this.productName = productName;
		this.categoryName = categoryName;
	}	
	
}
