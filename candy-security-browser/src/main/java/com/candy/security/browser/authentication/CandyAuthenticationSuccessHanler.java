package com.candy.security.browser.authentication;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("candyAuthenticationSuccessHanler")
public class CandyAuthenticationSuccessHanler implements AuthenticationSuccessHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ObjectMapper objectMapper;      // SpringBoot 在初始化的时候默认配置了一个 ObjectMapper

    @Override
    public void onAuthenticationSuccess(HttpServletRequest  request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
            // Authentication     用于处理成功的用户身份验证的策略。

            logger.info("登录成功");

            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(authentication));

    }
}
