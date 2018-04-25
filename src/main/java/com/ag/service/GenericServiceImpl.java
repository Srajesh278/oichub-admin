package com.ag.service;

/**
 * @author gsspvelu
 */
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ag.dao.GenericDAO;

@Service
public abstract class GenericServiceImpl<E, K> implements GenericService<E, K> {

    private GenericDAO<E, K> genericDao;
    
    public GenericServiceImpl(GenericDAO<E,K> genericDao) {
        this.genericDao=genericDao;
    }

    public GenericServiceImpl() {
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean saveOrUpdate(E entity) {
    	try{
    		genericDao.saveOrUpdate(entity);
    		return true;
    	}
    	catch(Exception e){
    		return false;
    	}
        
    }    

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<E> getAll() {
        return genericDao.getAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public E get(K id) {
        return genericDao.find(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void add(E entity) {
        genericDao.add(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(E entity) {
        genericDao.saveOrUpdate(entity);
    }
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean remove(E entity) {
    	try{
    		genericDao.remove(entity);
    		return true;
    	}
    	catch(Exception e){
    		return false;
    	}
    	
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void removeById(K id) {
        genericDao.removeById(id);
    }
}
