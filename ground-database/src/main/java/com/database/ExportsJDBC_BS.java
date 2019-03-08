package com.database;

import org.springframework.stereotype.Service;

@Service
public class ExportsJDBC_BS extends GDJDBCAbstractBusinessService implements ExportService {

	@SuppressWarnings("unused")
	private final static String CLASS_NAME = "com.ground.dao.jdbc.ExportsJDBC_BS";

	public ExportsOPBean getLoginList(ExportsIPBean exportsInputValueBean) throws GDException {
		@SuppressWarnings("unused")
		final String METHOD_NAME = "getLoginList";
		ExportsOPBean exportOutputValueBean = null;
		try {
			exportsInputValueBean.setUniqueId("1");

			System.out.println("MMMMMMMMMMMMMMMMMMMMMMM");
			System.out.println("MMMMMMMMMMMMMMMMMMMMMMM");
			System.out.println("MMMMMMMMMMMMMMMMMMMMMMM");
			System.out.println("MMMMMMMMMMMMMMMMMMMMMMM");
			System.out.println("MMMMMMMMMMMMMMMMMMMMMMM");
			System.out.println("MMMMMMMMMMMMMMMMMMMMMMM");
			exportOutputValueBean = (ExportsOPBean) getJDBCDataService("loginJDBCListDS", exportsInputValueBean);
			System.out.println(exportOutputValueBean);
			return exportOutputValueBean;
		} catch (Throwable e) {
			throw new GDException();
		}

		// @Autowired
		// @Q//ualifier("personA")

	}
}