package com.imooc.security.core.validate.code;

import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * LN
 * 2019/9/26 0026 20:54
 */
@RestController
public class ValidateCodeController {

    private static final String SESSION_KEY = "SESSION_KEY_IMAGE_CODE";
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
    private RandomValidateCodeUtil randomValidateCodeUtil = new RandomValidateCodeUtil();

    @GetMapping("/code/image")
    public void createCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ImageCode imageCode = createImageCode(request);
        //将验证码信息存放到session中
        sessionStrategy.setAttribute(new ServletWebRequest(request), SESSION_KEY, imageCode);

        ImageIO.write(imageCode.getImage(), "JPEG", response.getOutputStream());

    }

    private ImageCode createImageCode(HttpServletRequest request) {
        BufferedImage image = randomValidateCodeUtil.getRandCode();

        return null;
    }


}
