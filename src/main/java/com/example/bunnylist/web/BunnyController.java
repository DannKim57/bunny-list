package com.example.bunnylist.web;

import java.util.Collection;
import java.util.Map;

import javax.validation.Valid;

import com.example.bunnylist.entities.Bunny;
import com.example.bunnylist.entities.Carrot;
import com.example.bunnylist.repositories.BunnyRepository;
import com.example.bunnylist.repositories.VisitRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BunnyController {

	private static final String VIEWS_BUNNY_CREATE_OR_UPDATE_FORM = "bunnies/createOrUpdateBunnyForm";

	@Autowired
	private BunnyRepository bunnyRepository;

	@Autowired
	private VisitRepository visitRepository;

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@GetMapping("/bunnies/new")
	public String initCreationForm(Map<String, Object> model) {
		Bunny bunny = new Bunny();
		model.put("bunny", bunny);
		return VIEWS_BUNNY_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping("/bunnies/new")
	public String processCreationForm(@Valid Bunny bunny, BindingResult result) {
		if (result.hasErrors()) {
			return VIEWS_BUNNY_CREATE_OR_UPDATE_FORM;
		}
		else {
			bunnyRepository.save(bunny);
			return "redirect:/bunnies/" + bunny.getId();
		}
	}

	@GetMapping("/bunnies/find")
	public String initFindForm(Map<String, Object> model) {
		model.put("bunny", new Bunny());
		return "bunnies/findBunnies";
	}

	@GetMapping("/bunnies")
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
		}
		else if (results.size() == 1) {
			// 1 bunny found
			bunny = results.iterator().next();
			return "redirect:/bunnies/" + bunny.getId();
		}
		else {
			// multiple bunnies found
			model.put("selections", results);
			return "bunnies/bunniesList";
		}
	}

	@GetMapping("/bunnies/{bunnyId}/edit")
	public String initUpdateBunnyForm(@PathVariable("bunnyId") Long bunnyId, Model model) {
		Bunny bunny = bunnyRepository.findById(bunnyId).get();
		model.addAttribute(bunny);
		return VIEWS_BUNNY_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping("/bunnies/{bunnyId}/edit")
	public String processUpdateBunnyForm(@Valid Bunny bunny, BindingResult result,
			@PathVariable("bunnyId") Long bunnyId) {
		if (result.hasErrors()) {
			return VIEWS_BUNNY_CREATE_OR_UPDATE_FORM;
		}
		else {
			bunny.setId(bunnyId);
			bunnyRepository.save(bunny);
			return "redirect:/bunnies/" + bunnyId;
		}
	}

	@GetMapping("/bunnies/{bunnyId}") // need to fix!
	public ModelAndView showBunny(@PathVariable("bunnyId") Long bunnyId) {
		ModelAndView mav = new ModelAndView("bunnies/bunnyDetails");
		Bunny bunny = bunnyRepository.findById(bunnyId).get();
		for (Carrot carrot : bunny.getCarrots()) {
			carrot.setVisitsInternal(visitRepository.findByCarrotId(carrot.getId()));
		}
		mav.addObject(bunny);
		return mav;
	}

}