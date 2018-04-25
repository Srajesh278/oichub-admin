package com.ag.service;

import java.util.List;


/**
 * Generic Service
 * @author gsspvelu
 */
public interface GenericService<E, K> {
    public boolean saveOrUpdate(E entity);

    public List<E> getAll();   

    public E get(K id);

    public void add(E entity);

    public void update(E entity);

    public boolean remove(E entity);

	void removeById(K id);

	
}
