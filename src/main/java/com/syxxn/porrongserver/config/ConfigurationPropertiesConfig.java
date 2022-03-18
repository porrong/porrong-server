package com.syxxn.porrongserver.config;

import com.syxxn.porrongserver.property.JwtProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties(value = {JwtProperties.class})
@Configuration
public class ConfigurationPropertiesConfig {
}
