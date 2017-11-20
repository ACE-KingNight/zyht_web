package com.service;/********************************************************************
 /**
 * @Project: JavaWorkSpaces
 * @Package mobile_package.service
 * @author wangzhenxin
 * @date 2017-08-20 10:53
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.domain.Customer;

import java.util.List;

/**
 * @author wangzhenxin
 * @InterfaceName SendMessagesService
 * @Description 发送短信service
 * @date 2017-08-20
 */
public interface SendMessagesService {
    /**
     * @Title: sendMessages
     * @Description: 用户批量发送短信
     * @author wangzhenxin
     * @date 2017-08-20
     * @param sendCustomer 发送客户信息
     * @param messageContent 短信内容
     * @param customerList 接受客户电话号码集合
     */
    public String sendMessages(Customer sendCustomer, List<Customer> customerList, String messageContent);
}
