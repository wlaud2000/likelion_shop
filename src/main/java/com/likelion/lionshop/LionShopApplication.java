package com.likelion.lionshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class LionShopApplication { //0주차 과제

    public static void main(String[] args) {
        SpringApplication.run(LionShopApplication.class, args);
    }

}
