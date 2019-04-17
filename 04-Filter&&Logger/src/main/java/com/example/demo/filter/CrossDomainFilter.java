package com.example.demo.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * /*所有请求的过滤器，这里我用来解决跨域问题
 */
@WebFilter(filterName = "crossDomainFilter", urlPatterns = {"/*"})
public class CrossDomainFilter implements Filter {
    private static Logger logger = LoggerFactory.getLogger(CrossDomainFilter.class);


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        String requestURI = req.getRequestURI();
        logger.info("过滤到请求--->" + requestURI);

        // 指定允许其他域名访问
        res.setHeader("Access-Control-Allow-Origin", "*");
        // 响应类型
        res.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, OPTIONS, DELETE");
        // 响应头设置
        res.setHeader("Access-Control-Allow-Headers", "Content-Type, x-requested-with, X-Custom-Header, HaiYi-Access-Token");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy(){

    }
}
