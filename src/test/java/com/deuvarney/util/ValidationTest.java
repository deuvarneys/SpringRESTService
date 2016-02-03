package com.deuvarney.util;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.deuvarney.model.mysql.SignUpRequest;
import com.deuvarney.model.mysql.SignUpRequestBO;
import com.deuvarney.respTemp.ResponseTemplate;
import com.deuvarney.respTemp.error.ErrorResponseTemplate;
import com.deuvarney.respTemp.error.Errors;

//@RunWith(SpringJUnit4ClassRunner.class)
public class ValidationTest {
	
	private ResponseTemplate responseTemplate;
	private SignUpRequest signUpRequest;
	
//	@BeforeClass
//	public static void beforeClass() {
//		System.out.println("-----> SETUP <-----");
//	}
	
	@Before
	public void beforeEach(){
		responseTemplate = new ResponseTemplate();
		signUpRequest = new SignUpRequest();
		signUpRequest.setUsername("TestUserName");
		signUpRequest.setEmail("Test@testemail.com");
		signUpRequest.setConfirmEmail("Test@testemail.com");
		signUpRequest.setPassword("TestPassword");
		signUpRequest.setConfirmPassword("TestPassword");
		signUpRequest.setFirstName("TestFirstName");
		signUpRequest.setLastName("TestLastName");
	}
	
	@Test
	public void testSignUpNoError(){
		Validation.validateSignUpRequest(signUpRequest, responseTemplate);
		assertEquals("There should be no errors returned in the response template", 0, responseTemplate.getErrorCount());
		
	}
	
	@Test
	public void testUsernameShortError(){
		signUpRequest.setUsername("Test");
		Validation.validateSignUpRequest(signUpRequest, responseTemplate);
		List<ErrorResponseTemplate> errors = responseTemplate.getErrors();
		assertTrue("There should be a userName too short error returned", 
				errors.get(0).getError().equals(Errors.USERNAME_TOO_SHORT));
		assertEquals("There should be a userName too short error code returned",
				errors.get(0).getErrorCode(), (Errors.USERNAME_TOO_SHORT_CODE));
	}
	
	@Test
	public void testUsernameLongError(){
		signUpRequest.setUsername("TestUserNameTestUserNameTestUserNameTestUserNameTestUserNameTestUserName");
		Validation.validateSignUpRequest(signUpRequest, responseTemplate);
		List<ErrorResponseTemplate> errors = responseTemplate.getErrors();
		assertTrue("There should be a userName too long error returned", 
				errors.get(0).getError().equals(Errors.USERNAME_TOO_LONG));
		assertEquals("There should be a userName too long error code returned",
				errors.get(0).getErrorCode(), (Errors.USERNAME_TOO_LONG_CODE));
	}
	
	@Test
	public void testEmailAddressError(){
		signUpRequest.setEmail("Test");
		signUpRequest.setConfirmEmail("Test");
		Validation.validateSignUpRequest(signUpRequest, responseTemplate);
		List<ErrorResponseTemplate> errors = responseTemplate.getErrors();
		assertTrue("There should be an email address invalid error returned", 
				errors.get(0).getError().equals(Errors.EMAIL_FORMAT));
		assertEquals("There should be an email address invalid error returned",
				errors.get(0).getErrorCode(), (Errors.EMAIL_FORMAT_CODE));
	}
	
	@Test
	public void testConfirmEmailAddressError(){
		signUpRequest.setConfirmEmail("Test");
		Validation.validateSignUpRequest(signUpRequest, responseTemplate);
		List<ErrorResponseTemplate> errors = responseTemplate.getErrors();
		assertTrue("There should be a confirm email address invalid error returned", 
				errors.get(0).getError().equals(Errors.CONFIRM_EMAIL_NO_MATCH));
		assertEquals("There should be a confirm email address invalid error returned",
				errors.get(0).getErrorCode(), (Errors.CONFIRM_EMAIL_NO_MATCH_CODE));
	}
	
	@Test
	public void testPasswordError(){
		signUpRequest.setPassword("Test");
		signUpRequest.setConfirmPassword("Test");
		Validation.validateSignUpRequest(signUpRequest, responseTemplate);
		List<ErrorResponseTemplate> errors = responseTemplate.getErrors();
		assertTrue("There should be a password too short invalid error returned", 
				errors.get(0).getError().equals(Errors.PASS_TOO_SHORT));
		assertEquals("There should be a password too short invalid error returned",
				errors.get(0).getErrorCode(), (Errors.PASS_TOO_SHORT_CODE));
	}
	
	
	@Test
	public void testConfirmPasswordError(){
		signUpRequest.setConfirmPassword("Test");
		Validation.validateSignUpRequest(signUpRequest, responseTemplate);
		List<ErrorResponseTemplate> errors = responseTemplate.getErrors();
		assertTrue("There should be a confirm password too invalid error returned", 
				errors.get(0).getError().equals(Errors.PASS_MATCH));
		assertEquals("There should be a confirm password invalid error returned",
				errors.get(0).getErrorCode(), (Errors.PASS_MATCH_CODE));
	}
	
	@Test
	public void testFirstNameError(){
		signUpRequest.setFirstName("");
		Validation.validateSignUpRequest(signUpRequest, responseTemplate);
		List<ErrorResponseTemplate> errors = responseTemplate.getErrors();
		assertTrue("There should be a firstName invalid error returned", 
				errors.get(0).getError().equals(Errors.FIRSTNAME_EXISTS));
		assertEquals("There should be a firstName invalid error returned",
				errors.get(0).getErrorCode(), (Errors.FIRSTNAME_EXISTS_CODE));
	}
	
	@Test
	public void testLastNameError(){
		signUpRequest.setLastName("");
		Validation.validateSignUpRequest(signUpRequest, responseTemplate);
		List<ErrorResponseTemplate> errors = responseTemplate.getErrors();
		assertTrue("There should be a lastName invalid error returned", 
				errors.get(0).getError().equals(Errors.LASTNAME_EXISTS));
		assertEquals("There should be a lastName invalid error returned",
				errors.get(0).getErrorCode(), (Errors.LASTNAME_EXISTS_CODE));
	}
//	@AfterClass
//	public static void afterTest() {
//		System.out.println("-----> DESTROY <-----");
//	}
	
	@Test
	public void testNewClassInstance(){
		Validation validation = new Validation();
		assertEquals(validation.getClass().getSimpleName(), "Validation");
	}
	
}
