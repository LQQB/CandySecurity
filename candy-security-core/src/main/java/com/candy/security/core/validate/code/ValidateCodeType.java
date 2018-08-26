package com.candy.security.core.validate.code;

import com.candy.security.core.properties.SecurityConstants;

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
            return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_SMS;
        }
    },
    /**
     * 图片验证码
     */
    IMAGE {
        @Override
        public String getParamNameOnValidate() {
            return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_IMAGE;
        }
    };

    public abstract String getParamNameOnValidate();
}
