package com.syxxn.porrongserver.config;

import com.syxxn.porrongserver.property.JwtProperties;
import com.syxxn.porrongserver.property.KakaoOAuthProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties(value = {JwtProperties.class, KakaoOAuthProperties.class})
@Configuration
public class ConfigurationPropertiesConfig {
}
