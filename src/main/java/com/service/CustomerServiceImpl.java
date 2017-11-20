package com.service;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.service
 * @author wangzhenxin
 * @date 2017-09-15 21:13
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.base.BaseServiceImpl;
import com.dao.CustomerDao;
import com.dao.CustomerDaoImpl;
import com.dao.MybatisPackageInformationDao.MybatisCustomerDao;
import com.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wangzhenxin
 * @ClassName CustomerServiceImpl
 * @Description CustomerService实现
 * @date 2017-09-15
 */
@Service("customerService")
@Transactional
public class CustomerServiceImpl extends BaseServiceImpl<Long,Customer,Customer> implements CustomerService {

//    //定义客户Dao对象
//    @Autowired
//    private CustomerDao customerDao;

//    //构造方法
//    public CustomerServiceImpl(){
//        super.setBaseDao(customerDao);
//    }

    @Autowired
    private MybatisCustomerDao mybatisCustomerDao;

    @Override
    public String saveCustomer(Customer customer) {
//        //定义CustomerDao
//        CustomerDao customerDao = new CustomerDaoImpl();
//        return customerDao.saveCustomer(customer);
//        调用BaseDao中的save方法
//        save(customer);
        mybatisCustomerDao.insertCustomer(customer);
        return"添加成功";
    }

    @Override
    public Customer selectCustomer(Customer customer) {
//        return customerDao.selectCustomer(customer);
        return mybatisCustomerDao.getCustomer(customer);
    }

    @Override
    public String updateCustomer(Customer customer) {
        mybatisCustomerDao.updateCustomer(customer);
        return "修改成功";
    }

    @Override
    public String deleteCustomer(Customer customer) {
        mybatisCustomerDao.deleteCustomer(customer);
        return "删除成功";
    }

    @Override
    public List<Customer> selectAllCustomer() {
//        return customerDao.selectAllCustomer();
        return mybatisCustomerDao.getAllCustomer();
    }
}
