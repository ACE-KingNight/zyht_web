package com.domain;/********************************************************************
 /**
 * @Project: JavaWorkSpaces
 * @Package work_8_15
 * @author wangzhenxin
 * @date 2017-08-15 18:18
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.base.IdEntity;

import java.util.Date;

/**
 * @author wangzhenxin
 * @ClassName PackPurInformation
 * @Description 套餐购买信息实体类
 * @date 2017-08-15
 */
public class PackPurInformation extends IdEntity<Long> {
    /**
     * buyTime 购买日期 yyyy-MM-dd HH:mm:ss
     */
    private Date buyTime;//BUY_TIME
    /**
     * customerId 客户信息Id
     */
    private Customer customer;//CUSTOMER_ID
    /**
     *packageInformationId 套餐信息Id
     */
    private PackageInformation packageInformation;//PACKAGE_INFORMATION_ID
    /**
     *amountOfPayment 支付金额
     */
    private Double amountOfPayment;//AMOUNT_OF_PAYMENT
    /**
     *isSuccess 是否支付成功 true-是,false-否
     */
    private Boolean isSuccess = false;//IS_SUCCESS
    /**
     *effectTime 套餐执行时间
     */
    private Date effectTime;//EFFECT_TIME




    public Date getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Date buyTime) {
        this.buyTime = buyTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public PackageInformation getPackageInformation() {
        return packageInformation;
    }

    public void setPackageInformation(PackageInformation packageInformation) {
        this.packageInformation = packageInformation;
    }

    public Double getAmountOfPayment() {
        return amountOfPayment;
    }

    public void setAmountOfPayment(Double amountOfPayment) {
        this.amountOfPayment = amountOfPayment;
    }

    public Boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public Date getEffectTime() {
        return effectTime;
    }

    public void setEffectTime(Date effectTime) {
        this.effectTime = effectTime;
    }

    @Override
    public String toString() {
        return "PackPurInformation{" +
                "buyTime=" + buyTime +
                ", customer=" + customer +
                ", packageInformation=" + packageInformation +
                ", amountOfPayment=" + amountOfPayment +
                ", isSuccess=" + isSuccess +
                ", effectTime=" + effectTime +
                '}';
    }
}
