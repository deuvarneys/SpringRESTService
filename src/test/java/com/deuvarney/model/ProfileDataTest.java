package com.deuvarney.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import antlr.collections.List;

public class ProfileDataTest {
	
	private ProfileData profileData;
	
	@Before
	public void beforeEach(){
		profileData = new ProfileData(); 
	}
	
	@Test
	public void testId(){
		String testId = "TestId";
		assertEquals("Default Id value should be null",  null, profileData.getId());
		profileData.setId(testId);
		assertEquals("Updated Id Value should be " + testId, testId, profileData.getId());
	}
	
	@Test
	public void testAccountId(){
		int testAccountId = 1234;
		assertEquals("Default Account Id value should be 0",  0, profileData.getAccountId());
		profileData.setAccountId(testAccountId);
		assertEquals("Updated Account Id Value should be " + testAccountId, testAccountId, profileData.getAccountId());
	}
	
	@Test
	public void testUserName(){
		String testUserName = "TestUserName";
		assertEquals("Default userName value should be null",  null, profileData.getUserName());
		profileData.setUserName(testUserName);
		assertEquals("Updated userName Value should be " + testUserName, testUserName, profileData.getUserName());
	}
	
	@Test
	public void testFirstName(){
		String testFirstName = "TestFirstName";
		assertEquals("Default firstName value should be null",  null, profileData.getFirstName());
		profileData.setFirstName(testFirstName);
		assertEquals("Updated firstName Value should be " + testFirstName, testFirstName, profileData.getFirstName());
	}
	
	@Test
	public void testLastname(){
		String testLastname = "testLastname";
		assertEquals("Default lastName value should be null",  null, profileData.getLastName());
		profileData.setLastName(testLastname);
		assertEquals("Updated lastName Value should be " + testLastname, testLastname, profileData.getLastName());
	}
	
	@Test
	public void testDescription(){
		String testDescription = "Test Description";
		assertEquals("Default Description value should be null",  null, profileData.getDescription());
		profileData.setDescription(testDescription);
		assertEquals("Updated Description Value should be " + testDescription, testDescription, profileData.getDescription());
	}
	
	@Test
	public void testPositionIds(){
		ArrayList<String> testPositionIds =  new ArrayList<String>();
		testPositionIds.add("1234");
		testPositionIds.add("5678");
		assertEquals("Default position Ids length value should be 0",  0, profileData.getPositionsIds().size());
		profileData.setPositionsIds(testPositionIds);
		assertEquals("Updated position Ids length Value should be " + testPositionIds, testPositionIds, profileData.getPositionsIds());
	}
	
	@Test
	public void testPositions(){
		Position position = new Position();
		position.setId("1234");
		ArrayList<Position> positions = new ArrayList<Position>();
		positions.add(position);
		assertEquals("Default positions value should be null",  null, profileData.getPositions());
		profileData.setPositions(positions);
		assertEquals("Updated positions Value should be " + positions, positions, profileData.getPositions());
	}
	
	@Test
	public void testAddPositions(){
		assertEquals("Default add positions length value should be 0",  0, profileData.getPositionsIds().size());
		profileData.addPositionId("1234");
		assertEquals("Default add positions length value is 1",  1, profileData.getPositionsIds().size());
		profileData.addPositionId("5678");
		assertEquals("Default add positions length value is 2",  2, profileData.getPositionsIds().size());
	}
	
//	@Test
//	public void testToString(){
//		profileData.setId("1234");
//		profileData.setAccountId(1234);
//		assertNotNull("Returned string from toString() method isn't null", profileData.toString());
//	}
	
	@Test
	public void testProfileDataConstructor(){
		int accountId = 1234;
		String userName = "testUserName";
		String firstName = "testFirstName";
		String lastName = "testLastName";
		ProfileData profileData = new ProfileData(accountId, userName, firstName, lastName);
		assertEquals("Constructed accountId should be " + accountId,accountId, profileData.getAccountId());
		assertEquals("Constructed username should be " + userName,userName, profileData.getUserName());
		assertEquals("Constructed firstName should be " + firstName,firstName, profileData.getFirstName());
		assertEquals("Constructed lastName should be " + lastName,lastName, profileData.getLastName());
	}
	
}
