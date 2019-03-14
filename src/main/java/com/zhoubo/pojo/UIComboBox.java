package com.zhoubo.pojo;

public class UIComboBox {
	
	private String id;
	private String text;
	private Boolean selected = false;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Boolean getSelected() {
		return selected;
	}
	public void setSelected(Boolean selected) {
		this.selected = selected;
	}
	public UIComboBox(String id, String text, Boolean selected) {
		super();
		this.id = id;
		this.text = text;
		this.selected = selected;
	}
	public UIComboBox() {
		super();
	}
	
	
}
