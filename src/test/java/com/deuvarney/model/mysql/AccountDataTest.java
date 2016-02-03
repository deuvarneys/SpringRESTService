package com.deuvarney.model.mysql;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AccountDataTest {

	private AccountData accountData;
	
	@Before
	public void beforeEach(){
		accountData = new AccountData();
	}
	
	@Test
	public void testId(){
		int id = 1234;
		assertEquals("Default id value should be 0", 0, accountData.getId());
		accountData.setId(id);
		assertEquals("Default id value should be "+ id ,id, accountData.getId());
	}
	
	@Test
	public void testUserName(){
		String testUserName = "TestUserName";
		assertEquals("Default userName value should be null",  null, accountData.getUserName());
		accountData.setUserName(testUserName);
		assertEquals("Updated userName Value should be " + testUserName, testUserName, accountData.getUserName());
	}
	
	@Test
	public void testFirstName(){
		String testFirstName = "TestFirstName";
		assertEquals("Default firstName value should be null",  null, accountData.getFirstName());
		accountData.setFirstName(testFirstName);
		assertEquals("Updated firstName Value should be " + testFirstName, testFirstName, accountData.getFirstName());
	}
	
	@Test
	public void testLastname(){
		String testLastname = "testLastname";
		assertEquals("Default lastName value should be null",  null, accountData.getLastName());
		accountData.setLastName(testLastname);
		assertEquals("Updated lastName Value should be " + testLastname, testLastname, accountData.getLastName());
	}
	
	@Test
	public void testCreatedDate(){
		Timestamp createdDate = new Timestamp(new Date().getTime());
		assertEquals("Default createdDate should be null", null, accountData.getCreatedDate());
		accountData.setCreatedDate(createdDate);
		assertEquals("UPdated createdDate should be " + createdDate, createdDate, accountData.getCreatedDate());
	}
	
	@Test
	public void testModifiedDate(){
		Timestamp modifedDate = new Timestamp(new Date().getTime());
		assertEquals("Default modifedDate should be null", null, accountData.getModifiedDate());
		accountData.setModifiedDate(modifedDate);
		assertEquals("Updated modifedDate should be " + modifedDate, modifedDate, accountData.getModifiedDate());
	}
	
	@Test
	public void testEmail(){
		String email = "test@email.com";
		assertEquals("Default email value should be null",null, accountData.getEmailAddress());
		accountData.setEmailAddress(email);
		assertEquals("Updated email value should be "+ email ,email, accountData.getEmailAddress());
	}
	
	@Test
	public void testAccountPassData(){
		AccountPassData accountPassData = new AccountPassData();
		Set<AccountPassData> arrayAccountPassData = new HashSet<AccountPassData>();
		arrayAccountPassData.add(accountPassData);
		assertNull("Default accountPassData size should be null", accountData.getAccountPassData());
		accountData.setAccountPassData(arrayAccountPassData);
		assertEquals("Default accountPassData size should be 1", 1 , accountData.getAccountPassData().size());
	}
	
}
