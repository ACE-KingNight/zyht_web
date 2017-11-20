package com.interceptor;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.interceptor
 * @author wangzhenxin
 * @date 2017-10-10 15:18
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.controller.action.LoginAction;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import org.apache.struts2.dispatcher.HttpParameters;

/**
 * @author wangzhenxin
 * @ClassName MyInterceptor
 * @Description 类描述
 * @date 2017-10-10
 */
public class MyInterceptor implements Interceptor {
    @Override
    public void destroy() {

    }

    @Override
    public void init() {

    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
//        System.out.println("测试拦截器");
        return invocation.invoke();
//        HttpParameters httpParameters = invocation.getInvocationContext().getParameters();
//        if (invocation.getAction() instanceof LoginAction){
//            return invocation.invoke();
//        }else if (httpParameters.get("name").getValue().equals("test")){
//            return invocation.invoke();
//        }else {
//        return Action.ERROR;
//        }
    }
}
