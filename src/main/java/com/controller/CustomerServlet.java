package com.controller;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.controller
 * @author wangzhenxin
 * @date 2017-09-15 21:37
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
 * @ClassName CustomerServlet
 * @Description Customer
 * @date 2017-09-15
 */
public class CustomerServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException{
        //定义客户对象
        Customer customer = new Customer();
        //设置对象ID
        customer.setId(5l);
        //设置
        request.setCharacterEncoding("utf-8");
        //接收姓名
        customer.setName(request.getParameter("name"));
        //接收性别
        customer.setSex(request.getParameter("sex"));
        //接收电话
        customer.setPhoneCode(request.getParameter("phoneCode"));
        //接收身份证
        customer.setIdCard(request.getParameter("idCard"));
        //接收地址
        customer.setAddress(request.getParameter("address"));
        //接收余额
        customer.setBalance(Double.parseDouble(request.getParameter("balance")));
        //根据余额判断是否停机
        if (customer.getBalance() <= 0){
            customer.setIsShutdown(true);
            customer.setIsStopArrears(true);
        }else {
            customer.setIsShutdown(false);
            customer.setIsStopArrears(false);
        }
        //设置用户星级
        customer.setStarStates((byte)5);
        //调用用户服务
        CustomerService customerService = new CustomerServiceImpl();
        //接收返回值
        String print = customerService.saveCustomer(customer);
        //设置响应头
        response.setContentType("text/html;charset=UTF-8");
        //打印返回值
        response.getWriter().println(print);
    }
    public void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException {

    }
}
