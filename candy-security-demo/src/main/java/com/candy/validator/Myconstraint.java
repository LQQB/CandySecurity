package com.candy.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Liqb
 * @Title:
 * @ProjectName CandySecurity
 * @Description: TODO
 * @date 2018/7/29 17:30
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Myconstraint {
}
