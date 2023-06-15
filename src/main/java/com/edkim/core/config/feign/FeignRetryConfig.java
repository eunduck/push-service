package com.edkim.core.config.feign;

import feign.Retryer;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.TimeUnit;

public class FeignRetryConfig {
    @Bean
    public Retryer retryer() {
        //0.1초 간격으로 시작, 최대 3초의 간격으로 5번 시도
        return new Retryer.Default(100L, TimeUnit.SECONDS.toMillis(3L), 5);
    }
}
