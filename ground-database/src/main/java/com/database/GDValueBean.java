/*
 * Created on Sep 15, 2008
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.database;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.transaction.TransactionStatus;

/**
 * @author mritunjay
 *
 *         To change the template for this generated type comment go to
 *         Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class GDValueBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * This is the transaction status map, which will contain the transaction
	 * status of all the data services participating in the transaction.
	 */
	private Map<String, TransactionStatus> txnStatusMap = new LinkedHashMap<String, TransactionStatus>();

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	/**
	 * @return
	 */
	public Map<String, TransactionStatus> getTxnStatusMap() {
		return txnStatusMap;
	}

	/**
	 * @param map
	 */
	public void setTxnStatusMap(Map<String, TransactionStatus> map) {
		txnStatusMap = map;
	}

	private Map<String, Object> values = new LinkedHashMap<String, Object>();

	public Map<String, Object> getValues() {
		return values;
	}

	public void setValues(Map<String, Object> values) {
		this.values = values;
	}

	public void setValue(String key, Object value) {
		if (values == null) {
			values = new LinkedHashMap<String, Object>();
		}
		values.put(key, value);
	}

	public Object getValue(String key) {
		if (values == null) {
			values = new LinkedHashMap<String, Object>();
		}
		return values.get(key);
	}
	/*
	 * public Map describe() throws GDException { try{ return
	 * BeanUtils.describe(this); }catch(Throwable th) { throw new
	 * GDException(th); } }
	 * 
	 * public void set(Object o) throws GDException { try{
	 * BeanUtils.populate(this, BeanUtils.describe(o)); }catch(Throwable th) {
	 * throw new GDException(th); } }
	 * 
	 * public void populate(Object o) throws GDException { try{
	 * BeanUtils.populate(o, this.describe()); }catch(Throwable th) { throw new
	 * GDException(th); } }
	 */

}
