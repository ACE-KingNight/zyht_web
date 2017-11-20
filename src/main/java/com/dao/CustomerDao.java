package com.dao;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.dao
 * @author wangzhenxin
 * @date 2017-09-15 17:31
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.base.BaseDao;
import com.domain.Customer;

import java.util.List;

/**
 * @author wangzhenxin
 * @InterfaceName CustomerDao
 * @Description 接口描述
 * @date 2017-09-15
 */
public interface CustomerDao extends BaseDao<Long,Customer>{
    /**
     * @Title: saveCustomer
     * @Description: 根据客户对象更新客户对象
     * @author wangzhenxin
     * @date 2017-09-15
     */
    public String saveCustomer(Customer customer);

    public Customer selectCustomer(Customer customer);

    public String updateCustomer(Customer customer);

    public List<Customer> selectAllCustomer();
}
