package com.domain;/********************************************************************
 /**
 * @Project: JavaWorkSpaces
 * @Package work_8_14
 * @author wangzhenxin
 * @date 2017-08-14 20:47
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.base.IdEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author wangzhenxin
 * @ClassName PackageInformation
 * @Description 套餐信息实体类
 * @date 2017-08-14
 */
public class PackageInformation extends IdEntity<Long> {
    /**
     *  mealNumber 套餐编号
     */
     private String mealNumber; //MEAL_NUMBER
    /**
     *mealName 套餐名称
     */
    private String mealName; //MEAL_NAME
    /**
     * mealDescribe 套餐描述
     */
    private String mealDescribe; //MEAL_DESCRIBE
    /**
     * messageNumber 短信条数
     * */
    private Integer messageNumber; //MESSAGE_NUMBER
    /**
     * minuteNumber 通话时长
     */
    private Integer minuteNumber; //MINUTE_NUMBER
    /**
     * flowNumber 手机流量
     */
    private Double flowNumber; //FLOW_NUMBER
    /**
     * unit 流量单位 1-KB,2-MB,3-GB,4-TB
     */
    private String unit;//UNIT
    /**
     * isCall 是否有来电提醒 TRUE-是，FALSE-否'
     */
    private Boolean isCall; //IS_CALL
    /**
     * isColorBack 是否有彩铃 TRUE-是，FALSE-否'
     */
    private Boolean isColorBack; //IS_COLOR_BACK
    /**
     * monthlyRent 月租
     */
    private Double monthlyRent; //MONTHLY_RENT
    /**
     * mealStartDate 套餐开始时间 yyyy-MM-dd
     */
    private Date mealStartDate;//MEAL_START_DATE
    /**
     * mealEndDate 套餐结束时间 yyyy-MM-dd
     */
    private Date mealEndDate;//MEAL_END_DATE
    /**
     * customerList 客户对象集合
     */
//    private List<Customer> customerList = new ArrayList<Customer>();
    /**
     * packPurInformationList 购买信息集合
     */
//    private List<PackPurInformation> packPurInformationList = new ArrayList<PackPurInformation>();

    public String getMealNumber() {
        return mealNumber;
    }

    public void setMealNumber(String mealNumber) {
        this.mealNumber = mealNumber;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getMealDescribe() {
        return mealDescribe;
    }

    public void setMealDescribe(String mealDescribe) {
        this.mealDescribe = mealDescribe;
    }

    public Integer getMessageNumber() {
        return messageNumber;
    }

    public void setMessageNumber(Integer messageNumber) {
        this.messageNumber = messageNumber;
    }

    public Integer getMinuteNumber() {
        return minuteNumber;
    }

    public void setMinuteNumber(Integer minuteNumber) {
        this.minuteNumber = minuteNumber;
    }

    public Double getFlowNumber() {
        return flowNumber;
    }

    public void setFlowNumber(Double flowNumber) {
        this.flowNumber = flowNumber;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Boolean getIsCall() {
        return isCall;
    }

    public void setIsCall(Boolean isCall) {
        this.isCall = isCall;
    }

    public Boolean getIsColorBack() {
        return isColorBack;
    }

    public void setIsColorBack(Boolean isColorBack) {
        this.isColorBack = isColorBack;
    }

    public Double getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(Double monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public Date getMealStartDate() {
        return mealStartDate;
    }

    public void setMealStartDate(Date mealStartDate) {
        this.mealStartDate = mealStartDate;
    }

    public Date getMealEndDate() {
        return mealEndDate;
    }

    public void setMealEndDate(Date mealEndDate) {
        this.mealEndDate = mealEndDate;
    }

    @Override
    public String toString() {
        return "PackageInformation{" +
                "mealNumber='" + mealNumber + '\'' +
                ", mealName='" + mealName + '\'' +
                ", mealDescribe='" + mealDescribe + '\'' +
                ", messageNumber=" + messageNumber +
                ", minuteNumber=" + minuteNumber +
                ", flowNumber=" + flowNumber +
                ", unit=" + unit +
                ", isCall=" + isCall +
                ", isColorBack=" + isColorBack +
                ", monthlyRent=" + monthlyRent +
                ", mealStartDate=" + mealStartDate +
                ", mealEndDate=" + mealEndDate +
                '}';
    }
}
