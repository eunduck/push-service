package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PushServiceApplication {

    public static void main(String[] args) {
        System.out.println("ready");
        SpringApplication.run(PushServiceApplication.class, args);
        System.out.println("start");
    }

}
