package com.epam.training.sportsbetting.presentation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.epam.training.sportsbetting.core.domain")
@EnableJpaRepositories("com.epam.training.sportsbetting.core.repository")
@ComponentScan(basePackages = "com.epam.training.sportsbetting")
@PropertySource("classpath:ValidationMessages.properties")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

