package com.service;/********************************************************************
 /**
 * @Project: JavaWorkSpaces
 * @Package mobile_package.service
 * @author wangzhenxin
 * @date 2017-08-17 18:18
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */


import com.domain.CallRecords;
import com.domain.Customer;
import com.enumeration.CallDurationEnum;
import com.enumeration.CallEnum;
import com.enumeration.CallTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author wangzhenxin
 * @ClassName CallServiceImpl
 * @Description 拨打电话方法实现
 * @date 2017-08-17
 */
@Service("callService")
@Transactional
public class CallServiceImpl implements CallService {
    @Resource
    CustomerService customerService;
    //定义通话记录服务
    @Resource
    CallRecordsService callRecordsService;
    /**
     * @Title: call
     * @Description: 打电话方法
     * @author wangzhenxin
     * @date 2017-08-17
     * @param callCustomer 打电话者
     * @param answerCustomer    电话号码
     */
    @Override
    public List<Long> call(Customer callCustomer, Customer answerCustomer,CallRecords records) {
        List<Long> idList = new  ArrayList<Long>();
        //创建拨打电话通话记录
        CallRecords callRecords = new CallRecords();
        //定义客户service
        callCustomer = customerService.selectCustomer(callCustomer);
        //根据电话号码查找对应的客户
        answerCustomer = customerService.selectCustomer(answerCustomer);
        //设置通话记录拨打者信息
        callRecords.setCallCustomer(callCustomer);
        //设置通话记录接听者信息
        callRecords.setAnswerCustomer(answerCustomer);
        //设置通话记录为拨打者
        callRecords.setDialType(CallEnum.CALL.getType());
        //设置通话类型为本地通话
        callRecords.setCallType(CallTypeEnum.LOCAL_CONNECTION.getType());
        //向接听者发送信息
//        Integer isAnswer = answer(callRecords.xml,callCustomer,answerCustomer,callCustomer.getPhoneCode());
        //设置接听状态为接听
        callRecords.setIsAnswer(true);
        //创建接听电话通话记录
        CallRecords answerRecords = new CallRecords();
        //设置通话记录拨打者信息
        answerRecords.setCallCustomer(callCustomer);
        //设置通话记录接听者信息
        answerRecords.setAnswerCustomer(answerCustomer);
        //设置通话记录为接听者
        answerRecords.setDialType(CallEnum.ANSWER.getType());
        //设置开始通话时间
        callRecords.setStartCallTime(records.getStartCallTime());
        answerRecords.setStartCallTime(records.getStartCallTime());

        //更新通话记录
        Long callRecordId = callRecordsService.insertCallRecordsByCallRecords(callRecords);
        Long answerRecordId = callRecordsService.insertCallRecordsByCallRecords(answerRecords);
        idList.add(callRecordId);
        idList.add(answerRecordId);
        return idList;
    }

    @Override
    public String callClose(Long callRecordId, Long answerRecordId) {
        CallRecords callRecords = callRecordsService.findCallRecordsById(callRecordId);
        CallRecords answerRecords = callRecordsService.findCallRecordsById(answerRecordId);
        Customer callCustomer = callRecords.getCallCustomer();
//        //根据电话号码查找对应的客户
//        answerCustomer = customerService.selectCustomer(answerCustomer);
        //设置通话结束时间
        callRecords.setEndCallTime(new Date());
        answerRecords.setEndCallTime(new Date());
        //定义通话时长
        long callDuration = (callRecords.getEndCallTime().getTime() - callRecords.getStartCallTime().getTime()) / 1000;
        callRecords.setCallDuration(callDuration);
        answerRecords.setCallDuration(callDuration);
        //根据通话类型计算通话资费
        switch (callRecords.getCallType().intValue()) {
            //本地通话
            case 1:
                //设置资费
                callRecords.setConsumption(callDuration * CallDurationEnum.LOCAL_CONNECTION_MONEY.getTariff().doubleValue());
                //扣除拨打者交费费用
                callCustomer.setBalance(callCustomer.getBalance().doubleValue() - callRecords.getConsumption().doubleValue());
                break;
            //长途通话
            case 2:
                //设置资费
                callRecords.setConsumption(callDuration * CallDurationEnum.LONG_TOLL_CALL_MONEY.getTariff().doubleValue());
                //扣除拨打者交费费用
                callCustomer.setBalance(callCustomer.getBalance().doubleValue() - callRecords.getConsumption().doubleValue());
                break;
            case 3:
                //设置资费
                callRecords.setConsumption(callDuration * CallDurationEnum.ROAMING_CALLS_MONEY.getTariff().doubleValue());
                //扣除拨打者交费费用
                callCustomer.setBalance(callCustomer.getBalance().doubleValue() - callRecords.getConsumption().doubleValue());
                break;
        }
        //跟新客户信息
        System.out.println("电话:"+callRecords.getConsumption());
        customerService.updateCustomer(callCustomer);
        callRecordsService.updateCallRecordsByCallRecords(callRecords);
        callRecordsService.updateCallRecordsByCallRecords(answerRecords);
        return "通话结束";
    }

}
