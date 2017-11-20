package com.controller;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.controller
 * @author wangzhenxin
 * @date 2017-09-26 18:20
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.domain.Customer;
import com.google.gson.Gson;
import com.service.SendMessagesService;
import com.service.SendMessagesServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangzhenxin
 * @ClassName MessagesServlet
 * @Description 类描述
 * @date 2017-09-26
 */
public class MessagesServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException,ServletException{
        this.doPost(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException,ServletException{
        Gson gson = new Gson();
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        Customer callCustomer = new Customer();
        callCustomer.setId(Long.parseLong(request.getParameter("callCustomerId")));
        Customer answerCustomer = new Customer();
        answerCustomer.setId(Long.parseLong(request.getParameter("answerCustomerId")));
        String messageContent = request.getParameter("messages");
        List<Customer> receiveCustomerList = new ArrayList<Customer>();
        receiveCustomerList.add(answerCustomer);
        SendMessagesService sendMessagesService = new SendMessagesServiceImpl();
        String string = sendMessagesService.sendMessages(callCustomer, receiveCustomerList, messageContent);
        out.print(gson.toJson(string));
        out.close();
    }
}
