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
 * @InterfaceName BaseService
 * @Description 接口描述
 * @date 2017/9/12
 */
public interface BaseService<T,K,J> {

    /**
     * @Title: save
     * @Description: 根据对象保持数据返回主键id
     * @author guohongjin
     * @date 2017-09-12
     * @param k 实体对象
     * @return T
     */
    public T save(K k);

    /**
     * Title: update
     * @Description: 修改
     * @author wangzhenxin
     * @date 2017-09-18
     * @param k 实体
     * @return T
     */

    public T update(K k);

    /**
     * @Title: saveList
     * @Description: 批量保存数据
     * @author guohongjin
     * @date 2017-09-12
     * @param kList 对象集合
     */
    public void saveList(List<K> kList);
    
    /** 
     * @Title: deleteById
     * @Description: 根据id删除指定数据对象
     * @author guohongjin
     * @date 2017-09-12
     * @param k 对象
     */
    public void deleteById(K k);

    /**
     * @Title: deleteByIds
     * @Description: 根据对象集合批量删除数据
     * @author guohongjin
     * @date 2017-09-12
     * @param kList 对象集合
     */
    public void deleteByIds(List<K> kList);

    /**
     * @Title: findById
     * @Description: 根据id单个查询数据对象
     * @author guohongjin
     * @date 2017-09-12
     */
    public K findById(T t);

    /**
     * @Title: findByList
     * @Description: 根据id集合批量查询数据对象
     * @author guohongjin
     * @date 2017-09-12
     * @param tList id集合
     */
    public List<K> findByList(List<T> tList);

    /**
     * @Title: convert
     * @Description: 实体对象转化vo
     * @author guohongjin
     * @date 2017-09-12
     * @param k 实体对象
     * @return  J
     */
    public J convert(K k);

    /**
     * @Title:coverts
     * @Description: 实体集合批量转化为vo
     * @author guohongjin
     * @date 2017-09-12
     * @param kList 实体对象集合
     * @return List<J>
     */
    public List<J> coverts(List<K> kList);
}
