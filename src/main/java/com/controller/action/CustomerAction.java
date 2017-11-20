package com.controller.action;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.controller.action
 * @author wangzhenxin
 * @date 2017-09-30 9:23
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.base.BaseAction;
import com.domain.Customer;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.service.CustomerService;
import com.service.CustomerServiceImpl;
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
import java.util.List;

/**
 * @author wangzhenxin
 * @ClassName CustomerAction
 * @Description 客户Action
 * @date 2017-09-30
 */
@Action

@Results({
        @Result(name = "call", location = "/page/mobile_package/call.jsp"),
        @Result(name = "select", location = "/page/mobile_package/select.jsp")

})
public class CustomerAction extends BaseAction{
    private String customerId;

    @Resource
    private CustomerService customerService;

    private String id;
    /**
     * name 客户姓名
     */
    private String name; //NAME
    /*
    * phoneCode 电话号码
    */
    private String phoneCode; //PHONE_CODE
    /*
    * sex 性别
    */
    private String sex; //SEX
    /**
     * idCard 身份证号码
     */
    private String idCard; //ID_CARD
    /**
     * address 家庭住址
     */
    private String address; //ADDRESS
    /**
     * balance 余额
     */
    private String balance; //BALANCE
    /**
     * packageInfomation 套餐信息id
     */
//    private PackageInformation packageInformation; //PACKAGE_INFOMATION_ID
    /**
    * isShutdown 是否停机 true-是,false-否
    */
    private String isShutdown; //IS_SHUTDOWN

    /**

     * isStopArrears 是否欠费 true-是,false-否
     */
    private String isStopArrears; //IS_STOP_ARREARS
    /**
     * starStates 客户星级 1-1星级,2-2星级,3-3星级,4-4星级,5-5星级
     */
    private String starStates;


    public void saveCustomer() throws IOException,ServletException{
        //定义客户对象
        Customer customer = new Customer();
        //设置响应头
        response.setContentType("text/html;charset=UTF-8");
        //设置
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //接收姓名
        customer.setName(name);
        //接收性别
        customer.setSex(sex);
        //接收电话
        customer.setPhoneCode(phoneCode);
        //接收身份证
        customer.setIdCard(idCard);
        //接收地址
        customer.setAddress(address);
        //接收余额
        customer.setBalance(Double.parseDouble(balance));
        //根据余额判断是否停机
        if (customer.getBalance() <= 0){
            customer.setIsShutdown(true);
            customer.setIsStopArrears(true);
        }else {
            customer.setIsShutdown(false);
            customer.setIsStopArrears(false);
        }
        //设置用户星级
        customer.setStarStates((byte)5);
        //调用用户服务
//        CustomerService customerService = new CustomerServiceImpl();
        //接收返回值
        String print = customerService.saveCustomer(customer);

        response.sendRedirect("/zyhtweb/page/mobile_package/select.jsp");
    }
    public void deleteCustomer() throws IOException,ServletException{
        //定义客户对象
        Customer customer = new Customer();
        //设置
        request.setCharacterEncoding("utf-8");
        //设置响应头
        response.setContentType("text/html;charset=UTF-8");
        //设置对象ID
        customer.setId(Long.valueOf(id));

        //接收返回值
        String print = customerService.deleteCustomer(customer);
        Gson gson = new Gson();
        PrintWriter out = response.getWriter();
        out.print(gson.toJson(print));
        out.close();
    }
    public String updateCustomer() throws IOException,ServletException{
        //定义客户对象
        Customer customer = new Customer();
        //设置
        request.setCharacterEncoding("utf-8");
        //设置响应头
        response.setContentType("text/html;charset=UTF-8");
        //设置对象ID
        customer.setId(Long.valueOf(id));
        //接收姓名
        customer.setName(name);
        //接收性别
        customer.setSex(sex);
        //接收电话
        customer.setPhoneCode(phoneCode);
        //接收身份证
        customer.setIdCard(idCard);
        //接收地址
        customer.setAddress(address);
        //接收余额
        customer.setBalance(Double.parseDouble(balance));
        //根据余额判断是否停机
        if (customer.getBalance() <= 0){
            customer.setIsShutdown(true);
            customer.setIsStopArrears(true);
        }else {
            customer.setIsShutdown(false);
            customer.setIsStopArrears(false);
        }
        //设置用户星级
        customer.setStarStates((byte)5);

        //接收返回值
        String print = customerService.updateCustomer(customer);

        return "select";
    }
    public void findCustomer() throws IOException,ServletException{
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        Customer customer = new Customer();
        customer.setId(Long.valueOf(id));

        customer = customerService.selectCustomer(customer);
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        out.print(gson.toJson(customer));
        out.close();
    }
    public String call(){

        List<Customer> customerList = customerService.selectAllCustomer();
        request.setAttribute("customerList",customerList);
        return "call";
    }
    public String changeLanguage(){
        return "select";
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getIsShutdown() {
        return isShutdown;
    }

    public void setIsShutdown(String isShutdown) {
        this.isShutdown = isShutdown;
    }

    public String getIsStopArrears() {
        return isStopArrears;
    }

    public void setIsStopArrears(String isStopArrears) {
        this.isStopArrears = isStopArrears;
    }

    public String getStarStates() {
        return starStates;
    }

    public void setStarStates(String starStates) {
        this.starStates = starStates;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

}
