package com.deuvarney.util;

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
		
		return responseTemplate;
	}
}
