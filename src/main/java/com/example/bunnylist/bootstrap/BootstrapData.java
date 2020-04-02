package com.example.bunnylist.bootstrap;

import com.example.bunnylist.entities.Bunny;
import com.example.bunnylist.entities.Carrot;
import com.example.bunnylist.services.BunnyService;
import com.example.bunnylist.services.CarrotService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    private final BunnyService bunnyService;
    private final CarrotService carrotService;

    public BootstrapData(BunnyService bunnyService, CarrotService carrotService) {
        this.bunnyService = bunnyService;
        this.carrotService = carrotService;
    }

    @Override
    public void run(String... args) throws Exception {
        Bunny bunny1 = new Bunny("bunny1", "Hello! this is bunny1");
        Bunny bunny2 = new Bunny("bunny2", "Hi! I'm bunny2");
        
        bunnyService.addBunny(bunny1);
        bunnyService.addBunny(bunny2);

        Carrot carrot1 = new Carrot();
        carrot1.setBunny(bunny1);
        carrot1.setOnGoing(false);
        carrot1.setFeatures("Watered");

        carrotService.addCarrot(carrot1);
        
    }
}