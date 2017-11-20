package com.controller;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.controller
 * @author wangzhenxin
 * @date 2017-09-26 16:12
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.domain.CallRecords;
import com.domain.Customer;
import com.google.gson.Gson;
import com.service.CallService;
import com.service.CallServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wangzhenxin
 * @ClassName CallServlet
 * @Description 拨打电话
 * @date 2017-09-26
 */
public class CallServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException,ServletException{
        this.doPost(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws  IOException,ServletException{
        Gson gson = new Gson();
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startTime = null;
        Date endTime = null;
        try {
            startTime= simpleDateFormat.parse(request.getParameter("startTime"));
            endTime = simpleDateFormat.parse(request.getParameter("endTime"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        CallService callService = new CallServiceImpl();
        Customer callCustomer = new Customer();
        callCustomer.setId(Long.parseLong(request.getParameter("callCustomerId")));
        Customer answerCustomer = new Customer();
        answerCustomer.setId(Long.parseLong(request.getParameter("answerCustomerId")));
        CallRecords records = new CallRecords();
        records.setStartCallTime(startTime);
        records.setEndCallTime(endTime);
    }
}
