package com.ag.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.ag.model.TblUser;

public class TblUserDAOImpl extends GenericDAOImpl<TblUser, String> implements TblUserDAO {
	 @SuppressWarnings("unchecked")
	@Override
	    public List<TblUser> getAll() {
		 Criteria criteria =  currentSession().createCriteria(TblUser.class);
		 criteria.createAlias("tblUserType", "tblUserTypeId");
	    	return criteria
	    			.add(Restrictions.eq("tblUserTypeId.id", 2))
	    			.addOrder(Order.asc("username")).list();
	    	
	    	//
	    } 
	
	@Override
	   	@SuppressWarnings("unchecked")
	   	public TblUser get(String key,String value) { 
	   		Session session = currentSession();            
	           
	           Query hqlQuery = session.createQuery("from TblUser y where y.username= ?");
	           TblUser user = (TblUser) hqlQuery.setString(0,value).uniqueResult();
	       
	   		return user != null ? user : null ;    
	           
	           
	   }
}
