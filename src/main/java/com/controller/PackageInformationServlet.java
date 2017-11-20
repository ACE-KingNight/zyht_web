package com.controller;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.controller
 * @author wangzhenxin
 * @date 2017-09-20 18:23
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.domain.PackageInformation;
import com.google.gson.Gson;
import com.service.PackageInformationService;
import com.service.PackageInformationServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * @author wangzhenxin
 * @ClassName PackageInformationServlet
 * @Description 套餐信息控制
 * @date 2017-09-20
 */
public class PackageInformationServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        Integer type = Integer.valueOf(request.getParameter("type"));
        PackageInformation packageInformation = new PackageInformation();
        PackageInformationService packageInformationService = new PackageInformationServiceImpl();
        Gson gson = new Gson();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        if (type == 1){
            packageInformation.setMealNumber(request.getParameter("mealNumber"));
            packageInformation.setMealName(request.getParameter("mealName"));
            packageInformation.setMealDescribe(request.getParameter("mealDescribe"));
            packageInformation.setMessageNumber(Integer.valueOf(request.getParameter("messageNumber")));
            packageInformation.setMinuteNumber(Integer.valueOf(request.getParameter("minuteNumber")));
            packageInformation.setFlowNumber(Double.valueOf(request.getParameter("flowNumber")));
            packageInformation.setIsCall(Boolean.valueOf(request.getParameter("isCall")));
            packageInformation.setIsColorBack(Boolean.valueOf(request.getParameter("isColorBack")));
            packageInformation.setMonthlyRent(Double.valueOf(request.getParameter("monthlyRent")));
            packageInformation.setUnit(request.getParameter("unit"));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                packageInformation.setMealStartDate(simpleDateFormat.parse(request.getParameter("mealStartDate")));
                packageInformation.setMealEndDate(simpleDateFormat.parse(request.getParameter("mealEndDate")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String string = packageInformationService.savePackageInformation(packageInformation);
            out.print(gson.toJson(string));
        }else if (type == 2){
            packageInformation.setId(Long.valueOf(request.getParameter("id")));
            String flage = packageInformationService.deletePackageInformation(packageInformation);
            out.print(gson.toJson(flage));
        }else if (type == 3){
            packageInformation.setId(Long.parseLong(request.getParameter("id")));
            packageInformation.setMealNumber(request.getParameter("mealNumber"));
            packageInformation.setMealName(request.getParameter("mealName"));
            packageInformation.setMealDescribe(request.getParameter("mealDescribe"));
            packageInformation.setMessageNumber(Integer.valueOf(request.getParameter("messageNumber")));
            packageInformation.setMinuteNumber(Integer.valueOf(request.getParameter("minuteNumber")));
            packageInformation.setFlowNumber(Double.valueOf(request.getParameter("flowNumber")));
            packageInformation.setIsCall(Boolean.valueOf(request.getParameter("isCall")));
            packageInformation.setIsColorBack(Boolean.valueOf(request.getParameter("isColorBack")));
            packageInformation.setMonthlyRent(Double.valueOf(request.getParameter("monthlyRent")));
            packageInformation.setUnit(request.getParameter("unit"));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                packageInformation.setMealStartDate(simpleDateFormat.parse(request.getParameter("mealStartDate")));
                packageInformation.setMealEndDate(simpleDateFormat.parse(request.getParameter("mealEndDate")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String string  = packageInformationService.updatePackageInformation(packageInformation);
            out.print(gson.toJson(string));
        }else if (type == 4){
            packageInformation.setId(Long.valueOf(request.getParameter("id")));
            packageInformation = packageInformationService.findPackageInformation(packageInformation);
            out.print(gson.toJson(packageInformation));
            out.close();
        }else if (type ==5){
            List<PackageInformation> packageInformationList = new ArrayList<PackageInformation>();
            packageInformationList = packageInformationService.findAllPackageInformation();
            out.print(gson.toJson(packageInformationList));
            out.close();
        }
    }
}
