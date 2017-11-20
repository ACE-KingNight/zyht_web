package com.domain;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.domain
 * @author wangzhenxin
 * @date 2017-09-15 17:27
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.base.IdEntity;


/**
 * @author wangzhenxin
 * @ClassName Customer
 * @Description 客户信息实体类
 * @date 2017-09-15
 */

public class Customer extends IdEntity<Long> {
    /**
     * name 客户姓名
     */
    private String name; //NAME
    /*
    * phoneCode 电话号码
    */
    private String phoneCode; //PHONE_CODE
    /*
    * sex 性别
    */
    private String sex; //SEX
    /**
     * idCard 身份证号码
     */
    private String idCard; //ID_CARD
    /**
     * address 家庭住址
     */
    private String address; //ADDRESS
    /**
     * balance 余额
     */
    private Double balance = 0d; //BALANCE
    /**
     * packageInfomation 套餐信息id
     */
//    private PackageInformation packageInformation; //PACKAGE_INFOMATION_ID
    /*
    * isShutdown 是否停机 true-是,false-否
    */
    private Boolean isShutdown = false; //IS_SHUTDOWN

//    public PackageInformation getPackageInformation() {
//        return packageInformation;
//    }
//
//    public void setPackageInformation(PackageInformation packageInformation) {
//        this.packageInformation = packageInformation;
//    }

    /**

     * isStopArrears 是否欠费 true-是,false-否
     */
    private Boolean isStopArrears = false; //IS_STOP_ARREARS
    /**
     * starStates 客户星级 1-1星级,2-2星级,3-3星级,4-4星级,5-5星级
     */
    private Byte starStates = 1; //STAR_STATES

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Boolean getIsShutdown() {
        return isShutdown;
    }

    public void setIsShutdown(Boolean isShutdown) {
        this.isShutdown = isShutdown;
    }

    public Boolean getIsStopArrears() {
        return isStopArrears;
    }

    public void setIsStopArrears(Boolean isStopArrears) {
        this.isStopArrears = isStopArrears;
    }

    public Byte getStarStates() {
        return starStates;
    }

    public void setStarStates(Byte starStates) {
        this.starStates = starStates;
    }

}
