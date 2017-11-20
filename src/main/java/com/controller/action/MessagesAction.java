package com.controller.action;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.controller.action
 * @author wangzhenxin
 * @date 2017-09-29 11:30
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.base.BaseAction;
import com.domain.Customer;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.service.SendMessagesService;
import com.service.SendMessagesServiceImpl;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
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
 * @ClassName MessagesAction
 * @Description 类描述
 * @date 2017-09-29
 */
@Action

@Results({

})
public class MessagesAction extends BaseAction{
    private String customerId;
    private String callCustomerId;
    private String answerCustomerId;
    private String messages;

    @Resource
    private SendMessagesService sendMessagesService;

    public void sendMessage() throws IOException,ServletException{
        Gson gson = new Gson();
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        Customer callCustomer = new Customer();
        callCustomer.setId(Long.parseLong(callCustomerId));
        Customer answerCustomer = new Customer();
        answerCustomer.setId(Long.parseLong(answerCustomerId));
        String messageContent = messages;
        List<Customer> receiveCustomerList = new ArrayList<Customer>();
        receiveCustomerList.add(answerCustomer);
        String string = sendMessagesService.sendMessages(callCustomer, receiveCustomerList, messageContent);
        out.print(gson.toJson(string));
        out.close();
    }


    public String getCallCustomerId() {
        return callCustomerId;
    }

    public void setCallCustomerId(String callCustomerId) {
        this.callCustomerId = callCustomerId;
    }

    public String getAnswerCustomerId() {
        return answerCustomerId;
    }

    public void setAnswerCustomerId(String answerCustomerId) {
        this.answerCustomerId = answerCustomerId;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
