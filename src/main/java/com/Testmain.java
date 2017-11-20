package com;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com
 * @author wangzhenxin
 * @date 2017-10-16 15:46
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.domain.Test;
import com.testFactory.OneTestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangzhenxin
 * @ClassName Testmain
 * @Description 类描述
 * @date 2017-10-16
 */
public class Testmain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Test test = applicationContext.getBean("test",Test.class);
//        System.out.println(test.getMap().get("name"));
        OneTestBean oneTestBean = applicationContext.getBean("oneTest", OneTestBean.class);
        System.out.println(oneTestBean.getOneTest());
    }
}
