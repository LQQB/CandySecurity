package com.candy.security.core.properties;

import org.springframework.boot.autoconfigure.session.SessionProperties;

/**
 *
 * 浏览器环境配置
 * @author LiQB
 * @Title:
 * @ProjectName CandySecurity
 * @Description: TODO
 * @date 2018/8/1315:32
 */
public class BrowserProperties {

    /**
     *  session 管理配置项
     */
//    private SessionProperties sessionProperties = new SessionProperties();

    private String loginPage = "/candy-signIn.html";

    private LoginType loginType = LoginType.JSON;

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }
}
