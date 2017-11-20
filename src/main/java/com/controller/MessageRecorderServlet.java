package com.controller;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.controller
 * @author wangzhenxin
 * @date 2017-09-27 9:22
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.domain.Messages;
import com.google.gson.Gson;
import com.service.CallRecordsService;
import com.service.CallRecordsServiceImpl;
import com.service.MessagesService;
import com.service.MessagesServiceImpl;
import com.vo.MessagesVo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangzhenxin
 * @ClassName MessageRecorderServlet
 * @Description 类描述
 * @date 2017-09-27
 */
public class MessageRecorderServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException {
        this.doPost(request,response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{
        Gson gson = new Gson();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        MessagesService messagesService = new MessagesServiceImpl();
        List<Messages> messagesList = new ArrayList<Messages>();
        messagesList = messagesService.findAllMessage(Long.parseLong(request.getParameter("customerId")));
        List<MessagesVo> messagesVos = new ArrayList<MessagesVo>();
        for (int i = 0; i < messagesList.size(); i++) {
            MessagesVo messagesVo = new MessagesVo();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            messagesVo.setReceiveTime(simpleDateFormat.format(messagesList.get(i).getReceiveMessagesTime()));
            messagesVo.setSendTime(simpleDateFormat.format(messagesList.get(i).getSendMessagesTime()));
            messagesVo.setCustomerType(messagesList.get(i).getCustomerType());
            messagesVo.setMessagesType(messagesList.get(i).getMessagesType());
            messagesVo.setIsReceive(messagesList.get(i).getIsReceive());
            messagesVo.setConsumption(messagesList.get(i).getConsumption());
            messagesVo.setSendCustomer(messagesList.get(i).getSendCustomer());
            messagesVo.setReceiveCustomer(messagesList.get(i).getReceiveCustomer());
            messagesVo.setMessageContent(messagesList.get(i).getMessageContent());
            messagesVos.add(messagesVo);
        }
        out.print(gson.toJson(messagesVos));
        out.close();
    }
}
