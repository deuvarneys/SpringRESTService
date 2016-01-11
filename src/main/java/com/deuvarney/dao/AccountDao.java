package com.deuvarney.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.deuvarney.model.mysql.AccountData;
	 
public class AccountDao extends HibernateDaoSupport{
	 
//	public void insert(Person person){
//	getHibernateTemplate().save(person);
//	}
	
	HibernateTemplate hibernateTemplate;


	public List<AccountData> selectAll(){
		DetachedCriteria criteria = DetachedCriteria.forClass(AccountData.class);
		return  (List<AccountData>) getHibernateTemplate().findByCriteria(criteria);
	}
	
	public List<AccountData> getUserAccount(String userName){
		DetachedCriteria criteria = DetachedCriteria.forClass(AccountData.class);
		criteria.add(Restrictions.eq("userName", userName));
		return (List<AccountData>) getHibernateTemplate().findByCriteria(criteria);
	}
	
	public AccountData insertUserAccount(AccountData accountData){
		//Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		//session.beginTransaction();
		//session.save(accountData);
		
		if(!doesUserExist(accountData)){
		 getHibernateTemplate().save(accountData);
		 return accountData;
		}
		//session.getTransaction().commit();
		
		//TODO return error response object
		return null;
		
	}
	
	private boolean doesUserExist(AccountData accountData){
		//TODO create throw/log error if more than one account is returned
		return getUserAccount(accountData.getUserName()).size() == 1;
	}
	 
}
