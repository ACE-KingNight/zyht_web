package com.testFactory;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.bean
 * @author guohongjin
 * @date 2017/10/16 11:19
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

/**
 * @author guohongjin
 * @ClassName TestBeanFactory
 * @Description 类描述
 * @date 2017/10/16
 */
public class TestBeanFactory {

    public static TestBeanInterface crate(Class cla){
        try {
//            if (cla == OneTestBean.class){
//
            return (TestBeanInterface) cla.newInstance();
//
//            }else{
//                return (TestBeanInterface)cla
//            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return  null;

    }

}
