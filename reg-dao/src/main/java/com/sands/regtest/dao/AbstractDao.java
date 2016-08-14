package com.sands.regtest.dao;

import com.sands.regtest.idao.IAbstractDao;
import com.sands.regtest.util.RegTestDB;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by mass on 13.08.2016.
 */
public class AbstractDao<T> implements IAbstractDao<T> {
    protected Class<T> type;

    @Inject
    @RegTestDB
    protected EntityManager em;

    public AbstractDao() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            this.type = (Class<T>) ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
        }
    }

    public T merge(T entity) {
        try{
            return (T)  em.merge(entity);
        } catch(NoResultException e) {
            return null;
        }
    }

}
