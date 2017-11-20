package com.enumeration;/********************************************************************
 /**
 * @Project: test_web
 * @Package mobile_package.enumeration
 * @author wangzhenxin
 * @date 2017-08-31 17:52
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

/**
 * @author wangzhenxin
 * @EnumName CallDurationEnum
 * @Description 枚举描述
 * @date 2017-08-31
 */
public enum CallDurationEnum {
    LOCAL_CONNECTION_MONEY(0.00333333d,"本地通话资费"),
    LONG_TOLL_CALL_MONEY(0.008333333d,"长途通话资费"),
    ROAMING_CALLS_MONEY(0.0165d,"漫游通话资费");


    //资费
    private Double tariff;
    //资费描述
    private String description;

    CallDurationEnum(Double tariff, String description) {
        this.tariff = tariff;
        this.description = description;
    }

    public Double getTariff() {
        return tariff;
    }

    public void setTariff(Double tariff) {
        this.tariff = tariff;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
