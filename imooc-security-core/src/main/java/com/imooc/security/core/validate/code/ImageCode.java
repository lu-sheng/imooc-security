package com.imooc.security.core.validate.code;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * LN
 * 2019/9/26 0026 20:30
 */
public class ImageCode {
    private BufferedImage image;
    private String code;
    //过期时间点
    private LocalDateTime expiredTime;
    //过期时间，比如60s过期
    public ImageCode(BufferedImage image, String code, int expiredIn) {
        this.image = image;
        this.code = code;
        this.expiredTime = LocalDateTime.now().plusSeconds(expiredIn);
    }
    public boolean isExpried() {
        return LocalDateTime.now().isAfter(expiredTime);
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(LocalDateTime expiredTime) {
        this.expiredTime = expiredTime;
    }
}
