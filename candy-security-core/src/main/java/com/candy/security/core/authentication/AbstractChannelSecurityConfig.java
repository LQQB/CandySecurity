package com.candy.security.core.authentication;

import com.candy.security.core.properties.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 *  密码登录相关配置
 */
public class AbstractChannelSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    protected AuthenticationSuccessHandler tihomAuthenticationSuccessHandler;

    @Autowired
    protected AuthenticationFailureHandler tihomAuthenticationFailureHandler;



    protected void applyPasswordAuthenticationConfig(HttpSecurity http) throws Exception {
        http.formLogin()        // 定义当用户需要登录时跳转登录页面
                .loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
                .loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
                .successHandler(tihomAuthenticationSuccessHandler)
                .failureHandler(tihomAuthenticationFailureHandler);
    }
}
