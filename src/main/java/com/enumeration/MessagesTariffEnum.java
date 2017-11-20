package com.enumeration;/********************************************************************
 /**
 * @Project: test_web
 * @Package mobile_package.enumeration
 * @author wangzhenxin
 * @date 2017-08-31 17:58
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

/**
 * @author wangzhenxin
 * @EnumName MessagesTariffEnum
 * @Description 短信资费枚举
 * @date 2017-08-31
 */
public enum MessagesTariffEnum {
    MESSAGES_TARIFF(0.1d,"短信资费"),
    MULTIMEDIA_MESSAGE_TARIFF(0.5d,"彩信资费");
    //资费
    private Double tariff;
    //资费描述
    private String description;

    MessagesTariffEnum(Double tariff, String description) {
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
