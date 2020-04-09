package com.example.bunnylist.web;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.example.bunnylist.entities.Bunny;
import com.example.bunnylist.services.BunnyService;
import com.example.bunnylist.services.CarrotService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
    public Bunny findBunnyById(@PathVariable Long id) {
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
    public void deleteBunny(@PathVariable Long id) {
        bunnyService.deleteBunny(id);
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        bunnyService.setAllowedFields(dataBinder);
    }

    @GetMapping("/bunnies/new")
    public String initCreationForm(Map<String, Object> model) {
        String ans = bunnyService.initCreationForm(model);
        return ans;
    }

    @PostMapping("/bunnies/new")
    public String processCreationForm(@Valid Bunny bunny, BindingResult result) {
        String ans = bunnyService.processCreationForm(bunny, result);
        return ans;
    }

    @GetMapping("/bunnies/find")
    public String initFindForm(Map<String, Object> model) {
        String ans = bunnyService.initFindForm(model);
        return ans;
    } 

    @GetMapping("/bunnies")
    public String processFindForm(Bunny bunny, BindingResult result, Map<String, Object> model) {
        String ans = bunnyService.processFindForm(bunny, result, model);
        return ans;
    }

    @GetMapping("/bunnies/{bunnyId}/edit") 
    public String initUpdateBunnyForm(@PathVariable("bunnyId") long bunnyId, Model model) {
        String ans = bunnyService.initUpdateBunnyForm(bunnyId, model);
        return ans;
    }

    @PostMapping("/bunnies/{bunnyId}/edit")
    public String processUpdateBunnyForm(@Valid Bunny bunny, BindingResult result,
                @PathVariable("bunnyId") long bunnyId) {
        String ans = bunnyService.processUpdateBunnyForm(bunny, result, bunnyId);
        return ans;
    }

    @GetMapping("/bunnies/{bunnyId}") 
    public ModelAndView showBunny(@PathVariable("bunnyId") long bunnyId) {
        ModelAndView ans = bunnyService.showBunny(bunnyId);
        return ans;
    }



    
}