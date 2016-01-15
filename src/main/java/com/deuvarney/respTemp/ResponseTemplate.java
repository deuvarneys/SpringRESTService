package com.deuvarney.respTemp;

import java.util.ArrayList;
import java.util.List;

import com.deuvarney.respTemp.error.ErrorResponseTemplate;

public class ResponseTemplate {
	private int errorCount;
	private List<ErrorResponseTemplate> errors = new ArrayList<>();
	private Object message;
	
	public int getErrorCount() {
		return errorCount;
	}
	public void setErrorCount(int errorCount) {
		this.errorCount = errorCount;
	}
	public List<ErrorResponseTemplate> getErrors() {
		return errors;
	}
	public void setErrors(List<ErrorResponseTemplate> errors) {
		this.errors = errors;
	}
	
	public void addError(ErrorResponseTemplate error){
		errors.add(error);
		this.errorCount++;
	}
	
	public void addError(String error){
		errors.add(new ErrorResponseTemplate(error));
		this.errorCount++;
	}
	
	public void addError(String error, int errorCode){
		errors.add(new ErrorResponseTemplate(error, errorCode));
		this.errorCount++;
	}
	
	public Object getMessage() {
		return message;
	}
	public void setMessage(Object message) {
		this.message = message;
	}
}
