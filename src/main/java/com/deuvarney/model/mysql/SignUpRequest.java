package com.deuvarney.model.mysql;

public class SignUpRequest implements SignUpRequestBO{
	private String username;
	private String email;
	private String confirmEmail;
	private String password;
	private String confirmPassword;
	private String firstName;
	private String lastName;
	
	@Override
	public String getUsername() {
		return this.username;
	}
	@Override
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public String getPassword() {
		return this.password;
	}
	@Override
	public void setPassword(String password) {
		this.password = password;
		
	}
	@Override
	public String getConfirmPassword() {
		return this.confirmPassword;
	}
	@Override
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
		
	}
	@Override
	public String getEmail() {
		return this.email;
	}
	@Override
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String getConfirmEmail() {
		return this.confirmEmail;
	}
	@Override
	public void setConfirmEmail(String confirmEmail) {
		this.confirmEmail = confirmEmail;
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
	@Override
	public String toString(){
		return String.format("Username: %s, Email: %s, ConfirmEmail: %s, Password: %s, ConfirmPassword: %s, FirstName: %s, LastName: %s", 
				username, email, confirmEmail, password, confirmPassword, firstName, lastName);
	}
	

}
