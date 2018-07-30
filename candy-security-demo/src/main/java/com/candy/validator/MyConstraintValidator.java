package com.candy.validator;

import com.candy.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author LiQB
 * @Title:
 * @ProjectName CandySecurity
 * @Description: TODO
 * @date 2018/7/30 9:40
 */
public class MyConstraintValidator implements ConstraintValidator<Myconstraint, Object> {

    @Autowired
    private HelloService helloService;

    /**
     * 初始化
     */
    @Override
    public void initialize(Myconstraint myconstraint) {
        System.out.println("init Myconstraint");
    }

    /**
     * 校验逻辑
     * @param value
     * @param context
     * @return
     */
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        helloService.greeting("TOM");
        System.out.println(value);
        return false;
    }
}
