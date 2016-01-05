package com.deuvarney.model.mysql;

import java.math.BigDecimal;

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
	private long regDate;

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
	
	public long getRegDate() {
		return regDate;
	}

	public void setRegDate(long regDate) {
		this.regDate = regDate;
	}

}
