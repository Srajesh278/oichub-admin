package com.ag.dao;
/**
 * @author gsspvelu
 */

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ag.model.OICUserLogin;

@Repository
public class UserDAOImpl extends GenericDAOImpl<OICUserLogin, Integer> implements UserDAO {
   
    
    @Override
    @SuppressWarnings("unchecked")
	public OICUserLogin doLogin(OICUserLogin oicuserLogin) {
    	oicuserLogin.setUserId(oicuserLogin.getUserId().toLowerCase());
       	List<OICUserLogin> oicUserList = null;
       	if(oicuserLogin.getAuthCode()!=null)
       	{
       		oicUserList = currentSession().createCriteria(OICUserLogin.class)
    		.add(Restrictions.eq("userId", oicuserLogin.getUserId().trim()))
    		.add(Restrictions.eq("authCode", oicuserLogin.getAuthCode().trim())).list();
    	 
    	 if(oicUserList.size() > 0)
     	{  
     		return oicUserList.get(0);    		
     	}
    	 
    	}          	
       
       	return null;
	}  
	
}