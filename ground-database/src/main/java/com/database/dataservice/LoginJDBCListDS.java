/*
 * ExportsListDS.java
 *
 * Copyright 2018 by Ground, Inc., All rights reserved.
 * This software is the confidential and proprietary information
 * of Ground, Inc. ("Confidential Information").  You
 * shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of  the license agreement
 * you entered into with American Express.
 */
package com.database.dataservice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.database.ExportsIPBean;
import com.database.ResultBean;
import com.database.GDValueBean;
import com.database.core.GDException;
import com.database.core.GDJDBCAbstractDataService;
import com.database.core.GDTransactionManager;
import com.database.core.ResultStatus;

public class LoginJDBCListDS extends GDJDBCAbstractDataService {

	@Autowired
	private GDTransactionManager gdTxManager;

	public Object execute(GDValueBean inputBean) throws GDException {
		@SuppressWarnings("unused")
		final String METHOD_NAME = "execute";
		@SuppressWarnings("unused")
		ExportsIPBean exportsInputValueBean = null;
		ResultBean exportsOutputValueBean = null;
		// GDTransactionManager bipTransactionManager = (GDTransactionManager)
		// GDApplicationContextManager.getBean("gdTxManager");
		gdTxManager.createTransaction(inputBean.getTxnStatusMap());

		try {
			exportsInputValueBean = (ExportsIPBean) inputBean;
			Map<String, ?> inputMap = new HashMap<String, Object>(0);
			Map<String, Object> outputMap = bipBatchGenericDAO.execute(inputMap);
			exportsOutputValueBean = new ResultBean();
			//exportsOutputValueBean.setResultMap(outputMap);
			exportsOutputValueBean.setResultList((List<?>) outputMap.get(bipBatchGenericDAO.getReturnResultSet()));
			exportsOutputValueBean.setResult(ResultStatus.SUCCESS);
			exportsOutputValueBean.setError(false);
			exportsOutputValueBean.setStatus(1);
			
			gdTxManager.commitTransaction(inputBean.getTxnStatusMap());
		} catch (DataAccessException bipDae) {
			gdTxManager.rollbackTransaction(inputBean.getTxnStatusMap());
			throw new GDException(bipDae);
		} catch (Throwable e) {
			gdTxManager.rollbackTransaction(inputBean.getTxnStatusMap());
			throw new GDException(e);
		}
		return exportsOutputValueBean;
	}
}
