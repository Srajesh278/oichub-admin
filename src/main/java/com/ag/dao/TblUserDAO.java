package com.ag.dao;

import com.ag.model.TblUser;

public interface TblUserDAO extends GenericDAO<TblUser, String>{
  
  public TblUser get(String key,String value);

}
