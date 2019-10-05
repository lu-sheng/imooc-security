package com.imooc.security.core.properties;

/**
 * 对应着配置文件中关于browser的配置
 * LN
 * 2019/9/19 0019 16:18
 */

public class BrowserProperties {
    //默认值，如果用户在配置文件中配了值就用配置文件中的值，如果没有就用下面的默认值
    private String loginPage = "/imooc-signIn.html";

    private LoginType loginType = LoginType.JSON;

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }
}
