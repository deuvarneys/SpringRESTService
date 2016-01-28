package com.deuvarney.model.mysql;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SignUpRequestTest {

	private SignUpRequest signUpRequest;
	
	@Before
	public void beforeEach(){
		signUpRequest = new SignUpRequest();
	}
	
	@Test
	public void testUserName(){
		String userName = "TestUsername";
		assertEquals("Default username value should be null",null, signUpRequest.getUsername());
		signUpRequest.setUsername(userName);
		assertEquals("Updated userName value should be "+ userName ,userName, signUpRequest.getUsername());
	}
	
	@Test
	public void testEmail(){
		String email = "test@email.com";
		assertEquals("Default email value should be null",null, signUpRequest.getEmail());
		signUpRequest.setEmail(email);
		assertEquals("Updated email value should be "+ email ,email, signUpRequest.getEmail());
	}
	
	@Test
	public void testconfirmEmail(){
		String confirmEmail = "test@email.com";
		assertEquals("Default confirm email value should be null",null, signUpRequest.getConfirmEmail());
		signUpRequest.setConfirmEmail(confirmEmail);
		assertEquals("Updated confirm email value should be "+ confirmEmail ,confirmEmail, signUpRequest.getConfirmEmail());
	}
	
	@Test
	public void testPassword(){
		String password = "password";
		assertEquals("Default password value should be null",null, signUpRequest.getPassword());
		signUpRequest.setPassword(password);
		assertEquals("Updated password value should be "+ password ,password, signUpRequest.getPassword());
	}
	
	@Test
	public void testConfirmPassord(){
		String confirmPassword = "password";
		assertEquals("Default confirm email value should be null",null, signUpRequest.getConfirmEmail());
		signUpRequest.setConfirmPassword(confirmPassword);
		assertEquals("Updated confirm email value should be "+ confirmPassword ,confirmPassword, signUpRequest.getConfirmPassword());
	}
	
	@Test
	public void testFirstName(){
		String firstName = "TestFirstName";
		assertEquals("Default email value should be null", null, signUpRequest.getFirstName());
		signUpRequest.setFirstName(firstName);
		assertEquals("Updated email value should be "+ firstName ,firstName, signUpRequest.getFirstName());
	}
	
	@Test
	public void testLastName(){
		String lastName = "TestLastName";
		assertEquals("Default email value should be null", null, signUpRequest.getLastName());
		signUpRequest.setLastName(lastName);
		assertEquals("Updated email value should be "+ lastName ,lastName, signUpRequest.getLastName());
	}
	
	@Test
	public void testToString(){
		
		String userName = "TestUsername";
		String email = "test@email.com";
		String confirmEmail = "test@email.com";
		String password = "password";
		String confirmPassword = "password";
		String firstName = "TestFirstName";
		String lastName = "TestLastName";
		signUpRequest.setUsername(userName);
		signUpRequest.setEmail(email);
		signUpRequest.setConfirmEmail(confirmEmail);
		signUpRequest.setPassword(password);
		signUpRequest.setConfirmPassword(confirmPassword);
		signUpRequest.setFirstName(firstName);
		signUpRequest.setLastName(lastName);
		assertNotNull(" signUpRequest to string returned value should not be null "+ signUpRequest.toString());
	}
}
