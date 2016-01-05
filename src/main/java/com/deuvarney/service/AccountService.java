package com.deuvarney.service;

import com.deuvarney.dao.AccountDao;
import com.deuvarney.model.mysql.AccountData;

import java.util.List;

public class AccountService {
	
	private AccountDao accountDao;
	 
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	
	public AccountDao getAccountDao() {
		return accountDao;
	}
	 
	
	 
//	public void addPerson(AccountData accountData) {
//		getAccountDao().insert(accountData);
//	}
	 
	public List<AccountData> fetchAllPersons() {
		return getAccountDao().selectAll();
	}
}


