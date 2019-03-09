package com.database.business.service;

import com.database.ExportsIPBean;
import com.database.ExportsOPBean;
import com.database.core.GDException;

public interface ExportService {
	public ExportsOPBean getLoginList(ExportsIPBean exportsInputValueBean) throws GDException;
	
	public String getUserPassword(ExportsIPBean exportsInputValueBean) throws GDException;
}