package com.wx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class BusRabbitMQ3344 {
    public static void main(String[] args) {
        SpringApplication.run(BusRabbitMQ3344.class,args);
    }
}
