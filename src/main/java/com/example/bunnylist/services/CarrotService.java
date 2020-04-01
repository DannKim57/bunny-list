package com.example.bunnylist.services;

import com.example.bunnylist.entities.Carrot;
import com.example.bunnylist.repositories.CarrotRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarrotService {
    @Autowired
    private CarrotRepository carrotRepository;

    public Carrot getCarrot(String id) {
        return carrotRepository.findById(id).get();
    }

    public void addCarrot (Carrot carrot) {
        carrotRepository.save(carrot);
    }

    public void updateCarrot (Carrot carrot) {
        carrotRepository.save(carrot);
    }

    public void deleteCarrot (String id) {
        carrotRepository.delete(getCarrot(id));
    }
    
}