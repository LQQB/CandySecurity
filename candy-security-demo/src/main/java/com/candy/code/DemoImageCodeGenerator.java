package com.candy.code;

import com.candy.security.core.validate.code.ValidateCode;
import com.candy.security.core.validate.code.ValidateCodeGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author LiQB
 * @Title:
 * @ProjectName CandySecurity
 * @Description: TODO
 * @date 2018/8/2318:08
 */
//@Component("imageValidateCodeGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public ValidateCode generator(ServletWebRequest request) {
        logger.info("更高级的图形验证方法");
        return null;
    }
}
