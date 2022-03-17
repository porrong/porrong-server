package com.syxxn.porrongserver.config;

import com.syxxn.porrongserver.feign.errordecoder.ErrorDecoderImpl;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

@EnableFeignClients(basePackages = "com.syxxn.porrongserver.feign")
@Import(ErrorDecoderImpl.class)
public class FeignClientConfig {
}
