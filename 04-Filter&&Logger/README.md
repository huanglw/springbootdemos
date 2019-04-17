# 修改文件

- filter/CrossDomainFilter.java
- DemoApplication.java增加@ServletComponentScan注解
- application.properties设置`logging.file`地址`F:/Lewin/log4j/demo.log`

# 让Filter生效的步骤

## 设置一个filter

```java
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

```

设置完了之后是不会生效的，需要再项目的运行入口文件xxxxApplication.java文件里面设置`@ServletComponentScan("com.example.demo.filter")`

## 设置完了之后

如预期，日志打印出当前过滤的请求

请求：localhost:8080/thymeleaf/a的时候打印日志

`2019-04-17 12:44:50.652  INFO 19312 --- [http-nio-8080-exec-1] c.example.demo.filter.CrossDomainFilter  : 过滤到请求--->/thymeleaf/a`



