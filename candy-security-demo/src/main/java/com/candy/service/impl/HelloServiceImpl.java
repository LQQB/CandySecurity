package com.candy.service.impl;

import com.candy.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @author lqqqq
 * @Title:
 * @ProjectName CandySecurity
 * @Description: TODO
 * @date 2018/7/3 09:47
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public void greeting(String name) {
        System.out.println(name);
    }
}
