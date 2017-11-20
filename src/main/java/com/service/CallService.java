package com.service;/********************************************************************
 /**
 * @Project: JavaWorkSpaces
 * @Package mobile_package.service
 * @author wangzhenxin
 * @date 2017-08-17 18:16
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */


import com.domain.CallRecords;
import com.domain.Customer;

import java.util.List;

/**
 * @author wangzhenxin
 * @InterfaceName CallService
 * @Description 拨打电话方法接口
 * @date 2017-08-17
 */
public interface CallService {
    /**
     * @Title: call
     * @Description: 通话开始
     * @author wangzhenxin
     * @date 2017-08-17
     * @param callCustomer 打电话者
     * @param answerCustomer 接电话的人
     * @param records 通话记录
     */

    public List<Long> call(Customer callCustomer, Customer answerCustomer, CallRecords records);
    /**
     * @Title: callClose
     * @Description: 通话结束
     * @author wangzhenxin
     * @date 2017-08-17
     * @param callRecordId 打电话者
     * @param answerRecordId 接电话的人
     */
    public String callClose(Long callRecordId, Long answerRecordId);
//    public Integer answer(CallRecords callRecords.xml,Customer callCustomer,Customer answerCustomer,String phoneCode);
}
