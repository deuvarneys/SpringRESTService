package com.deuvarney.dao;


import java.util.List;
 
import org.hibernate.criterion.DetachedCriteria;
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
	 
}
