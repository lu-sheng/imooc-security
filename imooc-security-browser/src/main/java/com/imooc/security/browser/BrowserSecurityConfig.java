package com.imooc.security.browser;

import com.imooc.security.browser.authentication.ImoocAuthenticationSuccessHandler;
import com.imooc.security.core.properties.SecurityProperties;
import com.imooc.security.core.validate.code.ValidateCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * LN
 * 2019/9/6 0006 14:15
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {  //做web应用的适配器

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private AuthenticationSuccessHandler imoocAuthenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler imoocAuthenticationFailureHandler;

    //密码加密方法
    //PasswordEncoder是个接口，可以自定义类实现这个接口，
    // 来实现我们自己的加密逻辑
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
        validateCodeFilter.setAuthenticationFailureHandler(imoocAuthenticationFailureHandler);
        //表单登录的配置
//        httpSecurity.httpBasic()//代表httpBasic方式登录
        httpSecurity.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin()  //代表表单方式登录
                .loginPage("/authentication/require")//跳转到这个服务或者页面
                .loginProcessingUrl("/authentication/form")//接受发送过来的表单请求地址
                .successHandler(imoocAuthenticationSuccessHandler)//登录成功后，用我们自己的成功处理器进行处理
                .failureHandler(imoocAuthenticationFailureHandler)
                .and()  //权限配置
                .authorizeRequests()//对请求做一个授权
                .antMatchers("/authentication/require",
                        securityProperties.getBrowserProperties().getLoginPage(),
                        "/code/image").permitAll() //设置登录页不需要授权认证
                .anyRequest()//任何请求
                .authenticated()//都需要做身份认证
                .and()
                .csrf().disable();//关闭csrf跨域请求
    }
}
