/*
 * ExportOutputValueBean.java
 *
 * Copyright 2008 by American Express, Inc., All rights reserved.
 * This software is the confidential and proprietary information
 * of American Express, Inc. ("Confidential Information").  You
 * shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of  the license agreement
 * you entered into with American Express.
 */
package com.database;

import java.util.List;
import java.util.Map;

import com.database.core.ResultStatus;

public class ResultBean extends GDValueBean {

	private static final long serialVersionUID = 1L;
	private Integer status;
	private boolean error;
	private List<?> resultList;
	private ResultStatus result;
	private Map<String, Object> resultMap;
	
	

	public Map<String, Object> getResultMap() {
		return resultMap;
	}

	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}

	public ResultStatus getResult() {
		return result;
	}

	public void setResult(ResultStatus result) {
		this.result = result;
	}

	/**
	 * @return status
	 */
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @return
	 */
	public boolean getError() {
		return error;
	}

	/**
	 * @param b
	 */
	public void setError(boolean b) {
		error = b;
	}

	public List<?> getResultList() {
		return resultList;
	}

	public void setResultList(List<?> resultList) {
		this.resultList = resultList;
	}
}
