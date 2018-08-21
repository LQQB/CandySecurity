package com.candy.security.core.validate.code;

import sun.security.util.SecurityConstants;

/**
 * @author LiQB
 * @Title:
 * @ProjectName CandySecurity
 * @Description:
 * @date 2018/8/21 16:15
 */
public enum  ValidateCodeType {

    /**
     * 短信验证码
     */
    SMS {
        @Override
        public String getParamNameOnValidate() {
            return "smsCode";
        }
    },
    /**
     * 图片验证码
     */
    IMAGE {
        @Override
        public String getParamNameOnValidate() {
            return "imageCode";
        }
    };

    public abstract String getParamNameOnValidate();
}
