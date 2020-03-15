package com.example.filedemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FileDemoApplication {

    @Value("${file.upload-dir}")
    private String fileUploadPath;

    public static void main(String[] args) {
        SpringApplication.run(FileDemoApplication.class, args);
    }

}
