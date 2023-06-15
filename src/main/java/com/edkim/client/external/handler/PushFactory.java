package com.edkim.client.external.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PushFactory {
    private final BeanFactory beanFactory;
    public PushHandler getChannel(String ch) throws Exception {
        try {
            return (PushHandler) beanFactory.getBean("PUSH-"+ch);
        } catch (NoSuchBeanDefinitionException e) {
            throw new Exception();
        }
    }
}
