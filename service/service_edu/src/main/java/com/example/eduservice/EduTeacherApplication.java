package com.example.eduservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


@SpringBootApplication
@ComponentScan(basePackages = {"com.example"})
@EnableDiscoveryClient
@EnableFeignClients
public class EduTeacherApplication {
    public static void main(String[] args){
        SpringApplication.run(EduTeacherApplication.class,args);
    }
}
