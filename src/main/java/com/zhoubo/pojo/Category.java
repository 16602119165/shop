package com.zhoubo.pojo;

import java.sql.Timestamp;

public class Category {

	private int id;
	private int categoryId;
	private int categoryParentId;
	private int categoryType;
	private Timestamp categoryCreateDate;
	private Timestamp categoryUpdateTime;
	private String categoryCreator;
	private String categoryName;
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getCategoryParentId() {
		return categoryParentId;
	}
	public void setCategoryParentId(int categoryParentId) {
		this.categoryParentId = categoryParentId;
	}
	public int getCategoryType() {
		return categoryType;
	}
	public void setCategoryType(int categoryType) {
		this.categoryType = categoryType;
	}
	public Timestamp getCategoryCreateDate() {
		return categoryCreateDate;
	}
	public void setCategoryCreateDate(Timestamp categoryCreateDate) {
		this.categoryCreateDate = categoryCreateDate;
	}
	public Timestamp getCategoryUpdateTime() {
		return categoryUpdateTime;
	}
	public void setCategoryUpdateTime(Timestamp categoryUpdateTime) {
		this.categoryUpdateTime = categoryUpdateTime;
	}
	public String getCategoryCreator() {
		return categoryCreator;
	}
	public void setCategoryCreator(String categoryCreator) {
		this.categoryCreator = categoryCreator;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Category(int categoryId, int categoryParentId, int categoryType, Timestamp categoryCreateDate,
			Timestamp categoryUpdateTime, String categoryCreator, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryParentId = categoryParentId;
		this.categoryType = categoryType;
		this.categoryCreateDate = categoryCreateDate;
		this.categoryUpdateTime = categoryUpdateTime;
		this.categoryCreator = categoryCreator;
		this.categoryName = categoryName;
	}
	public Category() {
		super();
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", categoryId=" + categoryId + ", categoryParentId=" + categoryParentId
				+ ", categoryType=" + categoryType + ", categoryCreateDate=" + categoryCreateDate
				+ ", categoryUpdateTime=" + categoryUpdateTime + ", categoryCreator=" + categoryCreator
				+ ", categoryName=" + categoryName + "]";
	}
	
}
