package com.ag.dao;

import java.util.List;

/**
 * @author gsspvelu
 */

public interface GenericDAO<E,K> {
    public void add(E entity) ;
    public void saveOrUpdate(E entity) ;
    public void update(E entity) ;
    public void remove(E entity);
    public E find(K key);
    public boolean removeById(K key);
	public E get(String key, String value);
	List<E> getAll();
	List<E> getAll(String key, String value);
	
	
    
	
}