package com.business.core.App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan({"com.business"})
@EnableScheduling
@EntityScan(basePackages = {"com.business.businessobjects"})
@EnableJpaRepositories(basePackages = {"com.business.businessobjects"})
public class CoreApp {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(CoreApp.class);
        ConfigurableApplicationContext configurableApplicationContext = springApplication.run(args);
    }

}