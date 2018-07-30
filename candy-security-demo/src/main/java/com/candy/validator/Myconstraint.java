package com.candy.validator;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author Liqb
 * @Title:
 * @ProjectName CandySecurity
 * @Description: TODO
 * @date 2018/7/29 17:30
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=MyConstraintValidator.class)
public @interface Myconstraint {
    String message() default "{这是一个测试注解}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
