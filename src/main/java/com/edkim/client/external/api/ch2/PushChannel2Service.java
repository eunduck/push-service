package com.edkim.client.external.api.ch2;

import com.edkim.client.external.api.AbstractPushService;
import com.edkim.client.external.model.response.PushResponse;
import org.springframework.stereotype.Component;


@Component(value = "PUSH-B")
public class PushChannel2Service extends AbstractPushService {
    @Override
    public PushResponse send() {
        System.out.println("send2");
        return null;
    }
}
