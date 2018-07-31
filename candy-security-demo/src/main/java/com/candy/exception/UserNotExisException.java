package com.candy.exception;

/**
 * @author LiQB
 * @Title:
 * @ProjectName CandySecurity
 * @Description: TODO
 * @date 2018/7/31 9:33
 */
public class UserNotExisException extends RuntimeException{


    private String id;

    public UserNotExisException(String id) {
        super("user not exits");
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
