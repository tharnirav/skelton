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
public class GenericDAO<T, PK> {

    @PersistenceContext
    private EntityManager entityManager;

    public GenericDAO() {
    }

    public GenericDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public T getById(PK pk) {
        return (T) entityManager.find(getTypeClass(), pk);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save(T entity) {
        entityManager.persist(entity);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void update(T entity) {
        entityManager.merge(entity);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void delete(T entity) {
        entityManager.remove(entity);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void deleteAll(T entity) {
        entityManager.remove(entity);
    }


    public List<T> findAll() {
        return entityManager.createQuery(("FROM " + getTypeClass().getName()))
                .getResultList();
    }

    private Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[1];
        return clazz;
    }
}
