package com.testFactory;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.bean
 * @author guohongjin
 * @date 2017/10/16 11:10
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import java.util.Map;

/**
 * @author guohongjin
 * @ClassName TwoTestBean
 * @Description 类描述
 * @date 2017/10/16
 */
public class TwoTestBean implements TestBeanInterface {

    private String twoTest;

    private Map<Object,Object> map;

    public String getTwoTest() {
        return twoTest;
    }

    public void setTwoTest(String twoTest) {
        this.twoTest = twoTest;
    }

    @Override
    public void test(Class cla) {

    }

    @Override
    public void setOneTest(String oneTest) {
        this.twoTest=oneTest;
    }

    public Map<Object, Object> getMap() {
        return map;
    }

    public void setMap(Map<Object, Object> map) {
        this.map = map;
    }
}
