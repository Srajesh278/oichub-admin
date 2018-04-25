package com.ag.service;

import com.ag.model.OICUserLogin;
/**
 * AdminService
 */
public interface UserService extends GenericService<OICUserLogin,Integer>{
   
	public OICUserLogin doLogin(OICUserLogin oicuserLogin);
	
}
