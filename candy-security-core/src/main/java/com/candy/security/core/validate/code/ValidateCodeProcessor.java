package com.candy.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author LiQB
 * @Title:
 * @ProjectName CandySecurity
 * @Description: 校验处理器，封装不同校验码的处理逻辑
 * @date 2018/8/2115:45
 */
public interface ValidateCodeProcessor {


    /**
     * 验证码放入session时的前缀
     */
    String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE";

    /**
     * 创建校验码
     *
     * @param request
     * @throws Exception
     */
    void create(ServletWebRequest request) throws Exception;

    /**
     * 校验验证码
     *
     * @param request
     * @throws Exception
     */
    void validate(ServletWebRequest request) ;
}
