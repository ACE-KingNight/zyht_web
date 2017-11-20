package com.controller.action;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.controller.action
 * @author wangzhenxin
 * @date 2017-10-12 9:23
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.base.BaseAction;
import com.domain.Customer;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.service.CustomerService;
import com.service.CustomerServiceImpl;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangzhenxin
 * @ClassName AngularAction
 * @Description 类描述
 * @date 2017-10-12
 */
@Action

@Results({

})
public class AngularAction extends BaseAction{

    @Resource
    private CustomerService customerService;

    public void findAllCustomer() throws IOException,ServletException{
        Gson gson = new Gson();
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = null;
        out = response.getWriter();
        List<Customer> customerList = new ArrayList<Customer>();
//        CustomerService customerService = new CustomerServiceImpl();
        customerList = customerService.selectAllCustomer();
        out.print(gson.toJson(customerList));
        out.flush();
        out.close();
    }
}
