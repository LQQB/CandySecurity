package com.security.browser.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author LiQB
 * @Title:
 * @ProjectName CandySecurity
 * @Description: TODO
 * @date 2018/8/2 13:35
 */

@Configuration
public class BrowerSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()                // 定义当用户需要登录时跳转登录页面
                .and()
                .authorizeRequests()    // 定义哪些URL需要被保护、哪些不需要被保护
                .anyRequest()           // 任何请求,登录后可以访问
                .authenticated();
    }

}
