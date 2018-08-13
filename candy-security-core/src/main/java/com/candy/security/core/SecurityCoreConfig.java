package com.candy.security.core;

import com.candy.security.core.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author LiQB
 * @Title:
 * @ProjectName CandySecurity
 * @Description:  获取 properties 配置
 * @date 2018/8/13 15:42
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {
}
