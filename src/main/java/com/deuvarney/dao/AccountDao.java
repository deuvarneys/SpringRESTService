package com.deuvarney.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.deuvarney.model.mysql.AccountData;
import com.deuvarney.model.mysql.AccountPassData;
import com.deuvarney.respTemp.ResponseTemplate;
import com.deuvarney.respTemp.error.ErrorResponseTemplate;

//import scala.annotation.meta.setter;
	 
public class AccountDao extends HibernateDaoSupport{
	 
//	public void insert(Person person){
//	getHibernateTemplate().save(person);
//	}
	
	HibernateTemplate hibernateTemplate;


	public List<AccountData> selectAll(){
		DetachedCriteria criteria = DetachedCriteria.forClass(AccountData.class);
		return  (List<AccountData>) getHibernateTemplate().findByCriteria(criteria);
	}
	
	public List<AccountData> getUserName(String userName){
		DetachedCriteria criteria = DetachedCriteria.forClass(AccountData.class);
		criteria.add(Restrictions.eq("userName", userName));
		return (List<AccountData>) getHibernateTemplate().findByCriteria(criteria);
	}
	
	public List<AccountData> getEmailAddress(String emailAddress){
		DetachedCriteria criteria = DetachedCriteria.forClass(AccountData.class);
		criteria.add(Restrictions.eq("emailAddress", emailAddress));
		return (List<AccountData>) getHibernateTemplate().findByCriteria(criteria);
	}
	
	public void insertUserAccount(AccountData accountData, AccountPassData accountPassData, ResponseTemplate responseTemplate){
		//Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		//session.beginTransaction();
		//session.save(accountData);
		
		try{
		 hibernateTemplate = getHibernateTemplate();
		 hibernateTemplate.save(accountData);
		 System.out.println("AccountData: " + accountData.toString());
		 //accountPassData.setAccountId(accountData.getId());
		 accountPassData.setAccountData(accountData);
		 accountData.getAccountPassData().add(accountPassData);
		 accountPassData.setAccountId(accountData.getId());
		 //accountPassData.setId(accountData.getId());
		 System.out.println("AccountPassData: " + accountPassData.toString());
		 hibernateTemplate.save(accountPassData);
		 
		 
		 accountData.setAccountPassData(null);
		 responseTemplate.setMessage(accountData);
		 //return responseTemplate;
		}catch(Exception e){
			responseTemplate.addError(e.getMessage());
			//return responseTemplate;
		}
		
		//session.getTransaction().commit();
		
		//TODO return error response object
		//return null;
		
	}
	
	public boolean doesEmailAddressExist(String emailAddress){
		//TODO create throw/log error if more than one email is returned
		return getEmailAddress(emailAddress).size() == 1;
	}
	
	public boolean doesUserNameExist(String userName){
		//TODO create throw/log error if more than one account is returned
		return getUserName(userName).size() == 1;
	}
	 
}
