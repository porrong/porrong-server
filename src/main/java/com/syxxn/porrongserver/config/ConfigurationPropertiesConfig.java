package com.syxxn.porrongserver.config;

import com.syxxn.porrongserver.property.JwtProperties;
import com.syxxn.porrongserver.property.KakaoOAuthProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

//@ConfigurationPropertiesScan("com.syxxn.porrongserver") //base package 적어주면 될 듯 //프로퍼티 파일이 많은 경우엔 이 방법 사용
@EnableConfigurationProperties(value = {JwtProperties.class, KakaoOAuthProperties.class})
@Configuration
public class ConfigurationPropertiesConfig {
}
