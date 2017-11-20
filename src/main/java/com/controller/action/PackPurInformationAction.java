package com.controller.action;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.controller.action
 * @author wangzhenxin
 * @date 2017-09-30 9:01
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.base.BaseAction;
import com.domain.Customer;
import com.domain.PackPurInformation;
import com.domain.PackageInformation;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.service.*;
import com.vo.PackPurInformationVo;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author wangzhenxin
 * @ClassName PackPurInformationAction
 * @Description 套餐购买Action
 * @date 2017-09-30
 */
@Action

@Results({
        @Result(name = "jstlselect",location = "/page/mobile_package/jstlselect.jsp")
})
public class PackPurInformationAction extends BaseAction {
    private String customerId;
    private String packageInformationId;

    @Resource
    private PackPurInformationService packPurInformationService;

    @Resource
    private CustomerService customerService;

    @Resource
    private PackageInformationService packageInformationService;


    /**
     * @Title: savePackPurInformation
     * @Description: 添加套餐购买记录Action
     * @author wangzhenxin
     * @date 2017-09-30
     */

    public void savePackPurInformation() throws IOException,ServletException{
        PackPurInformation packPurInformation = new PackPurInformation();

        Gson gson = new Gson();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        Customer customer = new Customer();
        customer.setId(Long.parseLong(customerId));

        customer = customerService.selectCustomer(customer);
        PackageInformation packageInformation= new PackageInformation();
        packageInformation.setId(Long.parseLong(packageInformationId));

        packageInformation = packageInformationService.findPackageInformation(packageInformation);
        packPurInformation.setBuyTime(new Date());
        packPurInformation.setCustomer(customer);
        packPurInformation.setPackageInformation(packageInformation);
        if (customer.getBalance().doubleValue() >= packageInformation.getMonthlyRent().doubleValue()){
            packPurInformation.setAmountOfPayment(packageInformation.getMonthlyRent());
            packPurInformation.setIsSuccess(true);
            packPurInformation.setEffectTime(new Date());
            packPurInformationService.savePackPurInformation(packPurInformation);
            customer.setBalance(customer.getBalance().doubleValue()-packageInformation.getMonthlyRent().doubleValue());
            customerService.updateCustomer(customer);
            out.print(gson.toJson(packPurInformation));
            out.close();
        }else {
            packPurInformation.setAmountOfPayment(0d);
            packPurInformation.setIsSuccess(false);
            packPurInformation.setEffectTime(null);
            packPurInformationService.savePackPurInformation(packPurInformation);
            out.print(gson.toJson(packPurInformation));
            out.close();
        }
    }

    /**
     * @Title: findAllPackPurInformation
     * @Description: 查找所有套餐记录Action
     * @author wangzhenxin
     * @date 2017-09-30
     */

    public String findAllPackPurInformation(){
        PackPurInformation packPurInformation = new PackPurInformation();
        List<PackPurInformationVo> packPurInformationVoList = new ArrayList<PackPurInformationVo>();
        packPurInformationVoList = packPurInformationService.findPackPurInformation(Long.parseLong(customerId));
        request.setAttribute("packPurInformationVoList",packPurInformationVoList);
        return "jstlselect";
//        request.getRequestDispatcher("/page/mobile_package/jstlselect.jsp").forward(request,response);
    }


    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPackageInformationId() {
        return packageInformationId;
    }

    public void setPackageInformationId(String packageInformationId) {
        this.packageInformationId = packageInformationId;
    }
}
