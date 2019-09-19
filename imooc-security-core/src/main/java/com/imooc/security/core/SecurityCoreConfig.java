package com.imooc.security.core;

import com.imooc.security.core.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * LN
 * 2019/9/19 0019 16:25
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class) //让使用 @ConfigurationProperties 注解的类生效。
public class SecurityCoreConfig {

}
