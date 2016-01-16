package com.deuvarney.model.mysql;

public class AccountPassData implements AccountPassDataBo {
	private int id;
	private int accountId;
	private boolean isCurrentPass;
	private String passHash;
	private AccountData accountData;
	
	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int getAccountId() {
		return accountId;
	}

	@Override
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	@Override
	public boolean getIsCurrentPass() {
		return isCurrentPass;
	}

	@Override
	public void setIsCurrentPass(boolean isCurrentPass) {
		this.isCurrentPass = isCurrentPass;
	}

	@Override
	public String getPassHash() {
		return passHash;
	}

	@Override
	public void setPassHash(String passHash) {
		this.passHash = passHash;
	}

	public AccountData getAccountData() {
		return accountData;
	}

	public void setAccountData(AccountData accountData) {
		this.accountData = accountData;
	}
	
	@Override
	public String toString() {
		return String.format("Id: %s, AccountID: %s, IsCurrentPass: %s, PassHash: %s, AccountData: %s", 
				id, accountId, isCurrentPass, passHash, accountData);
	}


}
