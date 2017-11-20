package com.controller;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.controller
 * @author wangzhenxin
 * @date 2017-09-18 19:30
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.domain.Customer;
import com.service.CustomerService;
import com.service.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wangzhenxin
 * @ClassName CustomerDeleteServlet
 * @Description 类描述
 * @date 2017-09-18
 */
public class CustomerDeleteServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException {
        //定义客户对象
        Customer customer = new Customer();
        //设置
        request.setCharacterEncoding("utf-8");
        //设置对象ID
        customer.setId(Long.valueOf(request.getParameter("id")));
        //调用用户服务
        CustomerService customerService = new CustomerServiceImpl();
        //接收返回值
        String print = customerService.deleteCustomer(customer);
        //设置响应头
        response.setContentType("text/html;charset=UTF-8");
        //打印返回值
        response.getWriter().println(print);
    }
}
