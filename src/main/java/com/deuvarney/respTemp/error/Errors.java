package com.deuvarney.respTemp.error;

public class Errors {
	
	//UserName Errors
	public final static String USERNAME_TOO_SHORT = "Provided username is less than 5 characters";
	public final static String USERNAME_TOO_LONG = "Provided username is more than 50 characters";
	
	
	//Password Errors
	public final static String PASS_TOO_SHORT = "Provided password is less than 5 characters";
	//public final static String PASS_TOO_LONG = "Provided password is more than 50 characters";
	
	//Confirmation Password Errors
	public final static String PASS_MATCH = "Provided passwords do not match";

	
	//Email Errors
	public final static String EMAIL_FORMAT = "Email does not match required format";
	
	//Confirmation Email Errors
	public final static String CONFIRM_EMAIL_NO_MATCH = "Provided passwords do not match";
	
	//Database Errors
	public final static String USERNAME_EXISTS = "Provied username already exists";
	public final static String EMAIL_EXISTS = "Provied email address already exists";
	
	//Name Errors
	public final static String FIRSTNAME_EXISTS = "First Name is required";
	public final static String LASTNAME_EXISTS = "Last Name is required";
	
	
	public final static int USERNAME_TOO_SHORT_CODE = 201;
	public final static int USERNAME_TOO_LONG_CODE = 202;
	
	public final static int USERNAME_EXISTS_CODE = 101;
	public final static int EMAIL_EXISTS_CODE = 102;
	public final static int PASS_TOO_SHORT_CODE = 203;
	//public final static int PASS_TOO_LONG_CODE = 203;
	public final static int PASS_MATCH_CODE = 204;
	public final static int EMAIL_FORMAT_CODE = 205;
	public final static int CONFIRM_EMAIL_NO_MATCH_CODE = 206;
	public final static int FIRSTNAME_EXISTS_CODE = 207;
	public final static int LASTNAME_EXISTS_CODE = 208;
}
