package com.edkim.push.controller;

import com.edkim.push.service.SendService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class SendController {

    private final SendService service;
    @GetMapping("test")
    public String test() {
        service.test();
        return "Test";
    }
}
