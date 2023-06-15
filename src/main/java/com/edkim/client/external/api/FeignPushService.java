package com.edkim.client.external.api;

import com.edkim.core.config.feign.FeignClientConfig;
import com.edkim.core.config.feign.FeignRetryConfig;
import com.edkim.core.config.feign.external.FeignExternalConfiguration;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "feign-external", url = "NOT_USED", configuration = {FeignClientConfig.class, FeignRetryConfig.class, FeignExternalConfiguration.class})
public interface FeignPushService {
}
