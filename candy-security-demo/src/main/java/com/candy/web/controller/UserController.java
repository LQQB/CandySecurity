package com.candy.web.controller;

import com.candy.dto.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping
    public List<User> getQuertList() {
        List<User> users = new ArrayList<>();

        users.add(new User());
        users.add(new User());
        users.add(new User());

        return users;
    }

}
