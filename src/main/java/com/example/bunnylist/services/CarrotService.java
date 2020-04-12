package com.example.bunnylist.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.example.bunnylist.entities.Bunny;
import com.example.bunnylist.entities.Carrot;
import com.example.bunnylist.entities.CarrotType;
import com.example.bunnylist.entities.CarrotValidator;
import com.example.bunnylist.repositories.BunnyRepository;
import com.example.bunnylist.repositories.CarrotRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;

@Service
public class CarrotService {

	// private Logger logger = LoggerFactory.getLogger(BunnyService.class);

	private static final String VIEWS_CARROTS_CREATE_OR_UPDATE_FORM = "carrots/createOrUpdateCarrotForm";

	@Autowired
	private BunnyRepository bunnyRepository;

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

	public Collection<CarrotType> populateCarrotTypes() {
		return carrotRepository.findCarrotTypes();
	}

	public Bunny findBunny(long bunnyId) {
		return bunnyRepository.findById(bunnyId).get();
	}

	public void initBunnyBinder(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	public void initCarrotBinder(WebDataBinder dataBinder) {
		dataBinder.setValidator(new CarrotValidator());
	}

	public String initCreationForm(Bunny bunny, ModelMap model) {
		Carrot carrot = new Carrot();
		bunny.addCarrot(carrot);
		model.put("carrot", carrot);
		return VIEWS_CARROTS_CREATE_OR_UPDATE_FORM;
	}

	public String processCreationForm(Bunny bunny, Carrot carrot, BindingResult result, ModelMap model) {
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

	public String initUpdateForm(long carrotId, ModelMap model) {
		Carrot carrot = carrotRepository.findById(carrotId).get();
		model.put("carrot", carrot);
		return VIEWS_CARROTS_CREATE_OR_UPDATE_FORM;
	}

	public String processUpdateForm(Carrot carrot, BindingResult result, Bunny bunny, ModelMap model) {
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