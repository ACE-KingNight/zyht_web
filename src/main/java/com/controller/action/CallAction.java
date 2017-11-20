package com.controller.action;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.controller.action
 * @author wangzhenxin
 * @date 2017-09-29 9:24
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.base.BaseAction;
import com.domain.CallRecords;
import com.domain.Customer;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.service.CallService;
import com.service.CallServiceImpl;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author wangzhenxin
 * @ClassName CallAction
 * @Description 类描述
 * @date 2017-09-29
 */
@Action
@Results({

})
public class CallAction extends BaseAction{
    private String startTime;
    private String endTime;
    private String callCustomerId;
    private String answerCustomerId;
    private String callRecordId;
    private String answerRecordId;

    @Resource
    private CallService callService;

    public void insertCall() throws IOException,ServletException{
        Gson gson = new Gson();
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        Customer callCustomer = new Customer();
        callCustomer.setId(Long.parseLong(callCustomerId));
        Customer answerCustomer = new Customer();
        answerCustomer.setId(Long.parseLong(answerCustomerId));
        CallRecords records = new CallRecords();
        Date startCallTime = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String count = simpleDateFormat.format(startCallTime);
        try {
            startCallTime = simpleDateFormat.parse(count);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        records.setStartCallTime(startCallTime);
        List<Long> idList = new ArrayList<Long>();
        idList = callService.call(callCustomer, answerCustomer, records);
        out.print(gson.toJson(idList));
        out.close();
    }
    public void updateCall()throws IOException,ServletException{
        Gson gson = new Gson();
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        Long callRecordIds = Long.parseLong(callRecordId);
        Long answerRecordIds = Long.parseLong(answerRecordId);
        String string = callService.callClose(callRecordIds, answerRecordIds);
        out.print(gson.toJson(string));
        out.close();
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
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

    public String getCallRecordId() {
        return callRecordId;
    }

    public void setCallRecordId(String callRecordId) {
        this.callRecordId = callRecordId;
    }

    public String getAnswerRecordId() {
        return answerRecordId;
    }

    public void setAnswerRecordId(String answerRecordId) {
        this.answerRecordId = answerRecordId;
    }
}
