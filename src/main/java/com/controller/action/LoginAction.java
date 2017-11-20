package com.controller.action;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.controller.action
 * @author wangzhenxin
 * @date 2017-10-10 16:11
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author wangzhenxin
 * @ClassName LoginAction
 * @Description 类描述
 * @date 2017-10-10
 */
@Action

@Results({
        @Result(name = "test",location = "/test.jsp")
})
public class LoginAction extends ActionSupport implements ServletRequestAware,SessionAware{
    HttpServletRequest request;
    private Map session;

    public String test(){
        request.setAttribute("test","测试");
        session.put("testSession","测试session");
        return "test";
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request= request;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
