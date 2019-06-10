package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.config.BootstrapMode;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-05 17:05
 * 将hibernate在一个单独的线程中运行
 */
@EnableJpaRepositories(bootstrapMode = BootstrapMode.DEFERRED)
@EnableCaching
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
