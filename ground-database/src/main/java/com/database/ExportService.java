package com.database;

import com.database.core.GDException;

public interface ExportService {
	public ExportsOPBean getLoginList(ExportsIPBean exportsInputValueBean) throws GDException;
}