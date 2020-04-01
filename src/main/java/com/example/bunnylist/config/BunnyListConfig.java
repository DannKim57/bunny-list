package com.example.bunnylist.config;

import com.example.bunnylist.services.BunnyService;
import com.example.bunnylist.services.CarrotService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("com.example.bunnylist")
@Configuration
public class BunnyListConfig {
    // private Logger logger = LoggerFactory.getLogger(BunnyListConfig.class);


    // @Bean
    // public Bunny bunny(String id, String name) {
    //     logger.info("new Bunny created");
    //     return new Bunny(id, name);
    // }


    @Bean
    public BunnyService bunnyService() {
        return new BunnyService();
    }


    @Bean
    public CarrotService carrotService() {
        return new CarrotService();
    }


}