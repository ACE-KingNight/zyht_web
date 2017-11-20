package com.enumeration;/********************************************************************
 /**
 * @Project: test_web
 * @Package mobile_package.enumeration
 * @author wangzhenxin
 * @date 2017-08-31 17:22
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

/**
 * @author wangzhenxin
 * @EnumName SexEnum
 * @Description 性别枚举
 * @date 2017-08-31
 */
public enum SexEnum {
    //男性
    MALE((byte)1,"男"),
    //女性
    FEMALE((byte)2,"女性");

    /**
     * 性别类型
     */
    private Byte type;
    /**
     * 类型描述
     */
    private String description;

    SexEnum(Byte type, String description) {
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
