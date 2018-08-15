package com.candy.security.browser;

import com.candy.security.browser.authentication.CandyAuthenticationFailureHanler;
import com.candy.security.browser.authentication.CandyAuthenticationSuccessHanler;
import com.candy.security.core.properties.SecurityProperties;
import com.candy.security.core.validate.code.ValidateCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author LiQB
 * @Title:
 * @ProjectName CandySecurity
 * @Description: TODO
 * @date 2018/8/2 13:35
 */

@Configuration
public class BrowerSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private CandyAuthenticationSuccessHanler candyAuthenticationSuccessHanler;

    @Autowired
    private CandyAuthenticationFailureHanler candyAuthenticationFailureHanler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
        validateCodeFilter.setAuthenticationFailureHandler(candyAuthenticationFailureHanler);

        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin()                // 定义当用户需要登录时跳转登录页面
                .loginPage("/authentication/require")
                .loginProcessingUrl("/authentication/form")
                .successHandler(candyAuthenticationSuccessHanler)
                .failureHandler(candyAuthenticationFailureHanler)
                .and()
                .authorizeRequests()    // 定义哪些URL需要被保护、哪些不需要被保护
                .antMatchers("/authentication/require",
                        securityProperties.getBrowser().getLoginPage(), "/code/image").permitAll()
                // antMatchers里配置的资源是可以被所有用户访问（permitAll）的
                .anyRequest()           // 任何请求,登录后可以访问
                .authenticated()
                .and().
                csrf().disable();
    }

}
