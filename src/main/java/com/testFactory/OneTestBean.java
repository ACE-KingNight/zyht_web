package com.testFactory;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.bean
 * @author guohongjin
 * @date 2017/10/16 11:10
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

/**
 * @author guohongjin
 * @ClassName OneTestBean
 * @Description 类描述
 * @date 2017/10/16
 */
public class OneTestBean implements TestBeanInterface {

    private String oneTest;

    public String getOneTest() {
        return oneTest;
    }

    public void setOneTest(String oneTest) {
        this.oneTest = oneTest;
    }

    @Override
    public void test(Class cla) {

    }

    private TwoTestBean twoTestBean;

    public OneTestBean() {

    }

    public OneTestBean(String oneTest,TwoTestBean twoTestBean) {
        this.oneTest = oneTest;
        this.twoTestBean=twoTestBean;
    }


}
