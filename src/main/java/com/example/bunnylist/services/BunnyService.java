package com.example.bunnylist.services;

import com.example.bunnylist.entities.Bunny;
import com.example.bunnylist.repositories.BunnyRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BunnyService {
    private Logger logger = LoggerFactory.getLogger(BunnyService.class);

    @Autowired
    private static BunnyRepository bunnyRepo;
    private Bunny bunny;
    
    
    
    

}