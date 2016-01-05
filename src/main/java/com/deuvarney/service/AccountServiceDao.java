package com.deuvarney.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deuvarney.config.HibernateConfig;
import com.deuvarney.config.ProfileMongoConfig;
import com.deuvarney.model.mysql.AccountData;


//public class AccountServiceDao  extends HibernateDaoSupport implements AccountService {
//@Service("accountService")
//@Transactional
public class AccountServiceDao extends HibernateDaoSupport implements AccountServiceI {
	private ApplicationContext ctx;
	
	//private HibernateDaoSupport hiberateDaoSupport;
	
	//private SessionFactory sessionFactory;
	{
		//ctx = new AnnotationConfigApplicationContext(HibernateConfig.class);
		//hiberateDaoSupport = (HibernateDaoSupport) ctx.getBean("");
	}
	
//	public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//        System.out.print("SESSION FACTORY IS CREATED");
//    }
	
	public AccountServiceDao(){
		//ctx = new AnnotationConfigApplicationContext(HibernateConfig.class);
		//getSession()
	     //HibernateTemplate s = createHibernateTemplate((SessionFactory) getSession(true));
		//(HibernateDaoSupport) ctx.getBean("transactionManager");
	    // setHibernateTemplate(s);
		//getHibernateTemplate();
	}
	
	public String getAccountData(String lastName){
		//@SuppressWarnings("unchecked")
		//List<AccountData> list = (List<AccountData>) getHibernateTemplate().find("from ACCOUNT where lastName=?", lastName);
		//return null;
		//return list.get(0);
		//String hib = getHibernateTemplate().toString();
		return "hello";
	}
}
