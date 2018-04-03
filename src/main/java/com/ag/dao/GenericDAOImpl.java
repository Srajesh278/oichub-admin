package com.ag.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Basic DAO operations dependent with Hibernate's specific classes
 * @see SessionFactory
 */
@SuppressWarnings("unchecked")
@Repository
public abstract class GenericDAOImpl<E, K extends Serializable> implements GenericDAO<E, K> {
    
	@Autowired
    private SessionFactory sessionFactory;

    protected Class<? extends E> daoType;

    /**
     * By defining this class as abstract, we prevent Spring from creating instance of this class
     * If not defined abstract getClass().getGenericSuperClass() would return Object.
     * There would be exception because Object class does not hava constructor with parameters.
     */
    public GenericDAOImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        daoType = (Class) pt.getActualTypeArguments()[0];
    }

    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void add(E entity) {
        currentSession().save(entity);
    }

    @Override
    public void saveOrUpdate(E entity) {
        currentSession().saveOrUpdate(entity);
    }

    @Override
    public void update(E entity) {
        currentSession().save(entity);
    }

    @Override
    public void remove(E entity) {
        currentSession().delete(entity);
    }

    @Override
    public E find(K key) {
        return (E) currentSession().get(daoType, key);
    }

    @Override
    public List<E> getAll() {
    	return currentSession().createCriteria(daoType).list();
    }   
    @Override
    public boolean removeById(K key) {
    	Object persistentInstance = currentSession().load(daoType, key);
        if (persistentInstance != null) {
        	currentSession().delete(persistentInstance);
            return true;
        }
        return false;
    }    
   
    
    @Override
	@SuppressWarnings("unchecked")
	public E get(String key,String value) { 
		Session session = currentSession();
        List<E> flexSiteList = session.createCriteria(daoType)
				.add(Restrictions.ilike(key , value , MatchMode.START)).list();  
        if(flexSiteList.size()>0)
        {
        return flexSiteList.get(0);
        }
        return null;
	}
    
    @Override
	@SuppressWarnings("unchecked")
	public List<E> getAll(String key,String value) { 
		Session session = currentSession();
        List<E> list = session.createCriteria(daoType)
				.add(Restrictions.ilike(key , value , MatchMode.START)).list();  
       
        return list;
       
	}
    
    
}