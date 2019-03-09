package com.database.core;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public class GDSimpleJdbcCallImpl extends SimpleJdbcCall {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass().getName());

	private String returnResultSet;
	private String[] returnOutputs;

	public String getReturnResultSet() {
		return returnResultSet;
	}

	public void setReturnResultSet(String returnResultSet) {
		this.returnResultSet = returnResultSet;
	}

	public String[] getReturnOutputs() {
		return returnOutputs;
	}

	public void setReturnOutputs(String[] returnOutputs) {
		this.returnOutputs = returnOutputs;
	}

	public GDSimpleJdbcCallImpl(DataSource dataSource, String spName, List<?> paramList, String... returnOutputs) {

		super(dataSource);
		super.setFunction(false);
		super.withProcedureName(spName);
		setReturnOutputs(returnOutputs);
		for (int i = 0; i < paramList.size(); i++) {
			super.addDeclaredParameter((SqlParameter) paramList.get(i));
		}
		super.checkCompiled();
		LOG.info("SP : {} : paramList : {}", spName, super.getInParameterNames());
	}

	public GDSimpleJdbcCallImpl(DataSource dataSource, String spName, List<?> paramList, String returnResultSet,
			RowMapper<?> rowMapper, String... returnOutputs) {

		super(dataSource);
		super.setFunction(false);
		super.withProcedureName(spName);
		super.returningResultSet(returnResultSet, rowMapper);
		setReturnOutputs(returnOutputs);
		setReturnResultSet(returnResultSet);
		for (int i = 0; i < paramList.size(); i++) {
			super.addDeclaredParameter((SqlParameter) paramList.get(i));
		}
		super.checkCompiled();
		LOG.info("SP : {} : paramList : {}", spName, super.getInParameterNames());
	}

	/**
	 * Execute the stored procedure. Subclasses should define a strongly typed
	 * execute method (with a meaningful name) that invokes this method, populating
	 * the input map and extracting typed values from the output map. Subclass
	 * execute methods will often take domain objects as arguments and return
	 * values. Alternatively, they can return void.
	 * 
	 * @param inParams map of input parameters, keyed by name as in parameter
	 *                 declarations. Output parameters need not (but can be)
	 *                 included in this map. It is legal for map entries to be
	 *                 <code>null, and this will produce the correct behavior using
	 *                 a NULL argument to the stored procedure.
	 * @return map of output params, keyed by name as in parameter declarations.
	 *         Output parameters will appear here, with their values after the
	 *         stored procedure has been called.
	 */
	public Map<String, Object> execute(Map<String, ?> inParams) throws DataAccessException {
		return super.execute(inParams);
	}

}
