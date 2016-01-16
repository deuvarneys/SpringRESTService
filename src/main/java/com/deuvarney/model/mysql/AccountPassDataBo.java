package com.deuvarney.model.mysql;

public interface AccountPassDataBo {
	public int getId();
	public void setId(int Id);
	
	public int getAccountId();
	public void setAccountId(int accountId);
	
	public boolean getIsCurrentPass();
	public void setIsCurrentPass(boolean isCurrentPass);
	
	public String getPassHash();
	public void setPassHash(String passHash);
}
