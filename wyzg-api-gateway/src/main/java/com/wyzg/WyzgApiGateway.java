package com.wyzg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author raintrees
 * @date 2019/11/18 21:50
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class WyzgApiGateway {
    public static void main(String[] args) {
        SpringApplication.run(WyzgApiGateway.class,args);
    }
}
