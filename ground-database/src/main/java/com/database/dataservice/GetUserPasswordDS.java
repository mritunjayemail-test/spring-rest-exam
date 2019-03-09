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

public class GetUserPasswordDS extends GDJDBCAbstractDataService {

	@Autowired
	private GDTransactionManager gdTxManager;

	public Object execute(GDValueBean inputBean) throws GDException {
		@SuppressWarnings("unused")
		final String METHOD_NAME = "execute";
		@SuppressWarnings("unused")
		ExportsIPBean exportsInputValueBean = null;
		ResultBean result = null;
		// GDTransactionManager bipTransactionManager = (GDTransactionManager)
		// GDApplicationContextManager.getBean("gdTxManager");
		gdTxManager.createTransaction(inputBean.getTxnStatusMap());

		try {
			exportsInputValueBean = (ExportsIPBean) inputBean;
			Map<String, Object> inputMap = new HashMap<String, Object>();
			inputMap.put("userid", "mritunjayemail");
			result = new ResultBean();
			result.setResultMap(bipBatchGenericDAO.execute(inputMap));
			result.setResult(ResultStatus.SUCCESS);
			result.setError(false);
			result.setStatus(1);
			

			gdTxManager.commitTransaction(inputBean.getTxnStatusMap());
		} catch (DataAccessException bipDae) {
			gdTxManager.rollbackTransaction(inputBean.getTxnStatusMap());
			throw new GDException(bipDae);
		} catch (Throwable e) {
			gdTxManager.rollbackTransaction(inputBean.getTxnStatusMap());
			throw new GDException(e);
		}
		return result;
	}
}
