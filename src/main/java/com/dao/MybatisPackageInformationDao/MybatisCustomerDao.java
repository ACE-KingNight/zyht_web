package com.dao.MybatisPackageInformationDao;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.dao.MybatisPackageInformationDao
 * @author wangzhenxin
 * @date 2017-10-24 16:16
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.domain.Customer;

import java.util.List;

/**
 * @author wangzhenxin
 * @InterfaceName MybatisCustomerDao
 * @Description 接口描述
 * @date 2017-10-24
 */
public interface MybatisCustomerDao {
    /**
     * @Title: getAllCustomer
     * @Description: 查询所有客户信息
     * @author wangzhenxin
     * @date 2017-10-24
     */

    public List<Customer> getAllCustomer();

    /**
     * @Title: getCustomer
     * @Description: 查询单个客户信息
     * @author wangzhenxin
     * @date 2017-10-24
     * @param customer 客户信息对象
     */

    public Customer getCustomer(Customer customer);

    /**
     * @Title: insertCustomer
     * @Description: 插入客户信息
     * @author wangzhenxin
     * @date 2017-10-24
     * @param customer 客户信息对象
     */
    public void insertCustomer(Customer customer);

    /**
     * @Title: updateCustomer
     * @Description: 根据客户对象信息修改客户对象
     * @author wangzhenxin
     * @date 2017-10-24
     * @param customer 客户信息对象
     */

    public void updateCustomer(Customer customer);

    /**
     * @Title: deleteCustomer
     * @Description: 根据客户对象信息删除客户对象
     * @author wangzhenxin
     * @date 2017-10-24
     * @param customer 客户信息对象
     */

    public void deleteCustomer(Customer customer);
}
