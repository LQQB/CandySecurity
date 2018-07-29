package com.candy.dto;

import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Past;
import java.util.Date;

/**
 * @author lqqqq
 * @Title:
 * @ProjectName CandySecurity
 * @Description: TODO
 * @date 2018/7/2711:43
 */
public class User {

    public interface UserSimpleView{};

    public interface UserDetailView extends UserSimpleView{};

    private int id;

    private String username;

    @NotBlank(message = "检查约束字符串是不是Null还有被Trim的长度是否大于0,只对字符串,且会去掉前后空格.")
    private String password;

    @Past(message = "Date 和 Calendar 对象是否在当前时间之前")
    private Date birthday;

    @JsonView(UserSimpleView.class)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @JsonView(UserSimpleView.class)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonView(UserSimpleView.class)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonView(UserDetailView.class)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
