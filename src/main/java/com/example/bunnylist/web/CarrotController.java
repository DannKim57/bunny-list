package com.example.bunnylist.web;

import java.util.Collection;

import javax.validation.Valid;

import com.example.bunnylist.entities.Bunny;
import com.example.bunnylist.entities.Carrot;
import com.example.bunnylist.entities.CarrotType;
import com.example.bunnylist.entities.CarrotValidator;
import com.example.bunnylist.repositories.BunnyRepository;
import com.example.bunnylist.repositories.CarrotRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bunnies/{bunnyId}")
public class CarrotController {

	private static final String VIEWS_CARROTS_CREATE_OR_UPDATE_FORM = "carrots/createOrUpdateCarrotForm";

	@Autowired
	private BunnyRepository bunnyRepository;

	@Autowired
	private CarrotRepository carrotRepository;

	@ModelAttribute("types")
	public Collection<CarrotType> pupulateCarrotTypes() {
		return carrotRepository.findCarrotTypes();
	}

	@ModelAttribute("bunny")
	public Bunny findBunny(@PathVariable("bunnyId") Long bunnyId) {
		return bunnyRepository.findById(bunnyId).get();
	}

	@InitBinder("bunny")
	public void initBunnyBinder(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@InitBinder("carrot")
	public void initCarrotBinder(WebDataBinder dataBinder) {
		dataBinder.setValidator(new CarrotValidator());
	}

	@GetMapping("/carrots/new")
	public String initCreationForm(Bunny bunny, ModelMap model) {
		Carrot carrot = new Carrot();
		bunny.addCarrot(carrot);
		model.put("carrot", carrot);
		return VIEWS_CARROTS_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping("/carrots/new")
	public String processCreationForm(Bunny bunny, @Valid Carrot carrot, BindingResult result, ModelMap model) {
		if (StringUtils.hasLength(carrot.getName()) && carrot.isNew()
				&& bunny.getCarrot(carrot.getName(), true) != null) {
			result.rejectValue("name", "duplicate", "already exists");
		}
		bunny.addCarrot(carrot);
		if (result.hasErrors()) {
			model.put("carrot", carrot);
			return VIEWS_CARROTS_CREATE_OR_UPDATE_FORM;
		}
		else {
			carrotRepository.save(carrot);
			return "redirect:/bunnies/{bunnyId}"; // + {bunnyId}
		}
	}

	@GetMapping("/carrots/{carrotId}/edit")
	public String initUpdateForm(@PathVariable("carrotId") Long carrotId, ModelMap model) {
		Carrot carrot = carrotRepository.findById(carrotId).get();
		model.put("carrot", carrot);
		return VIEWS_CARROTS_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping("/carrots/{carrotId}/edit")
	public String processUpdateForm(@Valid Carrot carrot, BindingResult result, Bunny bunny, ModelMap model) {
		if (result.hasErrors()) {
			carrot.setBunny(bunny);
			model.put("carrot", carrot);
			return VIEWS_CARROTS_CREATE_OR_UPDATE_FORM;
		}
		else {
			bunny.addCarrot(carrot);
			carrotRepository.save(carrot);
			return "redirect:/bunnies/{bunnyId}"; // + {bunnyId}
		}
	}

}