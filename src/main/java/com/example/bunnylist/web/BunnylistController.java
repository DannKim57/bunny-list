package com.example.bunnylist.web;

import java.util.List;

import com.example.bunnylist.entities.Bunny;
import com.example.bunnylist.services.BunnyService;
import com.example.bunnylist.services.CarrotService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BunnylistController {
    @Autowired
    private BunnyService bunnyService;
    @Autowired
    private CarrotService carrotService;

    // public BunnylistController() {
    //     super();
    // }

    @GetMapping("/bunnies")
    public List<Bunny> findAllBunny() {
        return bunnyService.getAllBunnies();
    }

    @GetMapping("/bunnies/{id}")
    public Bunny findBunnyById(@PathVariable String id) {
        return bunnyService.getBunny(id);
    }

    @PostMapping("/bunnies")
    public void addBunny(@RequestBody Bunny bunny) {
        bunnyService.addBunny(bunny);
    }

    @PutMapping("/bunnies/{id}")
    public void updateBunny(@RequestBody Bunny bunny, @PathVariable String id) {
        bunnyService.addBunny(bunny);
    }

    @DeleteMapping("/bunnies/{id}")
    public void deleteBunny(@PathVariable String id) {
        bunnyService.deleteBunny(id);
    }

    
}