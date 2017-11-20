package com.service;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.service
 * @author wangzhenxin
 * @date 2017-09-15 17:31
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.base.BaseService;
import com.domain.Customer;

import java.util.List;

/**
 * @author wangzhenxin
 * @InterfaceName CustomerService
 * @Description 客户信息服务
 * @date 2017-09-15
 */
public interface CustomerService extends BaseService<Long,Customer,Customer>{
    /**
     * @Title: saveCustomer
     * @Description: 根据客户对象更新客户对象
     * @author wangzhenxin
     * @date 2017-09-15
     */
    public String saveCustomer(Customer customer);

    /**
     * @Title: selectCustomer
     * @Description: 查询对象信息
     * @author wangzhenxin
     * @date 2017-09-18
     */

    public Customer selectCustomer(Customer customer);
    /**
     * @Title:updateCustomer
     * @Description: 更新
     * @author wangzhenxin
     * @date 2017-09-18
     */
    public String updateCustomer(Customer customer);
    /**
     * @Title: deleteCustomer
     * @Description: 删除客户对象
     * @author wangzhenxin
     * @date 2017-09-18
     */
    public String deleteCustomer(Customer customer);

    /**
     * @Title: selectAllCustomer
     * @Description: 查询所有客户
     * @author wangzhenxin
     * @date 2017-09-26
     */
    public List<Customer> selectAllCustomer();

}
