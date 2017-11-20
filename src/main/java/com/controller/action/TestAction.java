package com.controller.action;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.controller.action
 * @author wangzhenxin
 * @date 2017-09-27 16:30
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.domain.Test;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContext;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author wangzhenxin
 * @ClassName TestAction
 * @Description 类描述
 * @date 2017-09-27
 */
@Action

@Results({
        @Result(name = "index", location = "/index.jsp")
})

public class TestAction extends ActionSupport {
//    @Autowired
//    private Test test;
    public String test(){
        System.out.println("测试test");
//        System.out.println(test.getName());
//        ServletActionContext
//        ActionContext.getContext()
//        HttpServletResponse response = ServletActionContext.getResponse();
        HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get("response");

        return "index";
    }
}
