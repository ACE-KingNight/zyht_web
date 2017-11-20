package com.controller.action;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.controller.action
 * @author wangzhenxin
 * @date 2017-09-29 9:07
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.base.BaseAction;
import com.domain.Customer;
import com.domain.Messages;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.service.MessagesService;
import com.service.MessagesServiceImpl;
import com.vo.MessagesVo;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author wangzhenxin
 * @ClassName MessageRecordsAction
 * @Description 类描述
 * @date 2017-09-29
 */
@Action

@Results({

})
public class MessageRecordsAction extends BaseAction {

    private String customerId;

    @Resource
    private MessagesService messagesService;




    public void findMessageRecords() throws IOException,ServletException{
        Gson gson = new Gson();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        List<Messages> messagesList = new ArrayList<Messages>();

        messagesList = messagesService.findAllMessage(Long.parseLong(customerId));
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
            if(messagesList.get(i).getSendCustomer() == null){
                Customer nullCustomer =new Customer();
                nullCustomer.setName("该用户已被删除");
                messagesVo.setSendCustomer(nullCustomer);
            }else {
                messagesVo.setSendCustomer(messagesList.get(i).getSendCustomer());
            }
            if(messagesList.get(i).getReceiveCustomer() ==null){
                Customer nullCustomer =new Customer();
                nullCustomer.setName("该用户已被删除");
                messagesVo.setReceiveCustomer(nullCustomer);
            }else {
                messagesVo.setReceiveCustomer(messagesList.get(i).getReceiveCustomer());
            }
            messagesVo.setMessageContent(messagesList.get(i).getMessageContent());
            messagesVos.add(messagesVo);
        }
        out.print(gson.toJson(messagesVos));
        out.close();
    }


    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
