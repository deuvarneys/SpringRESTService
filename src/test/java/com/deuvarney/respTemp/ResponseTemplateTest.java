package com.deuvarney.respTemp;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import com.deuvarney.respTemp.error.ErrorResponseTemplate;
import com.deuvarney.respTemp.error.Errors;

public class ResponseTemplateTest {

	private ResponseTemplate responseTemplate;
	
	@Before
	public void beforeEach(){
		responseTemplate = new ResponseTemplate();
	}
	
	@Test
	public void testErrorCount(){
		assertEquals("Default errorCount value should be 0", 0 , responseTemplate.getErrorCount());
		responseTemplate.setErrorCount(2);
		assertEquals("Default errorCount value should be 2", 2, responseTemplate.getErrorCount());
	}
	
	@Test
	public void testMessage(){
		String testMessage = "This is a test message";
		assertEquals("Default message value should be null", null , responseTemplate.getMessage());
		responseTemplate.setMessage(testMessage);
		assertEquals("Updated message value should be " + testMessage, testMessage, responseTemplate.getMessage());
	}
	
	@Test
	public void testErrors(){
		ErrorResponseTemplate errorResponseTemplate = new ErrorResponseTemplate();
		ArrayList<ErrorResponseTemplate> errorsList = new ArrayList<ErrorResponseTemplate>();
		errorsList.add(errorResponseTemplate);
		assertEquals("Default errors value list size should be 0", 0, responseTemplate.getErrors().size());
		
		responseTemplate.setErrors(errorsList);
		assertEquals("Updated errors list size should be " + errorsList.size(), errorsList.size(), responseTemplate.getErrors().size());	
	}
	
	@Test
	public void testAddError_ERRORRESPONSETEMPLATEerror(){
		ErrorResponseTemplate errorResponseTemplate = new ErrorResponseTemplate();
		assertEquals("Default errors value list size should be 0", 0, responseTemplate.getErrors().size());
		responseTemplate.addError(errorResponseTemplate);
		assertEquals("Updated errors value list size should be 1", 1, responseTemplate.getErrors().size());
		assertEquals("Automatically updated errorCount value should be 1", 1, responseTemplate.getErrorCount());
	}
	
	@Test
	public void testAddError_Stringerror(){
		String errorString = Errors.CONFIRM_EMAIL_NO_MATCH;
		assertEquals("Default errors value list size should be 0", 0, responseTemplate.getErrors().size());
		responseTemplate.addError(errorString);
		assertEquals("Updated errors value list size should be 1", 1, responseTemplate.getErrors().size());
		assertEquals("Automatically updated errorCount value should be 1", 1, responseTemplate.getErrorCount());
	}
}
