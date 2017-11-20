package com.controller;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.controller
 * @author wangzhenxin
 * @date 2017-09-18 16:32
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
import java.io.PrintWriter;
import java.util.List;

/**
 * @author wangzhenxin
 * @ClassName CustomerSelectServlet
 * @Description 查询控制
 * @date 2017-09-18
 */
public class CustomerSelectServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException{
        this.doPost(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        Customer customer = new Customer();
        Integer type = Integer.parseInt(request.getParameter("type"));
        if(type == 1){
            customer.setId(Long.valueOf(request.getParameter("id")));
            CustomerService customerService = new CustomerServiceImpl();
            customerService.selectCustomer(customer);
            PrintWriter out = response.getWriter();
//            JSONArray jsonArray = JSONArray.fromObject(customer);
//            out.print(jsonArray);
        }else if (type == 2){
            CustomerService customerService = new CustomerServiceImpl();
            List<Customer> customerList = customerService.selectAllCustomer();
            request.setAttribute("customerList",customerList);
            request.getRequestDispatcher("/page/mobile_package/call.jsp").forward(request,response);
        }
    }
}
