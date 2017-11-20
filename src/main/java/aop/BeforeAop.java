package aop;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package aop
 * @author wangzhenxin
 * @date 2017-10-18 15:47
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

/**
 * @author wangzhenxin
 * @ClassName BeforAop
 * @Description 类描述
 * @date 2017-10-18
 */
public class BeforeAop {
    public void before(){
        System.out.println("AopBefore提示");
    }
    public void after(){
        System.out.println("AopAfter提示");
    }
}
