package com.itcorey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class EblogCoreyApplication {

    public static void main(String[] args) {
        SpringApplication.run(EblogCoreyApplication.class, args);
    }

}
