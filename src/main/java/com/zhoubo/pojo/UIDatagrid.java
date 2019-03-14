package com.zhoubo.pojo;

import java.util.ArrayList;
import java.util.List;

public class UIDatagrid<T> {

	private long total;
	private List<T> rows = new ArrayList<>();
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	public UIDatagrid(long total, List<T> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}
	public UIDatagrid() {
		super();
	}
	
	
}
