package com.deuvarney.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "profiles")
public class ProfileData {
	
	@Id
	private String id;
	String firstName;
	String lastName;
	String description;
	
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	
}
