package com.enumeration;/********************************************************************
 /**
 * @Project: test_web
 * @Package mobile_package.enumeration
 * @author wangzhenxin
 * @date 2017-08-31 17:38
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

/**
 * @author wangzhenxin
 * @EnumName CallEnum
 * @Description 通话类型枚举
 * @date 2017-08-31
 */
public enum CallEnum {
    CALL((byte)1,"拨打者"),
    ANSWER((byte)2,"接听者");

    /**
     * 类型
     */
    private Byte type;
    /**
     * 类型描述
     */
    private String description;

    CallEnum(Byte type, String description) {
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
