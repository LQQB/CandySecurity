package com.candy.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author Liqb
 * @Title:
 * @ProjectName CandySecurity
 * @Description: TODO
 * @date 2018/7/31 16:04
 */
@Component
public class TimeInterceptor implements HandlerInterceptor {

    /**
     * 控制器方法处理之前
     * @param httpServletRequest
     * @param httpServletResponse
     * @param handle
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handle) throws Exception {
        System.out.println("preHandle");
        System.out.println(( (HandlerMethod) handle).getBean().getClass().getName() );
        System.out.println(( (HandlerMethod) handle).getMethod().getName() );
        httpServletRequest.setAttribute("startTime", new Date().getTime());
        return true;
    }

    /**
     * 控制器处理方法之后
     * 控制器方法调用 不抛异常 调用
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
        Long startTime = (Long) httpServletRequest.getAttribute("startTime");
        System.out.println("time interceptor 耗时" + (new Date().getTime() - startTime));
    }

    /**
     * 控制器处理方法之后
     * 控制器方法 抛不抛异常 都会被调用
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("afterCompletion");
        Long startTime = (Long) httpServletRequest.getAttribute("startTime");
        System.out.println("time interceptor 耗时" + (new Date().getTime() - startTime));
        System.out.println("ex is" + e);
    }
}
