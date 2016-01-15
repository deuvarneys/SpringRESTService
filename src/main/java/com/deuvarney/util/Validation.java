package com.deuvarney.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.deuvarney.model.mysql.SignUpRequest;
import com.deuvarney.respTemp.ResponseTemplate;
import com.deuvarney.respTemp.error.ErrorResponseTemplate;
import com.deuvarney.respTemp.error.Errors;

public class Validation {

	public static ResponseTemplate validateSignUpRequest(SignUpRequest signUpRequest, ResponseTemplate responseTemplate){
		String userName = signUpRequest.getUsername();
		if(userName.length() < 5){
			responseTemplate.addError(Errors.USERNAME_TOO_SHORT, Errors.USERNAME_TOO_LONG_CODE);
		}
		if(userName.length() > 50){
			responseTemplate.addError(Errors.USERNAME_TOO_LONG, Errors.USERNAME_TOO_LONG_CODE);
		}
		
		String email = signUpRequest.getEmail();
		//TODO Move pattern to class scope to only initialize pattern once
		Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(email);
		if(!matcher.find()){
			responseTemplate.addError(Errors.EMAIL_FORMAT, Errors.EMAIL_FORMAT_CODE);
		}
		//String pattern = "/^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/";
		//TODO make error for email not matching regex/blob expression
		
		String confirmEmail = signUpRequest.getConfirmEmail();
		if(!email.equals(confirmEmail)){
			responseTemplate.addError(Errors.CONFIRM_EMAIL_NO_MATCH, Errors.CONFIRM_EMAIL_NO_MATCH_CODE);
		}
		
		String password = signUpRequest.getPassword();
		if(password.length() < 5){
			responseTemplate.addError(Errors.PASS_TOO_SHORT, Errors.PASS_TOO_SHORT_CODE);
		}
//		if(password.length() > 50){
//			// TODO make error for length being too long
//		}
		
		String confirmPassword = signUpRequest.getConfirmPassword();
		if(!confirmPassword.equals(password)){
			responseTemplate.addError(Errors.PASS_MATCH, Errors.PASS_MATCH_CODE);
		}
		
		String firstName = signUpRequest.getFirstName();
		if(firstName.length() < 1){
			responseTemplate.addError(Errors.FIRSTNAME_EXISTS, Errors.FIRSTNAME_EXISTS_CODE);
		}
		
		String lastName = signUpRequest.getLastName();
		if(lastName.length() < 1){
			responseTemplate.addError(Errors.LASTNAME_EXISTS, Errors.LASTNAME_EXISTS_CODE);
		}
		
		return responseTemplate;
	}
}
