package com.sands.regtest.idao;

/**
 * Created by mass on 13.08.2016.
 */
public interface IAbstractDao<T> {
    T merge(T entity);
}
