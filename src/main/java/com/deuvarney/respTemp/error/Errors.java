package com.deuvarney.respTemp.error;

public class Errors {
	
	//UserName Errors
	public final static String USERNAME_TOO_SHORT = "Provided username is less than 5 characters";
	public final static String USERNAME_TOO_LONG = "Provided username is more than 50 characters";
	public final static String USERNAME_EXISTS = "Provied username already exists";
	
	//Password Errors
	public final static String PASS_TOO_SHORT = "Provided password is less than 5 characters";
	public final static String PASS_TOO_LONG = "Provided password is more than 50 characters";
	
	//Confirmation Password Errors
	public final static String PASS_MATCH = "Provided passwords do not match";

	
	//Email Errors
	public final static String EMAIL_FORMAT = "Email does not match required format";
	
	//Confirmation Email Errors
	public final static String CONFIRM_EMAIL_NO_MATCH = "Provided passwords do not match";
	
	//

	
}