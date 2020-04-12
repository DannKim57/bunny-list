package com.example.bunnylist.web;

import java.util.Map;

import javax.validation.Valid;

import com.example.bunnylist.entities.Carrot;
import com.example.bunnylist.entities.Visit;
import com.example.bunnylist.repositories.CarrotRepository;
import com.example.bunnylist.repositories.VisitRepository;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VisitController {

    private final VisitRepository visitRepository;
    private final CarrotRepository carrotRepository;

    public VisitController(VisitRepository visitRepository, CarrotRepository carrotRepository) {
        this.visitRepository = visitRepository;
        this.carrotRepository = carrotRepository;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) { // ** 
        dataBinder.setDisallowedFields("id");
    }

    @ModelAttribute("visit")
    public Visit loadCarrotWithVisit(@PathVariable("carrotId") Long carrotId, Map<String, Object> model) {
        Carrot carrot = carrotRepository.findById(carrotId).get();
        carrot.setVisitsInternal(visitRepository.findByCarrotId(carrotId));
        model.put("carrot", carrot);
        Visit visit = new Visit();
        carrot.addVisit(visit);
        return visit;
    }

    @GetMapping("/bunnies/*/carrots/{carrotId}/visit/new")
    public String initNewVisitForm(@PathVariable("carrotId") Long carrotId, Map<String, Object> model) {
        return "carrots/createOrUpdateVisitForm";
    }

    @PostMapping("/bunnies/{bunnyId}/carrots/{carrotId}/visits/new")
    public String processNewVisitForm(@Valid Visit visit, BindingResult result) {
        if (result.hasErrors()) {
            return "carrots/createOrUpdateVisitForm";
        } else {
            visitRepository.save(visit);
            return "redirect:/bunnies/{bunnyId}"; // + {bunnyId}
        }
    }
}