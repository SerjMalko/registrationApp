package com.sands.regtest.core.transform;

import java.util.ArrayList;
import java.util.List;

/**
 * ������� ��� �������������� �������� � ���������� � ������ ��� ������ �������
 * Created by mass on 20.01.2016.
 */
public class TransformerUtil {
    /**
     * �������������� ��� ����������
     */
    public static <T, K> K parseEntity(T entity, ITransformer<T,K> helper){
        return parseEntity(entity, helper, null);
    }

    /**
     * �������������� ������ ��� ����������
     */
    public static  <T, K> List<K> parseEntityList (List<? extends T> entityList, ITransformer<T,K> helper){
        return parseEntityList(entityList, helper, null);
    }

    /**
     * �������������� � �����������
     * @param entity - �������� ��������
     * @param helper - ������� ��������������
     * @param params - �������������� ���������
     * @param <T> - ��� �������� ��������
     * @param <K> - ��� ������� ������
     * @return - ������� ������
     */
    public static <T, K> K parseEntity(T entity, ITransformer<T,K> helper, Object ... params){
        K transformedEntity = helper.parseToResponseEntity(entity);
        if(params != null) {
            transformedEntity = helper.addToResponseEntity(transformedEntity, entity, params);
        }
        return transformedEntity;
    }

    /**
     * �������������� ������ � �����������
     */
    public static <T, K> List<K> parseEntityList (List<? extends T> entityList, ITransformer<T,K> helper, Object ... params){
        List<K> transedList = new ArrayList<>();
        if (entityList != null && !entityList.isEmpty()) {
            for (T item : entityList) {
                K transedObj = TransformerUtil.parseEntity(item, helper, params);
                if(transedObj != null){
                    transedList.add(transedObj);
                }
            }
        }
        return transedList;
    }
}
