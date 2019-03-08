package com.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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