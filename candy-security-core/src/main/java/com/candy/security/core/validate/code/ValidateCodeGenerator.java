package com.candy.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;


/**
 * @author LiQB
 * @Title:
 * @ProjectName CandySecurity
 * @Description: 校验生成器
 * @date 2018/8/21 15:15
 */
public interface ValidateCodeGenerator {

    ValidateCode generator(ServletWebRequest request);

}
