package com.currency.exchange.config;

import com.currency.exchange.exception.errordecoder.ExchangeRateApiDecoder;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.codec.ErrorDecoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfigClient {
    @Value("${api.key}")
    private String apiKey;

    @Bean
    public RequestInterceptor authInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate requestTemplate) {
                requestTemplate.header("Authorization", "Bearer " + apiKey);
            }
        };
    }

    @Bean
    public ErrorDecoder feignErrorDecoder() {
        return new ExchangeRateApiDecoder();
    }
}
