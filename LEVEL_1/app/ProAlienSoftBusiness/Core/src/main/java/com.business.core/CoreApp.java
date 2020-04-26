package com.business.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CoreApp {

    public static void main(String[] args) {
        SpringApplication.run(CoreApp.class, args);
    }

}