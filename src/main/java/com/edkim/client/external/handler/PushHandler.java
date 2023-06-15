package com.edkim.client.external.handler;

import com.edkim.client.external.model.response.PushResponse;

public interface PushHandler {
    PushResponse send();

    void save();
}
