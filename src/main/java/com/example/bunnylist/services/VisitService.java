package com.example.bunnylist.services;

import java.util.Map;

import com.example.bunnylist.entities.Carrot;
import com.example.bunnylist.entities.Visit;
import com.example.bunnylist.repositories.CarrotRepository;
import com.example.bunnylist.repositories.VisitRepository;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;

@Service
public class VisitService {

    private final VisitRepository visitRepository;
    private final CarrotRepository carrotRepository;

    public VisitService(VisitRepository visitRepository, CarrotRepository carrotRepository) {
        this.visitRepository = visitRepository;
        this.carrotRepository = carrotRepository;
    }

    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    public Visit loadCarrotWithVisit(long carrotId, Map<String, Object> model) {
        Carrot carrot = carrotRepository.findById(carrotId).get();
        carrot.setVisitsInternal(visitRepository.findByCarrotId(carrotId));
        model.put("carrot", carrot);
        Visit visit = new Visit();
        carrot.addVisit(visit);
        return visit;
    }

    public String initNewVisitForm(long carrotId, Map<String, Object> model) {
        return "carrots/createOrUpdateVisitForm";
    }

    public String processNewVisitForm(Visit visit, BindingResult result) {
        if (result.hasErrors()) {
            return "carrots/createOrUpdateVisitForm";
        } else {
            visitRepository.save(visit);
            return "redirect:/bunnies/{bunnyId}"; // + {bunnyId}
        }
    }
}