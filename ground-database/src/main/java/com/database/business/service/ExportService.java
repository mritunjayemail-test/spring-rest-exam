package com.database.business.service;

import com.database.ExportsIPBean;
import com.database.ResultBean;
import com.database.core.GDException;

public interface ExportService {
	public ResultBean getLoginList(ExportsIPBean exportsInputValueBean) throws GDException;
	
	public ResultBean getUserPassword(ExportsIPBean exportsInputValueBean) throws GDException;
}