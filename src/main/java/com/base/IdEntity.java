package com.base;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.base
 * @author wangzhenxin
 * @date 2017-09-15 17:26
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

/**
 * @author wangzhenxin
 * @ClassName IdEntity
 * @Description ID公共类
 * @date 2017-09-15
 */
public class IdEntity<T> {
    protected static final long serialVersionUID = -7523987970034925805L;
    /**
     * ID 套餐购买编号
     */
    protected T id;//ID

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}
