package com.base;/********************************************************************
 /**
 * @Project: java_practice
 * @Package common.base
 * @author guohongjin
 * @date 2017/9/12 11:24
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import java.util.List;

/**
 * @author guohongjin
 * @ClassName BaseServiceImpl
 * @Description 类描述
 * @date 2017/9/12
 */
public class BaseServiceImpl<T,K,J> implements BaseService<T,K,J> {
    private BaseDao<T,K> baseDao = null;

    public void setBaseDao(BaseDao<T,K> baseDao){
        this.baseDao = baseDao;

    }
    @Override
    public T save(K k) {
        //调用baseDao中的addEntity方法
        return baseDao.addEntity(k);
    }

    @Override
    public T update(K k) {
        return baseDao.updateEntity(k);
    }

    @Override
    public void saveList(List<K> kList) {
        if (kList != null && kList.size() != 0){
            for (int i = 0; i < kList.size() ; i++) {
                baseDao.addEntity(kList.get(i));
            }
        }
    }

    @Override
    public void deleteById(K k) {
        baseDao.deleteEntity(k);
    }

    @Override
    public void deleteByIds(List<K> kList) {
        if (kList != null && kList.size() != 0){
            for (int i = 0; i < kList.size() ; i++) {
                baseDao.deleteEntity(kList.get(i));
            }
        }
    }

    @Override
    public K findById(T t) {
        return null;
    }

    @Override
    public List<K> findByList(List<T> tList) {
        return null;
    }

    @Override
    public J convert(K k) {
        return null;
    }

    @Override
    public List<J> coverts(List<K> kList) {
        return null;
    }
}
