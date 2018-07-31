package com.candy.web.controller;

import com.candy.exception.UserNotExisException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiQB
 * @Title:
 * @ProjectName CandySecurity
 * @Description: @ControllerAdvice + @ExceptionHandler 实现全局的 Controller 层的异常处理
 * @date 2018/7/31 10:11
 */
@ControllerAdvice   //  定义全局异常处理类
public class ControllerExceptionHandler {

    @ExceptionHandler(UserNotExisException.class)   // 声明异常处理方法
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handleUserNotExistException(UserNotExisException ex) {
        Map<String, Object> result = new HashMap<>();
        result.put("id", ex.getId());
        result.put("message", ex.getMessage());
//        result.put("cause", ex.getStackTrace());
        return result;
    }

}
