package com.deuvarney.util;

import com.deuvarney.model.mysql.SignUpRequest;

public class Validation {

	public static void validateSignUpRequest(SignUpRequest signUpRequest){
		String userName = signUpRequest.getUsername();
		if(userName.length() < 5){
			//TODO make error for length being too short
		}
		if(userName.length() > 50){
			// TODO make error for length being too long
		}
		
		String email = signUpRequest.getEmail();
		//TODO make error for email not matching regex/blob expression
		
		String confirmEmail = signUpRequest.getConfirmEmail();
		if(!email.equals(confirmEmail)){
			//TODO make error for email not matching confirm email
		}
		
		String password = signUpRequest.getPassword();
		if(password.length() < 5){
			//TODO make error for length being too short
		}
		if(password.length() > 50){
			// TODO make error for length being too long
		}
		
		String confirmPassword = signUpRequest.getConfirmPassword();
		if(confirmPassword != password){
			// TODO make error for password and confirm password not matching
		}
	}
}
