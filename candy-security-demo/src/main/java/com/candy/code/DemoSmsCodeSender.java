package com.candy.code;

import com.candy.security.core.validate.code.sms.SmsCodeSender;
import org.springframework.stereotype.Component;

//@Component("smsCodeSender")
public class DemoSmsCodeSender implements SmsCodeSender {

    @Override
    public void send(String mobile, String code) {
        System.out.println("--------------------");
    }
}
