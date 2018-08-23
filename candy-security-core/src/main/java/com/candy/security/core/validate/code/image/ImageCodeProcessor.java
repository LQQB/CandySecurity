package com.candy.security.core.validate.code.image;

import com.candy.security.core.validate.code.Impl.AbstractValidateCodeProcessor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;

/**
 * @author LiQB
 * @Title:
 * @ProjectName CandySecurity
 * @Description: 图形验证码处理器
 * @date 2018/8/21 16:30
 */
@Component("imageValidateCodeProcessor")
public class ImageCodeProcessor extends AbstractValidateCodeProcessor<ImageCode> {

    /**
     * 发送图形验证码，将其写到响应中
     */
    @Override
    protected void send(ServletWebRequest request, ImageCode validateCode) throws Exception {
        ImageIO.write(validateCode.getImage(), "jpg", request.getResponse().getOutputStream());
    }
}
