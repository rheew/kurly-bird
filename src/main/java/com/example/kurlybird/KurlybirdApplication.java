package com.example.kurlybird;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KurlybirdApplication {

    public static void main(String[] args) {
        SpringApplication.run(KurlybirdApplication.class, args);
    }

}
