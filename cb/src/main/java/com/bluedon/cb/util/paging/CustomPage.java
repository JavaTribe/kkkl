/*
 * Copyright (c) 2015
 * 蓝盾信息安全技术股份有限公司(Bluedon Information Security Technologies Co.,Ltd) 
 * All rights reserved.
 */
package com.bluedon.cb.util.paging;

/**
 * Description		: 
 * 
 * <br><br>Time		: 2015-11-20  下午11:35:34
 * 
 * @version 1.0
 * 
 * @since 1.0
 * 
 * @author chenchengteng
 */
public class CustomPage {
	
	private Integer lastId;
	
	private int pageSize;
	
	private int totalRow;

	public CustomPage(int totalRow, int pageSize, Integer lastId) {
		this.totalRow = totalRow;
		this.pageSize = pageSize;
		this.lastId = lastId;
	}

	public Integer getLastId() {
		return lastId;
	}

	public void setLastId(Integer lastId) {
		this.lastId = lastId;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRow() {
		return totalRow;
	}

	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}
	
}
