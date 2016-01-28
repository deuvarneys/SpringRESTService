package com.deuvarney.model.mysql;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.deuvarney.model.Position;

public class AccountPassDataTest {
	
	AccountPassData accountPassData;
	
	@Before
	public void beforeEach(){
		accountPassData = new AccountPassData();
	}
	
	
	@Test
	public void testId(){
		int id = 1234;
		assertEquals("Default id value should be 0",0, accountPassData.getId());
		accountPassData.setId(id);
		assertEquals("Updated id value should be "+ id ,id, accountPassData.getId());
	}
	
	@Test
	public void testAccountId(){
		int accountId = 1234;
		assertEquals("Default accountId value should be 0",0, accountPassData.getAccountId());
		accountPassData.setAccountId(accountId);
		assertEquals("Updated accountId value should be "+ accountId ,accountId, accountPassData.getAccountId());
	}
	
	@Test
	public void testIsCurrentPass(){
		boolean isCurrentPass = true;
		assertEquals("Default isCurrentPass value should be false",false, accountPassData.getIsCurrentPass());
		accountPassData.setIsCurrentPass(isCurrentPass);
		assertEquals("Updated isCurrentPass value should be "+ isCurrentPass ,isCurrentPass, accountPassData.getIsCurrentPass());
	}
	
	@Test
	public void testPassHash(){
		String passHash = "TestPassHash";
		assertEquals("Default isCurrentPass value should be null",null, accountPassData.getPassHash());
		accountPassData.setPassHash(passHash);
		assertEquals("Updated isCurrentPass value should be "+ passHash ,passHash, accountPassData.getPassHash());
	}
	
	@Test
	public void testAccountData(){
		AccountData accountData = new AccountData();
		assertEquals("Default accountData value should be null",null, accountPassData.getAccountData());
		accountPassData.setAccountData(accountData);
		assertEquals("Updated accountData value should be "+ accountData ,accountData, accountPassData.getAccountData());
	}
	
	@Test
	public void testToString(){
		
		int id = 1234;
		int accountId = 1234;
		boolean isCurrentPass = true;
		String passHash = "TestPassHash";
		accountPassData.setId(id);
		accountPassData.setAccountId(accountId);
		accountPassData.setIsCurrentPass(isCurrentPass);
		accountPassData.setPassHash(passHash);
		AccountData accountData = new AccountData();
		accountPassData.setAccountData(accountData);
		assertNotNull(" accountData to string returned value should not be null "+ accountPassData.toString());
	}
	
}
