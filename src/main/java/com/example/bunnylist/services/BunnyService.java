package com.example.bunnylist.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.example.bunnylist.entities.Bunny;
import com.example.bunnylist.entities.Carrot;
import com.example.bunnylist.repositories.BunnyRepository;
import com.example.bunnylist.repositories.VisitRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.servlet.ModelAndView;


@Service
public class BunnyService {

    private static final String VIEWS_BUNNY_CREATE_OR_UPDATE_FORM = "bunnies/createOrUpdateOwnerForm";

    private Logger logger = LoggerFactory.getLogger(BunnyService.class);
    @Autowired
    private BunnyRepository bunnyRepository;
    @Autowired
    private VisitRepository visitRepository;

    public List<Bunny> getAllBunnies() {
        List<Bunny> bunnies = new ArrayList<>();
        bunnyRepository.findAll().forEach((t) -> bunnies.add(t));
        return bunnies;
    }

    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
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

    public String initCreationForm(Map<String, Object> model) {
        Bunny bunny = new Bunny();
        model.put("bunny", bunny);
        return VIEWS_BUNNY_CREATE_OR_UPDATE_FORM;
    }

    public String processCreationForm(Bunny bunny, BindingResult result) {
        if (result.hasErrors()) {
            return VIEWS_BUNNY_CREATE_OR_UPDATE_FORM;
        } else {
            bunnyRepository.save(bunny);
            return "redirect:/bunnies/" + bunny.getId();
        }
    }

    public String initFindForm(Map<String, Object> model) {
        model.put("bunny", new Bunny());
        return "bunnies/findOwners";
    }

    public String processFindForm(Bunny bunny, BindingResult result, Map<String, Object> model) {
        // allow parameterless GET request for /owners to return all records
        if (bunny.getTitle() == null) {
            bunny.setTitle("");// empty string signifies broadest possible search
        }

        // find bunnies by Title
        Collection<Bunny> results = bunnyRepository.findByTitle(bunny.getTitle());
        if (results.isEmpty()) {
            // no bunnies found
            result.rejectValue("title", "notFound", "not found");
            return "bunnies/findBunnies";
        } else if (results.size() == 1) {
            // 1 bunny found
            bunny = results.iterator().next();
            return "redirect:/bunnies/" + bunny.getId();
        } else {
            // multiple bunnies found
            model.put("selections", results);
            return "bunnies/bunniesList";
        }
    }

    public String initUpdateBunnyForm(long bunnyId, Model model) {
        Bunny bunny = bunnyRepository.findById(bunnyId).get();
        model.addAttribute(bunny);
        return VIEWS_BUNNY_CREATE_OR_UPDATE_FORM;
    }

    public String processUpdateBunnyForm(Bunny bunny, BindingResult result, long bunnyId) {
        if (result.hasErrors()) {
            return VIEWS_BUNNY_CREATE_OR_UPDATE_FORM;
        } else {
            bunny.setId(bunnyId);
            bunnyRepository.save(bunny);
            return "redirect:/bunnies/"+bunnyId;
        }
    }

    public ModelAndView showBunny(long bunnyId) {
        ModelAndView mav = new ModelAndView("bunnies/bunnyDetails");
        Bunny bunny = bunnyRepository.findById(bunnyId).get();
        for (Carrot carrot : bunny.getCarrots()) {
            carrot.setVisitsInternal(visitRepository.findByCarrotId(carrot.getId()));
        }
        mav.addObject(bunny);
        return mav;
    }    
}