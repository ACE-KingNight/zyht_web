package com.vo;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.vo
 * @author wangzhenxin
 * @date 2017-09-24 14:11
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.domain.PackPurInformation;

/**
 * @author wangzhenxin
 * @ClassName PackPurInformationVo
 * @Description 类描述
 * @date 2017-09-24
 */
public class PackPurInformationVo extends PackPurInformation {
    //客户姓名
    private String customerName;
    //套餐名
    private String packageInformationName;
    //购买时间
    private String buyTimeStr;
    //执行时间
    private String effectTimeStr;

    public String getBuyTimeStr() {
        return buyTimeStr;
    }

    public void setBuyTimeStr(String buyTimeStr) {
        this.buyTimeStr = buyTimeStr;
    }

    public String getEffectTimeStr() {
        return effectTimeStr;
    }

    public void setEffectTimeStr(String effectTimeStr) {
        this.effectTimeStr = effectTimeStr;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPackageInformationName() {
        return packageInformationName;
    }

    public void setPackageInformationName(String packageInformationName) {
        this.packageInformationName = packageInformationName;
    }
}
