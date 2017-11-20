package com.controller.action;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.controller.action
 * @author wangzhenxin
 * @date 2017-09-28 15:39
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@Action

/**
 * @author wangzhenxin
 * @ClassName TestInternationalizationAction
 * @Description 类描述
 * @date 2017-09-28
 */
@Results({
        @Result(name = "testInternationalization", location = "/testinternationalization.jsp")
})
public class TestInternationalizationAction extends ActionSupport {
    public String message(){
        return "testInternationalization";
    }
}
