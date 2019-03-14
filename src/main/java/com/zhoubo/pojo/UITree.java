package com.zhoubo.pojo;

import java.util.List;

public class UITree {

	int id;
	String text;
	String state;
	boolean checked;
	List<UITree> children;
	String iconCls = "icon-blank";
	private String pageUrl;
	private Attributes attributes;
	
	public String getPageUrl() {
		return pageUrl;
	}
	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}
	public Attributes getAttributes() {
		return attributes;
	}
	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public List<UITree> getChildren() {
		return children;
	}
	public void setChildren(List<UITree> children) {
		this.children = children;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	
	public UITree(int id, String text, String state, boolean checked,
			List<UITree> children, String iconCls, String pageUrl,
			Attributes attributes) {
		super();
		this.id = id;
		this.text = text;
		this.state = state;
		this.checked = checked;
		this.children = children;
		this.iconCls = iconCls;
		this.pageUrl = pageUrl;
		this.attributes = attributes;
	}
	public UITree() {
		super();
	}
	@Override
	public String toString() {
		return "UITree [id=" + id + ", text=" + text + ", state=" + state
				+ ", checked=" + checked + ", children=" + children
				+ ", iconCls=" + iconCls + ", pageUrl=" + pageUrl
				+ ", attributes=" + attributes + "]";
	}
	
	
}
