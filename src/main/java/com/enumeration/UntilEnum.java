package com.enumeration;/********************************************************************
 /**
 * @Project: test_web
 * @Package mobile_package.enumeration
 * @author wangzhenxin
 * @date 2017-08-31 18:05
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

/**
 * @author wangzhenxin
 * @EnumName UntilEnum
 * @Description 流量单位枚举
 * @date 2017-08-31
 */
public enum UntilEnum {
    KB((byte)1,"KB"),
    MB((byte)2,"MB"),
    GB((byte)3,"GB"),
    TB((byte)4,"TB");
    /**
     * 类型
     */
    private Byte type;
    /**
     * 类型描述
     */
    private String description;

    UntilEnum(Byte type, String description) {
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
