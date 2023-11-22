package com.example.workexperienceservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class WorkexperienceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkexperienceServiceApplication.class, args);
    }

}
