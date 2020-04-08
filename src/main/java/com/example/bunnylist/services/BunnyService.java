package com.example.bunnylist.services;

import java.util.ArrayList;
import java.util.List;

import com.example.bunnylist.entities.Bunny;
import com.example.bunnylist.repositories.BunnyRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BunnyService {
    private Logger logger = LoggerFactory.getLogger(BunnyService.class);
    @Autowired
    private BunnyRepository bunnyRepository;

    public List<Bunny> getAllBunnies() {
        List<Bunny> bunnies = new ArrayList<>();
        bunnyRepository.findAll().forEach((t) -> bunnies.add(t));
        return bunnies;
    }

    public Bunny getBunny(Long id) {
        return bunnyRepository.findById(id).get();
    }

    public void addBunny(Bunny bunny) {
        bunnyRepository.save(bunny);
    }

    public void updateBunny(Bunny bunny) {
        bunnyRepository.save(bunny);
    }
    
    public void deleteBunny(Long id) {
        bunnyRepository.delete(getBunny(id));
    }
    

    
}