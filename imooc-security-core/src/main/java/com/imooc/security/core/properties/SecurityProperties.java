package com.imooc.security.core.properties;

import com.imooc.security.core.validate.code.ValidateCodeFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 配置读取器
 * 包含了各个模块的配置对象
 * LN
 * 2019/9/19 0019 16:19
 */

@ConfigurationProperties(prefix = "imooc.security")
public class SecurityProperties {
    /*
    默认情况下获取配置是prefix.类实例名.变量名，
    这里的实例对象名应该和配置文件中的一样
     */
    private BrowserProperties browser = new BrowserProperties();

    private ValidateCodeProperties code = new ValidateCodeProperties();

    public ValidateCodeProperties getCode() {
        return code;
    }

    public void setCode(ValidateCodeProperties code) {
        this.code = code;
    }

    public BrowserProperties getBrowserProperties() {
        return browser;
    }

    public void setBrowserProperties(BrowserProperties browser) {
        this.browser = browser;
    }
}
