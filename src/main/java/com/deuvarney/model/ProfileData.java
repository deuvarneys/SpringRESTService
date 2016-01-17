package com.deuvarney.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "profiles")
public class ProfileData {
	
	@Id
	private String id;
	private int accountId;
	private String userName;
	private String firstName;
	private String lastName;
	private String description;
	
	List<Positions> positions;
	
	/*public ProfileData(ProfileData profileData) {
		// TODO Auto-generated constructor stub
	}
	/*
	public ProfileData(String firstName, String lastName, String description){
		this.firstName = firstName;
		this.lastName = lastName;
		this.description = description;
	}
	*/
	public ProfileData(int accountId, String userName, String firstName, String lastName){
		this.accountId = accountId;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Positions> getPositions() {
		return positions;
	}
	public void setPositions(List<Positions> positions) {
		this.positions = positions;
	}
	
	@Override
	public String toString() {
		return String.format("Id: %s, FirstName: %s, LastName: %s, Description: %s, Positions: %s",
				id, firstName, lastName, description, positions.toString());
	}
	
}
