package com.candy.web.filter;


import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * @author LiQB
 * @Title:
 * @ProjectName CandySecurity
 * @Description: TODO
 * @date 2018/7/31 11:05
 */
//@Component   // spring注解中@component就是说把这个类交给Spring管理
public class TimeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Time Filter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("time filter start");
        long start = new Date().getTime();
        chain.doFilter(request, response);
        System.out.println("time filter 耗时："+ (new Date().getTime() - start) );
        System.out.println("time filter finish");
    }

    @Override
    public void destroy() {
        System.out.println("Time Filter destroy");
    }
}
