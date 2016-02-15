package com.deuvarney.application;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.deuvarney.model.mysql.AccountData;
import com.deuvarney.model.mysql.SignUpRequest;
import com.deuvarney.respTemp.ResponseTemplate;
import com.deuvarney.service.AccountServiceI;

import com.deuvarney.service.AccountService;
import com.deuvarney.service.AccountServiceDao;

@RestController
public class AccountController {

	static ApplicationContext context;
	static AccountService accountService;
	
	//static AccountServiceDao accountServiceDao;
	static{
		context = new ClassPathXmlApplicationContext("mysql-config.xml");
		accountService = (AccountService) context.getBean("accountService");
		//accountServiceDao = new AccountServiceDao();
	}
	
	@RequestMapping(value="/account/{userName}", method = RequestMethod.GET)
	public AccountData getAccount(@PathVariable String userName){
		//return accountServiceDao.getAccountData(lastName);
		//return accountService.fetchAllPersons().get(0);
		AccountData accountData = accountService.getUserAccount(userName);
		accountData.setAccountPassData(null);
		return accountData;
		
	}
	@RequestMapping(value="/account/signup", method = RequestMethod.OPTIONS)
	public void signUpOptions(
			HttpServletResponse response,
			@RequestBody(required=true) SignUpRequest signUpRequest
			){
		response.setHeader("Access-Control-Allow-Origin", "*");
	}
	
	@RequestMapping(value="/account/signup", method = RequestMethod.POST)
	public ResponseTemplate signUp(
			HttpServletResponse response,
			@RequestBody(required=true) SignUpRequest signUpRequest
			){
		response.setHeader("Access-Control-Allow-Origin", "*");
		System.out.print(signUpRequest);
		return(accountService.signUp(signUpRequest));
		//return signUpRequest;
		//return null;
	}
	
	@RequestMapping(value="/account/{userName}/exists", method= RequestMethod.GET)
	public String accountExists(HttpServletResponse response,
			@PathVariable String userName){
		response.setHeader("Access-Control-Allow-Origin", "*");
		return String.valueOf(accountService.accountExists(userName));
	}

//	@RequestMapping(value="/account/{userName}/exists", method=RequestMethod.OPTIONS)
//	public void accountExistsOptions(HttpServletResponse response,
//			@PathVariable("userName") String userName
//				//@RequestBody(required=true) Position position						
//			){
//		response.setHeader("Access-Control-Allow-Origin", "*");
//		//res.setHeader("Access-Control-Allow-Headers", "X-Requested-With,content-type");
//		//return profileService.addPosition(userName, position);
//	}
}
