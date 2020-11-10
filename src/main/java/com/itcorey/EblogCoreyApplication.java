package com.itcorey;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.itcorey.mapper")
public class EblogCoreyApplication {

    public static void main(String[] args) {
        SpringApplication.run(EblogCoreyApplication.class, args);
    }

}
