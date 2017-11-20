package com.base;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.base
 * @author wangzhenxin
 * @date 2017-10-18 16:36
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wangzhenxin
 * @ClassName BaseAction
 * @Description 类描述
 * @date 2017-10-18
 */
public class BaseAction extends ActionSupport implements ServletRequestAware,ServletResponseAware,ServletContextAware {
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected ServletContext servletContext;

    @Override
    public void setServletContext(ServletContext context) {
        this.servletContext = context;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }
}
