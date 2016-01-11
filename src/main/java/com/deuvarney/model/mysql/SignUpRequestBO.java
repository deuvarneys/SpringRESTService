package com.deuvarney.model.mysql;

public interface SignUpRequestBO {
	
	public String getUsername();
	public void setUsername(String username);
	
	public String getEmail();
	public void setEmail(String email);
	
	public String getConfirmEmail();
	public void setConfirmEmail(String confirmEmail);
	
	public String getPassword();
	public void setPassword(String password);
	
	public String getConfirmPassword();
	public void setConfirmPassword(String confirmPassword);
	
	
}
