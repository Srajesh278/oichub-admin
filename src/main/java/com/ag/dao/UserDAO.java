package com.ag.dao;

import com.ag.model.OICUserLogin;

/**
 * User Dao interface
 * @author gsspvelu
 */
public interface UserDAO extends GenericDAO<OICUserLogin, Integer>{
   
	OICUserLogin doLogin(OICUserLogin oicuserLogin);
	
}
