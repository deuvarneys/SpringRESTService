package com.deuvarney.model;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PositionTest {

	private Position position;
	
	@Before
	public void beforeEach(){
		position = new Position();
	}
	
	@Test
	public void testId(){
		String id = "TestId";
		assertEquals("Default id value should be null",null, position.getId());
		position.setId(id);
		assertEquals("Default id value should be "+ id ,id, position.getId());
	}
	
	@Test
	public void testStartMonth(){
		String startMonth = "January";
		assertEquals("Default start month value should be null",null, position.getStartMonth());
		position.setStartMonth(startMonth);
		assertEquals("Default start month value should be "+ startMonth ,startMonth, position.getStartMonth());
	}
	
	@Test
	public void testStartYear(){
		int startYear = 1970;
		assertEquals("Default start year value should be 0",0, position.getStartYear());
		position.setStartYear(startYear);
		assertEquals("Default start year value should be "+ startYear ,startYear, position.getStartYear());
	}
	
	@Test
	public void testEndMonth(){
		String endMonth = "December";
		assertEquals("Default end month value should be null",null, position.getEndMonth());
		position.setEndMonth(endMonth);
		assertEquals("Default end month value should be "+ endMonth ,endMonth, position.getEndMonth());
	}
	
	@Test
	public void testEndYear(){
		int endYear = 2000;
		assertEquals("Default end year value should be 0",0, position.getEndYear());
		position.setEndYear(endYear);
		assertEquals("Default end year value should be "+ endYear ,endYear, position.getEndYear());
	}
	
	@Test
	public void testTitle(){
		String title = "TestTitle";
		assertEquals("Default title value should be null",null, position.getTitle());
		position.setTitle(title);
		assertEquals("Default title value should be "+ title ,title, position.getTitle());
	}
	
	@Test
	public void testEmployer(){
		String employer = "Test Employer";
		assertEquals("Default employer value should be null",null, position.getEmployer());
		position.setEmployer(employer);
		assertEquals("Default employer value should be "+ employer ,employer, position.getEmployer());
	}
	
	@Test
	public void tesDescription(){
		String description = "Test Description";
		assertEquals("Default Description value should be null",null, position.getDescription());
		position.setDescription(description);
		assertEquals("Default Description value should be "+ description ,description, position.getDescription());
	}
	
	@Test
	public void testLocation(){
		String location = "Test Location";
		assertEquals("Default location value should be null",null, position.getLocation());
		position.setLocation(location);
		assertEquals("Default location value should be "+ location ,location, position.getLocation());
	}
}
