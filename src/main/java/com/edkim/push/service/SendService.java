package com.edkim.push.service;

import com.edkim.client.external.handler.PushFactory;
import com.edkim.client.external.handler.PushHandler;
import com.edkim.core.code.PushChannel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class SendService {
    private final PushFactory beanFactory;
    public void test() {
        PushHandler handler = null;
        try {
            handler = beanFactory.getChannel(PushChannel.A.name());
            handler.send();
            handler =  beanFactory.getChannel(PushChannel.B.name());
            handler.send();
            handler =  beanFactory.getChannel(PushChannel.C.name());
            handler.send();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
