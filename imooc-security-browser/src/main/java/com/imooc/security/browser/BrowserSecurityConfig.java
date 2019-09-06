package com.imooc.security.browser;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * LN
 * 2019/9/6 0006 14:15
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {  //做web应用的适配器
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        //表单登录的配置
        httpSecurity.httpBasic()//代表httpBasic方式登录
//        httpSecurity.formLogin()  //代表表单方式登录
                .and()  //权限配置
                .authorizeRequests()//对请求做一个授权
                .anyRequest()//任何请求
                .authenticated();//都需要做身份认证

    }
}
