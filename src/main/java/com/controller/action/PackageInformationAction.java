package com.controller.action;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.controller.action
 * @author wangzhenxin
 * @date 2017-09-29 11:47
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.base.BaseAction;
import com.domain.PackageInformation;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.service.PackageInformationService;
import com.service.PackageInformationServiceImpl;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangzhenxin
 * @ClassName PackageInformationAction
 * @Description 类描述
 * @date 2017-09-29
 */
@Action

@Results({
        @Result(name ="packageinformation", location = "/page/mobile_package/packageinformation.jsp")
})
public class PackageInformationAction extends BaseAction {
    private String id;
    private String mealNumber;
    private String mealName;
    private String mealDescribe;
    private String messageNumber;
    private String minuteNumber;
    private String flowNumber;
    private String isCall;
    private String isColorBack;
    private String monthlyRent;
    private String unit;
    private String mealStartDate;
    private String mealEndDate;

    PackageInformation packageInformation = new PackageInformation();

    @Resource
    private PackageInformationService packageInformationService;
    Gson gson = new Gson();


    /**
     * @Title: insertPackageInformation
     * @Description: 插入一天新的套餐信息
     * @author wangzhenxin
     * @date 2017-09-29
     */

    public void insertPackageInformation() throws IOException,SerialException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        packageInformation.setMealNumber(mealNumber);
        packageInformation.setMealName(mealName);
        packageInformation.setMealDescribe(mealDescribe);
        packageInformation.setMessageNumber(Integer.valueOf(messageNumber));
        packageInformation.setMinuteNumber(Integer.valueOf(minuteNumber));
        packageInformation.setFlowNumber(Double.valueOf(flowNumber));
        packageInformation.setIsCall(Boolean.valueOf(isCall));
        packageInformation.setIsColorBack(Boolean.valueOf(isColorBack));
        packageInformation.setMonthlyRent(Double.valueOf(monthlyRent));
        packageInformation.setUnit(unit);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            packageInformation.setMealStartDate(simpleDateFormat.parse(mealStartDate));
            packageInformation.setMealEndDate(simpleDateFormat.parse(mealEndDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String string = packageInformationService.savePackageInformation(packageInformation);
        out.print(gson.toJson(string));
        out.flush();
        out.close();
    }

    /**
     * @Title: updatePackageInformation
     * @Description: 修改一条套餐信息
     * @author wangzhenxin
     * @date 2017-09-29
     */

    public void updatePackageInformation() throws IOException,SerialException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        packageInformation.setId(Long.parseLong(id));
        packageInformation.setMealNumber(mealNumber);
        packageInformation.setMealName(mealName);
        packageInformation.setMealDescribe(mealDescribe);
        packageInformation.setMessageNumber(Integer.valueOf(messageNumber));
        packageInformation.setMinuteNumber(Integer.valueOf(minuteNumber));
        packageInformation.setFlowNumber(Double.valueOf(flowNumber));
        packageInformation.setIsCall(Boolean.valueOf(isCall));
        packageInformation.setIsColorBack(Boolean.valueOf(isColorBack));
        packageInformation.setMonthlyRent(Double.valueOf(monthlyRent));
        packageInformation.setUnit(unit);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            packageInformation.setMealStartDate(simpleDateFormat.parse(mealStartDate));
            packageInformation.setMealEndDate(simpleDateFormat.parse(mealEndDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
//        String string = "test";
        String string = packageInformationService.updatePackageInformation(packageInformation);
        out.println(gson.toJson(string));
        out.flush();
        out.close();
    }
    public String jumpAction(){
        return "packageinformation";
    }

    /**
     * @Title: deletePackageInformation
     * @Description: 删除套餐信息
     * @author wangzhenxin
     * @date 2017-09-29
     */

    public void deletePackageInformation() throws IOException,ServletException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        packageInformation.setId(Long.valueOf(id));
        String flage = packageInformationService.deletePackageInformation(packageInformation);
        out.print(gson.toJson(flage));
        out.flush();
        out.close();
    }

    /**
     * @Title: findPackageInformation
     * @Description: 查找一条套餐信息
     * @author wangzhenxin
     * @date 2017-09-29
     */

    public void findPackageInformation() throws IOException,ServletException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        packageInformation.setId(Long.valueOf(id));
        packageInformation = packageInformationService.findPackageInformation(packageInformation);
        out.print(gson.toJson(packageInformation));
        out.flush();
        out.close();
    }

    /**
     * @Title: findAllPackageInformation
     * @Description: 查找所有套餐信息
     * @author wangzhenxin
     * @date 2017-09-29
     */

    public void findAllPackageInformation() throws IOException,ServletException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        List<PackageInformation> packageInformationList = new ArrayList<PackageInformation>();
        packageInformationList = packageInformationService.findAllPackageInformation();
        out.print(gson.toJson(packageInformationList));
        out.flush();
        out.close();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMealNumber() {
        return mealNumber;
    }

    public void setMealNumber(String mealNumber) {
        this.mealNumber = mealNumber;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getMealDescribe() {
        return mealDescribe;
    }

    public void setMealDescribe(String mealDescribe) {
        this.mealDescribe = mealDescribe;
    }

    public String getMessageNumber() {
        return messageNumber;
    }

    public void setMessageNumber(String messageNumber) {
        this.messageNumber = messageNumber;
    }

    public String getMinuteNumber() {
        return minuteNumber;
    }

    public void setMinuteNumber(String minuteNumber) {
        this.minuteNumber = minuteNumber;
    }

    public String getFlowNumber() {
        return flowNumber;
    }

    public void setFlowNumber(String flowNumber) {
        this.flowNumber = flowNumber;
    }

    public String getIsCall() {
        return isCall;
    }

    public void setIsCall(String isCall) {
        this.isCall = isCall;
    }

    public String getIsColorBack() {
        return isColorBack;
    }

    public void setIsColorBack(String isColorBack) {
        this.isColorBack = isColorBack;
    }

    public String getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(String monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getMealStartDate() {
        return mealStartDate;
    }

    public void setMealStartDate(String mealStartDate) {
        this.mealStartDate = mealStartDate;
    }

    public String getMealEndDate() {
        return mealEndDate;
    }

    public void setMealEndDate(String mealEndDate) {
        this.mealEndDate = mealEndDate;
    }
}
