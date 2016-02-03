package com.deuvarney.respTemp.error;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.deuvarney.util.Validation;

public class ErrorResponseTemplateTest {

	private ErrorResponseTemplate errorResponseTemplate;
	
	@Before
	public void beforeEach(){
		errorResponseTemplate = new ErrorResponseTemplate();
	}
	
	@Test
	public void testError(){
		assertEquals("Default Error value should be null", null, errorResponseTemplate.getError()); 
		errorResponseTemplate.setError(Errors.CONFIRM_EMAIL_NO_MATCH );
		assertEquals("Updated Error Value should be " + Errors.CONFIRM_EMAIL_NO_MATCH , Errors.CONFIRM_EMAIL_NO_MATCH, errorResponseTemplate.getError() );
	}
	
	@Test
	public void testErrorCode(){
		assertEquals("Default Error Code value should be 0", 0, errorResponseTemplate.getErrorCode()); 
		errorResponseTemplate.setErrorCode(Errors.CONFIRM_EMAIL_NO_MATCH_CODE );
		assertEquals("Updated Error Code Value should be " + Errors.CONFIRM_EMAIL_NO_MATCH_CODE , Errors.CONFIRM_EMAIL_NO_MATCH_CODE, errorResponseTemplate.getErrorCode() );
	}
	
	@Test
	public void testErrorConstructor_STRINGerror(){
		errorResponseTemplate = new ErrorResponseTemplate(Errors.CONFIRM_EMAIL_NO_MATCH);
		assertEquals("Updated Error Value should be " + Errors.CONFIRM_EMAIL_NO_MATCH , Errors.CONFIRM_EMAIL_NO_MATCH, errorResponseTemplate.getError() );
		assertEquals("Default Error Code value should be 0", 0, errorResponseTemplate.getErrorCode()); 
		
	}
	
	@Test
	public void testErrorConstructor_STRINGerror_INTerrorCode(){
		errorResponseTemplate = new ErrorResponseTemplate(Errors.CONFIRM_EMAIL_NO_MATCH, Errors.CONFIRM_EMAIL_NO_MATCH_CODE);
		assertEquals(" Error value should be " + Errors.CONFIRM_EMAIL_NO_MATCH, Errors.CONFIRM_EMAIL_NO_MATCH, errorResponseTemplate.getError()); 
		assertEquals(" Error Code Value should be " + Errors.CONFIRM_EMAIL_NO_MATCH_CODE , Errors.CONFIRM_EMAIL_NO_MATCH_CODE, errorResponseTemplate.getErrorCode() );
	}
}
