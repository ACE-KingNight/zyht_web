package com.demo;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.demo
 * @author wangzhenxin
 * @date 2017-09-15 15:40
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

/**
 * @author wangzhenxin
 * @ClassName addr
 * @Description 类描述
 * @date 2017-09-15
 */
public class addr {
    public String addStr(String[] strings){
        String str = "";
        for (int i = 0; i < strings.length; i++) {
            str = str +"   "+strings[i];
        }
        return str;
    }
}
