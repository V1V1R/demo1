package com.dongruan;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableTransactionManagement
@Slf4j
@EnableCaching
public class NepApplication {
    public static void main(String[] args) {
        SpringApplication.run(NepApplication.class, args);
        log.info("server started");
    }
}
