package com.controller;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.controller
 * @author wangzhenxin
 * @date 2017-09-24 13:48
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.domain.Customer;
import com.domain.PackPurInformation;
import com.domain.PackageInformation;
import com.google.gson.Gson;
import com.service.*;
import com.vo.PackPurInformationVo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author wangzhenxin
 * @ClassName PackPurInformationServlet
 * @Description PackPurInformationServlet
 * @date 2017-09-24
 */
public class PackPurInformationServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException{
        this.doPost(request,response);

    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)
        throws IOException,ServletException{
        Integer type = Integer.valueOf(request.getParameter("type"));
        PackPurInformation packPurInformation = new PackPurInformation();
        PackPurInformationService purInformationService = new PackPurInformationServiceImpl();
        Gson gson = new Gson();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        if (type == 1){
            Customer customer = new Customer();
            customer.setId(Long.parseLong(request.getParameter("customerId")));
            CustomerService customerService = new CustomerServiceImpl();
            customer = customerService.selectCustomer(customer);
            PackageInformation packageInformation= new PackageInformation();
            packageInformation.setId(Long.parseLong(request.getParameter("packageInformationId")));
            PackageInformationService packageInformationService = new PackageInformationServiceImpl();
            packageInformation = packageInformationService.findPackageInformation(packageInformation);
            packPurInformation.setBuyTime(new Date());
            packPurInformation.setCustomer(customer);
            packPurInformation.setPackageInformation(packageInformation);
            if (customer.getBalance().doubleValue() >= packageInformation.getMonthlyRent().doubleValue()){
                packPurInformation.setAmountOfPayment(packageInformation.getMonthlyRent());
                packPurInformation.setIsSuccess(true);
                packPurInformation.setEffectTime(new Date());
                purInformationService.savePackPurInformation(packPurInformation);
                customer.setBalance(customer.getBalance().doubleValue()-packageInformation.getMonthlyRent().doubleValue());
                customerService.updateCustomer(customer);
                out.print(gson.toJson(packPurInformation));
                out.close();
            }else {
                packPurInformation.setAmountOfPayment(0d);
                packPurInformation.setIsSuccess(false);
                packPurInformation.setEffectTime(null);
                purInformationService.savePackPurInformation(packPurInformation);
                out.print(gson.toJson(packPurInformation));
                out.close();
            }
        }else if (type == 2){

        }else if (type == 3){
            List<PackPurInformationVo> packPurInformationVoList = new ArrayList<PackPurInformationVo>();
            packPurInformationVoList = purInformationService.findPackPurInformation(Long.parseLong(request.getParameter("customerId")));
            request.setAttribute("packPurInformationVoList",packPurInformationVoList);
            request.getRequestDispatcher("/page/mobile_package/jstlselect.jsp").forward(request,response);
//            out.print(gson.toJson(packPurInformationVoList));
//            out.close();
        }
    }
}
