package com.wyzg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author raintrees
 * @date 2019/11/18 21:54
 */
@SpringBootApplication
@EnableEurekaServer
public class WyzgRegistry {
    public static void main(String[] args) {
        SpringApplication.run(WyzgRegistry.class,args);
    }
}
