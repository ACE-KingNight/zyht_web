package com.controller;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.controller
 * @author wangzhenxin
 * @date 2017-09-27 9:18
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.domain.CallRecords;
import com.domain.PackPurInformation;
import com.google.gson.Gson;
import com.service.CallRecordsService;
import com.service.CallRecordsServiceImpl;
import com.service.PackPurInformationService;
import com.service.PackPurInformationServiceImpl;
import com.vo.CallRecordsVo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangzhenxin
 * @ClassName CallRecordsServlet
 * @Description 通话记录controller
 * @date 2017-09-27
 */
public class CallRecordsServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException{
        this.doPost(request,response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException{
        Gson gson = new Gson();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        CallRecordsService callRecordsService = new CallRecordsServiceImpl();
        List<CallRecords> callRecordsList = new ArrayList<CallRecords>();
        callRecordsList =  callRecordsService.findAllCallRecords(Long.parseLong(request.getParameter("customerId")));
        List<CallRecordsVo> callRecordsVoList = new ArrayList<CallRecordsVo>();
        for (int i = 0; i < callRecordsList.size(); i++) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            CallRecordsVo callRecordsVo = new CallRecordsVo();
            callRecordsVo.setId(callRecordsList.get(i).getId());
            callRecordsVo.setCallCustomer(callRecordsList.get(i).getCallCustomer());
            callRecordsVo.setAnswerCustomer(callRecordsList.get(i).getAnswerCustomer());
            callRecordsVo.setCallDuration(callRecordsList.get(i).getCallDuration());
            callRecordsVo.setConsumption(callRecordsList.get(i).getConsumption());
            callRecordsVo.setDialType(callRecordsList.get(i).getDialType());
            callRecordsVo.setIsAnswer(callRecordsList.get(i).getIsAnswer());
            callRecordsVo.setCallType(callRecordsList.get(i).getCallType());
            callRecordsVo.setStartCallTime(callRecordsList.get(i).getStartCallTime());
            callRecordsVo.setEndCallTime(callRecordsList.get(i).getEndCallTime());
            callRecordsVo.setStartTime(simpleDateFormat.format(callRecordsList.get(i).getStartCallTime()));
            callRecordsVo.setEndTime(simpleDateFormat.format(callRecordsList.get(i).getEndCallTime()));
            callRecordsVoList.add(callRecordsVo);
        }
        out.print(gson.toJson(callRecordsVoList));
        out.close();
    }
}
