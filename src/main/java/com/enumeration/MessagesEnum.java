package com.enumeration;/********************************************************************
 /**
 * @Project: test_web
 * @Package mobile_package.enumeration
 * @author wangzhenxin
 * @date 2017-08-31 18:02
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

/**
 * @author wangzhenxin
 * @EnumName MessagesEnum
 * @Description 短信类型枚举
 * @date 2017-08-31
 */
public enum MessagesEnum {
    MESSAGES((byte)1,"短信"),
    MULTIMEDIA_MESSAGES((byte)2,"彩信");

    /**
     * 类型
     */
    private Byte type;
    /**
     * 类型描述
     */
    private String description;

    MessagesEnum(Byte type, String description) {
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
