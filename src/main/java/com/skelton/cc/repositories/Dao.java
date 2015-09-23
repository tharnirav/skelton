package com.skelton.cc.repositories;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by nthar on 9/7/2015.
 */
public interface Dao<T, PK> {
    T getById(PK pk);

    void save(T entity);

    void saveAll(List<T> entityList);

    void update(T entity);

    void delete(T entity);

    void deleteAll(T entity);

    List<T> findAll();
}
