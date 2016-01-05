package com.deuvarney.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.deuvarney.model.mysql.AccountData;
import com.deuvarney.service.AccountServiceI;
import com.deuvarney.service.AccountService;
import com.deuvarney.service.AccountServiceDao;

@RestController
public class AccountController {

	static ApplicationContext context;
	static AccountService accountService;
	
	//static AccountServiceDao accountServiceDao;
	{
		context = new ClassPathXmlApplicationContext("mysql-config.xml");
		accountService = (AccountService) context.getBean("accountService");
		//accountServiceDao = new AccountServiceDao();
	}
	
	@RequestMapping(value="/account/{lastName}", method = RequestMethod.GET)
	public AccountData getAccount(@PathVariable String lastName){
		//return accountServiceDao.getAccountData(lastName);
		return accountService.fetchAllPersons().get(0);
		
	}
}
