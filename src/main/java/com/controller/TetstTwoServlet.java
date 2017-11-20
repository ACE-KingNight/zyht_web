package com.controller;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.controller
 * @author wangzhenxin
 * @date 2017-09-20 11:40
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

/**
 * @author wangzhenxin
 * @ClassName TetstTwoServlet
 * @Description 类描述
 * @date 2017-09-20
 */
public class TetstTwoServlet extends HttpServlet{
    public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if ("张三".equals(username) && "123456".equals(password)){
            ServletContext context = getServletConfig().getServletContext();
            context.getRequestDispatcher("/page/work_09_20/success.jsp").forward(request,response);
        } else {
            ServletContext context = getServletConfig().getServletContext();
            context.getRequestDispatcher("/page/work_09_20/login.jsp").include(request,response);
        }
    }
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
//          this.doPost(request,response);
        String time = null;
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        time = (String)request.getAttribute("fromRequest");
        out.println("formrequest"+time);
        HttpSession httpSession = request.getSession();
        time = (String)httpSession.getAttribute("fromSession");
        out.println("fromSession:"+time);
        ServletContext context = getServletConfig().getServletContext();
        time = (String)context.getAttribute("fromContext");
        out.println("fromContext:"+time);
        response.getWriter().close();
    }
}
