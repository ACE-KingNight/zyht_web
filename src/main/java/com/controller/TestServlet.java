package com.controller;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.controller
 * @author wangzhenxin
 * @date 2017-09-15 16:51
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import javax.servlet.ServletConfig;
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
 * @ClassName TestServlet
 * @Description 类描述
 * @date 2017-09-15
 */
public class TestServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
//        response.getWriter().println(request.getParameter("tech"));
//        response.getWriter().flush();
//        response.getWriter().println("");
        String time = ""+ new Date().getTime();
        request.setAttribute("fromRequest",time);
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("fromSession",time);
        ServletContext context = getServletConfig().getServletContext();
        context.setAttribute("fromContext",time);
        response.sendRedirect("/serlvet/testtwo.htm");
//        context.getRequestDispatcher("/serlvet/testtwo.htm").forward(request,response);
//        response.getWriter().close();
    }
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(super.getServletConfig().getInitParameter("name"));
        Enumeration<String> enumerations = super.getServletConfig().getInitParameterNames();
        while (enumerations.hasMoreElements()){
            out.println(enumerations.nextElement());
        }
        out.println("<h3>客户端IP:"+request.getRemoteAddr()+"</h3>");
        out.println("<h3>客户端端口号:"+request.getRemotePort()+"</h3>");
        out.println("<h3>服务器IP:"+request.getLocalAddr()+"</h3>");
        out.println("<h3>服务器端口号:"+request.getLocalPort()+"</h3>");
        Enumeration<String> enumeration = request.getHeaderNames();
        while (enumeration.hasMoreElements()){
            String name = enumeration.nextElement();
            out.println("<h3>属性名:"+name+"</h3>");
            String value = request.getHeader(name);
            out.println("<h3>属性值:"+value+"</h3>");
        }
        out.println(request.getParameter("languages"));
//        response.sendError(HttpServletResponse.SC_GATEWAY_TIMEOUT,"错误请求");
        out.close();
    }

}
