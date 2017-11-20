package com.config;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.config
 * @author wangzhenxin
 * @date 2017-09-21 16:00
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import javax.servlet.*;
import java.io.IOException;

/**
 * @author wangzhenxin
 * @ClassName PageEncodingFilter
 * @Description 类描述
 * @date 2017-09-21
 */
public class PageEncodingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
