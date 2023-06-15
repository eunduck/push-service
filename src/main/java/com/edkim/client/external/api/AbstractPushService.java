package com.edkim.client.external.api;

import com.edkim.client.external.handler.PushHandler;

public abstract class AbstractPushService implements PushHandler {
    @Override
    public void save() {
        System.out.println("abstract");
    }
}
