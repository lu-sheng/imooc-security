package com.imooc.security.core.properties;

/**
 * LN
 * 2019/10/10 0010 18:52
 */
public class ValidateCodeProperties {
    private ImageCodeProperties image = new ImageCodeProperties();

    public ImageCodeProperties getImage() {
        return image;
    }

    public void setImage(ImageCodeProperties image) {
        this.image = image;
    }
}
