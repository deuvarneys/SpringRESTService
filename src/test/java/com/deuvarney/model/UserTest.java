package com.deuvarney.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {
	
	private User user;
	
	@Before
	public void beforeEach(){
		user = new User();
	}
	
	@Test
	public void testId(){
		String testId = "testId";
		assertEquals("Default Id should be null", null, user.getId());
		user.setId(testId);
		assertEquals("Default Id should be " + testId, testId, user.getId());
	}
	
	@Test
	public void testUserName(){
		String userName = "testUserName";
		assertEquals("Default userName should be null", null, user.getUsername());
		user.setUsername(userName);
		assertEquals("Default userName should be " + userName, userName, user.getUsername());
	}
	
	@Test
	public void testPassword(){
		String testPassword = "testPassword";
		assertEquals("Default password should be null", null, user.getPassword());
		user.setPassword(testPassword);
		assertEquals("Default password should be " + testPassword, testPassword, user.getPassword());
	}
	
	@Test
	public void testUserConstructorSTRINGusernameSTRINGpassword(){
		String userName = "testUserName";
		String testPassword = "testPassword";
		user = new User(userName, testPassword);
		assertEquals("Default userName should be " + userName, userName, user.getUsername());
		assertEquals("Default password should be " + testPassword, testPassword, user.getPassword());
	}
	
	@Test
	public void testToString(){
		String userName = "testUserName";
		String testPassword = "testPassword";
		user = new User(userName, testPassword);
		assertNotNull("ToString() method should not return null", user.toString());
	}
	
}
