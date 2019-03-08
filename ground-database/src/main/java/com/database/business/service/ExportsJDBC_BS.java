package com.database.business.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.database.ExportsIPBean;
import com.database.ExportsOPBean;
import com.database.core.GDException;
import com.database.core.GDJDBCAbstractBusinessService;

public class ExportsJDBC_BS extends GDJDBCAbstractBusinessService implements ExportService {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass().getName());

	public ExportsOPBean getLoginList(ExportsIPBean exportsInputValueBean) throws GDException {
		@SuppressWarnings("unused")
		final String METHOD_NAME = "getLoginList";
		ExportsOPBean exportOutputValueBean = null;
		try {
			exportsInputValueBean.setUniqueId("1");
			exportOutputValueBean = (ExportsOPBean) getJDBCDataService("loginJDBCListDS", exportsInputValueBean);
			LOG.info(exportOutputValueBean.toString());
			System.out.println(exportOutputValueBean);
			return exportOutputValueBean;
		} catch (Throwable e) {
			throw new GDException();
		}

	}
}