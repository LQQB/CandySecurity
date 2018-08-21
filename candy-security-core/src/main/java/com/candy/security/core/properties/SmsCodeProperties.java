package com.candy.security.core.properties;

/**
 * @author LiQB
 * @Title:
 * @ProjectName CandySecurity
 * @Description: 校验配置类
 * @date 2018/8/21 14:23
 */
public class SmsCodeProperties {

    private int length = 6;
    private int expireIn = 60;

    private String url;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(int expireIn) {
        this.expireIn = expireIn;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
