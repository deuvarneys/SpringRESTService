package com.deuvarney.model.mysql;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

//@Entity
//@Table(name="ACCOUNT")
public class AccountData implements AccountDataBO {
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

//	@Size(min=3, max=50)
//	@Column(name = "firstName", nullable = false)
	private String firstName;

//	@Size(min=3, max=50)
//	@Column(name = "lastName", nullable = false)
	private String lastName;
	
//	@Column(name= "regDate", nullable = false)
	private Timestamp createdDate;
	
	private Timestamp modifiedDate;
	
	private  String userName;
	
	private String emailAddress;
	
	private Set<AccountPassData> accountPassData = new HashSet<AccountPassData>(0);

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
	
	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
//	public List<AccountPassData> getAccountPassData() {
//		return accountPassData;
//	}
//
//	public void setAccountPassData(List<AccountPassData> accountPassData) {
//		this.accountPassData = accountPassData;
//	}

	public Set<AccountPassData> getAccountPassData() {
		return accountPassData;
	}

	public void setAccountPassData(Set<AccountPassData> accountPassData) {
		this.accountPassData = accountPassData;
	}

	@Override
	public String toString() {
		return String.format("Id: %s, FirstName: %s, LastName: %s, CreatedDate: %s, ModifiedDate: %s, UserName: %s, EmailAddress: %s",
				this.id, this.firstName, this.lastName, this.createdDate, this.modifiedDate, this.userName, this.emailAddress);
	}

}
