package com.deuvarney.respTemp.error;

public class ErrorResponseTemplate {
	private String error;
	private int errorCode = 0;

	public ErrorResponseTemplate(String error){
		this.error = error;
	}
	
	public ErrorResponseTemplate(String error, int errorCode){
		this(error);
		this.setErrorCode(errorCode);
	}
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
	
}
