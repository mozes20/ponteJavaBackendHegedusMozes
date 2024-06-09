package com.example.pontejavabackendtask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableSwagger2
@EnableWebMvc
public class PonteJavaBackendTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(PonteJavaBackendTaskApplication.class, args);
    }

}
