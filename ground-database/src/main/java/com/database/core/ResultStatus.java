package com.database.core;

public enum ResultStatus {

	SUCCESS("SUCCESS"), FAIL("FAIL"), INACTIVE("INACTIVE"), DELETED("DELETED");

	private String statusCode;

	private ResultStatus(String s) {
		statusCode = s;
	}

	public String getStatusCode() {
		return statusCode;
	}
}