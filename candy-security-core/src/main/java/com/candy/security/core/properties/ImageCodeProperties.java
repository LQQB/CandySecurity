package com.candy.security.core.properties;

/**
 * @author lqqqq
 * @Title:
 * @ProjectName CandySecurity
 * @Description: TODO
 * @date 2018/8/2114:28
 */
public class ImageCodeProperties extends SmsCodeProperties {

    public ImageCodeProperties() {
        setLength(4);
    }

    private int width = 64;
    private int height = 28;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
