package com.sands.regtest.core.transform;

/**
 * Created by mass on 20.01.2016.
 */
public interface ITransformer<T, K> {
    /** ������������� � �������� ��� ����������� �������� */
    K parseToResponseEntity(T entity);

    default K addToResponseEntity(K obj, T entity, Object... params){
        return obj;
    }
}
