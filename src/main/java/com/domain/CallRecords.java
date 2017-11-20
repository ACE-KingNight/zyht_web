package com.domain;/********************************************************************
 /**
 * @Project: JavaWorkSpaces
 * @Package mobile_package
 * @author wangzhenxin
 * @date 2017-08-17 18:03
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.base.IdEntity;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author wangzhenxin
 * @ClassName CallRecords
 * @Description 通话记录实体类
 * @date 2017-08-17
 */
public class CallRecords extends IdEntity<Long> {
    /**
     * callCustomerId 拨打客户信息Id
     */
    private Customer callCustomer;//CALL_CUSTOMER_ID
    /**
     * answerCustomerId 接听客户信息ID
     */
    private Customer answerCustomer;//ANSWER_CUSTOMER_ID
    /**
     * callDuration 通话时长
     */
    private Long callDuration;//CALL_DURATION
    /**
     * consumption 本次消费 yyyy-MM-dd HH:mm:ss
     */
    private Double consumption;//CONSUMPTION
    /**
     * startCallTime 本次通话开始时间 yyyy-MM-dd HH:mm:ss
     */
    private Date startCallTime;//START_CALL_TIME
    /**
     * endCallTime 本次通话结束时间
     */
    private Date endCallTime;//END_CALL_TIME
    /**
     * callType 通话类型 1-本地通话,2-长途通话,3-漫游通话
     */
    private Byte callType;//CALL_TYPE
    /**
     * isAnswer 是否接听 true-是,false-否
     */
    private Boolean isAnswer;//IS_ANSWER
    /**
     * dialType 拨打类型 1-拨打,2-接听
     */
    private Byte dialType;//DIAL_TYPE

    public Customer getCallCustomer() {
        return callCustomer;
    }

    public void setCallCustomer(Customer callCustomer) {
        this.callCustomer = callCustomer;
    }

    public Customer getAnswerCustomer() {
        return answerCustomer;
    }

    public void setAnswerCustomer(Customer answerCustomer) {
        this.answerCustomer = answerCustomer;
    }

    public Long getCallDuration() {
        return callDuration;
    }

    public void setCallDuration(Long callDuration) {
        this.callDuration = callDuration;
    }

    public Double getConsumption() {
        return consumption;
    }

    public void setConsumption(Double consumption) {
        this.consumption = consumption;
    }

    public Date getStartCallTime() {
        return startCallTime;
    }

    public void setStartCallTime(Date startCallTime) {
        this.startCallTime = startCallTime;
    }

    public Date getEndCallTime() {
        return endCallTime;
    }

    public void setEndCallTime(Date endCallTime) {
        this.endCallTime = endCallTime;
    }

    public Byte getCallType() {
        return callType;
    }

    public void setCallType(Byte callType) {
        this.callType = callType;
    }

    public Boolean getIsAnswer() {
        return isAnswer;
    }

    public void setIsAnswer(Boolean isAnswer) {
        this.isAnswer = isAnswer;
    }

    public Byte getDialType() {
        return dialType;
    }

    public void setDialType(Byte dialType) {
        this.dialType = dialType;
    }
}
