package com.ag.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ag.dao.GenericDAO;
import com.ag.dao.UserDAO;
import com.ag.model.OICUserLogin;

@Service
public class UserServiceImpl extends GenericServiceImpl<OICUserLogin, Integer>
        implements UserService {

    private UserDAO userDao;
    public UserServiceImpl(){

    }
    
    @Autowired
    public UserServiceImpl(
            @Qualifier("userDAOImpl") GenericDAO<OICUserLogin, Integer> genericDao) {
        super(genericDao);
        this.userDao = (UserDAO) genericDao;
    }

    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public OICUserLogin doLogin(OICUserLogin user) {
        return userDao.doLogin(user);
    }
	public UserDAO getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
    
 
}
