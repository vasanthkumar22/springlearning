package com.example.jpamanytoone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JpaManytoOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaManytoOneApplication.class, args);
    }

}
