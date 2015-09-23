package com.skelton.cc.repositories;


import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by nthar on 9/3/2015.
 */
public class GenericDAO<T, PK> implements Dao<T,PK> {

    @PersistenceContext
    private EntityManager entityManager;

    public GenericDAO() {
    }

    public GenericDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public T getById(PK pk) {
        return (T) entityManager.find(getTypeClass(), pk);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save(T entity) {
        entityManager.persist(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveAll(List<T> entityList) {
        for(T entity : entityList) {
            entityManager.persist(entity);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void update(T entity) {
        entityManager.merge(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void delete(T entity) {
        entityManager.remove(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void deleteAll(T entity) {
        entityManager.remove(entity);
    }


    @Override
    public List<T> findAll() {
        return entityManager.createQuery(("FROM " + getTypeClass().getName()))
                .getResultList();
    }

    private Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
        return clazz;
    }
}
