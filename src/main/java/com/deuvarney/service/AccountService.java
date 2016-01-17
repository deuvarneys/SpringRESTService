package com.deuvarney.service;

import com.deuvarney.dao.AccountDao;
import com.deuvarney.model.ProfileData;
import com.deuvarney.model.mysql.AccountData;
import com.deuvarney.model.mysql.AccountPassData;
import com.deuvarney.model.mysql.SignUpRequest;
import com.deuvarney.respTemp.ResponseTemplate;
import com.deuvarney.respTemp.error.Errors;
import com.deuvarney.util.Validation;

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
	
	public AccountData getUserAccount(String userName){
		// TODO make conditional to check length of returned list to see if user is returned
		return getAccountDao().getUserName(userName).get(0);
	}
	
	public ResponseTemplate signUp(SignUpRequest signUpRequest){
		ResponseTemplate responseTemplate = new ResponseTemplate();
		Validation.validateSignUpRequest(signUpRequest, responseTemplate);
		
		if(accountDao.doesUserNameExist(signUpRequest.getUsername())){
			responseTemplate.addError(Errors.USERNAME_EXISTS, Errors.USERNAME_EXISTS_CODE);
		}
		
		if(accountDao.doesEmailAddressExist(signUpRequest.getEmail())){
			responseTemplate.addError(Errors.EMAIL_EXISTS, Errors.EMAIL_EXISTS_CODE);
		}
		
		if(responseTemplate.getErrorCount() > 0){
			return responseTemplate;
		}
		
		AccountData accountData = new AccountData();
		accountData.setFirstName(signUpRequest.getFirstName());
		accountData.setLastName(signUpRequest.getLastName());
		accountData.setUserName(signUpRequest.getUsername());
		accountData.setEmailAddress(signUpRequest.getEmail());
		
		AccountPassData accountPassData = new AccountPassData();
		accountPassData.setPassHash(signUpRequest.getPassword());
		accountPassData.setIsCurrentPass(true);
		
		
		
		getAccountDao().insertUserAccount(accountData, accountPassData, responseTemplate);
		
		if(responseTemplate.getErrorCount() == 0){
			
			new ProfileService().postProfile(new ProfileData(accountData.getId(), accountData.getUserName(), accountData.getFirstName(), accountData.getLastName()));
		}
		
		return responseTemplate;
	}
	
}


