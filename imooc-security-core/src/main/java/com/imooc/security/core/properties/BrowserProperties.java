package com.imooc.security.core.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 对应着配置文件中关于browser的配置
 * LN
 * 2019/9/19 0019 16:18
 */
@Component
public class BrowserProperties {
    //默认值，如果用户在配置文件中配了值就用配置文件中的值，如果没有就用下面的默认值
    private String loginPage = "/imooc-signIn.html";

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }
}
