package com.candy.security.core.validate.code.sms;

import com.candy.security.core.validate.code.Impl.AbstractValidateCodeProcessor;
import com.candy.security.core.validate.code.ValidateCode;
import com.candy.security.core.validate.code.ValidateCodeProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author LiQB
 * @Title:
 * @ProjectName CandySecurity
 * @Description: 短信验证码处理器
 * @date 2018/8/25 16:30
 */
@Component("smsValidateCodeProcessor")
public class SmsCodeProcessor  extends AbstractValidateCodeProcessor<ValidateCode> {

    @Autowired
    private SmsCodeSender smsCodeSender;

    @Override
    protected void send(ServletWebRequest request, ValidateCode validateCode) throws Exception {
        String mobile = ServletRequestUtils.getRequiredStringParameter(request.getRequest(), "mobile");
        smsCodeSender.send(mobile, validateCode.getCode());
    }
}
