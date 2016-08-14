package com.sands.regtest.core.transform;

import java.util.ArrayList;
import java.util.List;

/**
 * Утилита для преобразования сущности и параметров в объект для ответа сервиса
 * Created by mass on 20.01.2016.
 */
public class TransformerUtil {
    /**
     * Преобразование без параметров
     */
    public static <T, K> K parseEntity(T entity, ITransformer<T,K> helper){
        return parseEntity(entity, helper, null);
    }

    /**
     * Преобразование списка без параметров
     */
    public static  <T, K> List<K> parseEntityList (List<? extends T> entityList, ITransformer<T,K> helper){
        return parseEntityList(entityList, helper, null);
    }

    /**
     * Преобразование с параметрами
     * @param entity - исходная сущность
     * @param helper - правила преобразования
     * @param params - дополнительные параметры
     * @param <T> - тип исходной сущности
     * @param <K> - тип объекта ответа
     * @return - объекта ответа
     */
    public static <T, K> K parseEntity(T entity, ITransformer<T,K> helper, Object ... params){
        K transformedEntity = helper.parseToResponseEntity(entity);
        if(params != null) {
            transformedEntity = helper.addToResponseEntity(transformedEntity, entity, params);
        }
        return transformedEntity;
    }

    /**
     * Преобразование списка с параметрами
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
