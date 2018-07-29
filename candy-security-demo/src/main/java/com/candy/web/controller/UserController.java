package com.candy.web.controller;

import com.candy.dto.User;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Liqb
 * @Title:
 * @ProjectName CandySecurity
 * @Description: TODO
 * @date 2018/7/27 11:44
 */
@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping     // @GetMapping 是属于RequestMapping 的一种变形,或者说是一种子类注解,只支持Get类型的请求
    @JsonView(User.UserSimpleView.class)
    public List<User> getQuertList(@RequestParam (defaultValue = "JOJO")String username) {             // @RequestParam 参数绑定的一种,常用来处理简单类型的绑定
        List<User> users = new ArrayList<>();
        System.out.println(username);
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    @GetMapping("/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getUserInfo(@PathVariable String id) {
        User user = new User();
        user.setUsername("tom");
        return user;
    }


    @PostMapping
    public User createUserInfo(@Valid  @RequestBody User user, BindingResult errors) {

        if(errors.hasErrors()) {
          errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
        }

        System.out.println(user.getId());
        System.out.println(user.getPassword());
        System.out.println(user.getUsername());
        System.out.println(user.getBirthday());

        user.setId(1);
        return user;
    }

    @PutMapping("/{id:\\d+}")
    public User update(@Valid @RequestBody User user,  BindingResult errors) {
        if(errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error -> {
                FieldError fieldError = (FieldError)  error;
                String message = fieldError.getField() +"   "+ error.getDefaultMessage();
                System.out.println(message);});
        }
        System.out.println(user.getId());
        System.out.println(user.getPassword());
        System.out.println(user.getUsername());
        System.out.println(user.getBirthday());
        return user;
    }

}
