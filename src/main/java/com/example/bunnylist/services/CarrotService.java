package com.example.bunnylist.services;

import java.util.ArrayList;
import java.util.List;

import com.example.bunnylist.entities.Carrot;
import com.example.bunnylist.repositories.CarrotRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarrotService {
    // private Logger logger = LoggerFactory.getLogger(BunnyService.class);
    @Autowired
    private CarrotRepository carrotRepository;

    public List<Carrot> getAllCarrots() {
        List<Carrot> carrots = new ArrayList<>();
        carrotRepository.findAll().forEach((t) -> carrots.add(t));
        return carrots;
    }

    public Carrot getCarrot(Long id) {
        return carrotRepository.findById(id).get();
    }

    public void addCarrot(Carrot carrot) {
        carrotRepository.save(carrot);
    }

    public void updateCarrot(Carrot carrot) {
        carrotRepository.save(carrot);
    }
    
    public void deleteCarrot(Long id) {
        carrotRepository.delete(getCarrot(id));
    }
    
}