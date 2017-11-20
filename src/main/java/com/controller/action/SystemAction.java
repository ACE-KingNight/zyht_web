package com.controller.action;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.controller.action
 * @author wangzhenxin
 * @date 2017-09-28 14:41
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;

/**
 * @author wangzhenxin
 * @ClassName SystemAction
 * @Description 类描述
 * @date 2017-09-28
 */
@ParentPackage("basePackage")
@Namespace("/system")

@Action(value = "role")

@Results({
        @Result(name = "role_view", location = "/role_view.jsp")
})
/**
 * @ParentPackage("basePackage") 读取basePackage下的包用于区分命名空间
 * @Namespace("/")用于定义命名空间,及访问路径,默认的为包名
 * @Action("")用于定义Action的名字 默认为类名如 SystemTestAction则路径为system-test
 * @result(neme = "", location = "") 用于定义返回的页面路径
 */
@AllowedMethods({"findUser"})//2.5以上版本才有
public class SystemAction extends ActionSupport {
    public String findUser(){
        System.out.println("测试role_view");
        return "role_view";
    }
}
