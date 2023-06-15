package com.edkim.client.external.api.ch1;

import com.edkim.client.external.api.AbstractPushService;
import com.edkim.client.external.model.response.PushResponse;
import org.springframework.stereotype.Component;

@Component(value = "PUSH-A")
public class PushChannel1Service extends AbstractPushService {
    @Override
    public PushResponse send() {
        System.out.println("send1");
        return null;
    }
}
