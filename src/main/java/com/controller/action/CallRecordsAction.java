package com.controller.action;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.controller.action
 * @author wangzhenxin
 * @date 2017-09-29 8:52
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.base.BaseAction;
import com.domain.CallRecords;
import com.domain.Customer;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.service.CallRecordsService;
import com.service.CallRecordsServiceImpl;
import com.vo.CallRecordsVo;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangzhenxin
 * @ClassName CallRecordsAction
 * @Description 类描述
 * @date 2017-09-29
 */
@Action

@Results({

})

public class CallRecordsAction extends BaseAction {
    private String customerId;

    @Resource
    private CallRecordsService callRecordsService;


    public void findCallRecords() throws IOException,ServletException{
        Gson gson = new Gson();
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = null;
        out = response.getWriter();

        List<CallRecords> callRecordsList = new ArrayList<CallRecords>();
        callRecordsList =  callRecordsService.findAllCallRecords(Long.parseLong(customerId));
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

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
