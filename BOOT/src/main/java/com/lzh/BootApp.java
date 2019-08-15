package com.lzh;


import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.RequestContextListener;

import javax.sql.DataSource;

@SpringBootApplication
@EnableCircuitBreaker
@MapperScan(basePackages = {"com.lzh.dao"})
public class BootApp {

    public static void main(String[] args) {
        SpringApplication.run(BootApp.class);
    }

    @Bean
    public RequestContextListener requestContextListener(){
        return new RequestContextListener();
    }


}
