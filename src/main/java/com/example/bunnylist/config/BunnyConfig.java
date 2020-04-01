package com.example.bunnylist.config;

import com.example.bunnylist.entities.Bunny;
import com.example.bunnylist.entities.Carrot;
import com.example.bunnylist.services.BunnyService;
import com.example.bunnylist.services.CarrotService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BunnyConfig {
    private Logger logger = LoggerFactory.getLogger(BunnyConfig.class);

    @Bean
    public Bunny bunny() {
        logger.info("new Bunny created");
        return new Bunny();
    }

    @Bean
    public BunnyService bunnyService() {
        logger.info("new BunnyService created");
        return new BunnyService();
    }

    @Bean
    public Carrot carrot() {
        logger.info("new Carrot created");
        return new Carrot();
    }

    @Bean
    public CarrotService carrotService() {
        logger.info("New CarrotService created");
        return new CarrotService();
    }


}