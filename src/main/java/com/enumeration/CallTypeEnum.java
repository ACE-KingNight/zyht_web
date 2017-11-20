package com.enumeration;/********************************************************************
 /**
 * @Project: test_web
 * @Package mobile_package.enumeration
 * @author wangzhenxin
 * @date 2017-08-31 17:43
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

/**
 * @author wangzhenxin
 * @EnumName CallTypeEnum
 * @Description 通话类型枚举
 * @date 2017-08-31
 */
public enum CallTypeEnum {
    LOCAL_CONNECTION((byte)1,"本地通话"),
    LONG_TOLL_CALL((byte)2,"长途通话"),
    ROAMING_CALLS((byte)3,"漫游通话");
    /**
     * 类型
     */
    private Byte type;
    /**
     * 类型描述
     */
    private String description;

    CallTypeEnum(Byte type, String description) {
        this.type = type;
        this.description = description;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
