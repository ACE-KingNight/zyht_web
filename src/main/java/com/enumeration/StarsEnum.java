package com.enumeration;/********************************************************************
 /**
 * @Project: test_web
 * @Package mobile_package.enumeration
 * @author wangzhenxin
 * @date 2017-08-31 17:30
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

/**
 * @author wangzhenxin
 * @EnumName StarsEnum
 * @Description 星级枚举
 * @date 2017-08-31
 */
public enum StarsEnum {
    ONE_STAR((byte)1,"一星级"),
    TWO_STAR((byte)2,"二星级"),
    THREE_STAR((byte)3,"三星级"),
    FOUR_STAR((byte)4,"四星级"),
    FIVE_STAR((byte)5,"五星级"),
    SUPER_STAR((byte)6,"超级vip");


    /**
     * 类型
     */
    private Byte type;
    /**
     * 类型描述
     */
    private String description;

    StarsEnum(Byte type, String description) {
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
