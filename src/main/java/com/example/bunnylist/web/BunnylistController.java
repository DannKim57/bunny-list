package com.example.bunnylist.web;

import java.util.Collection;
import java.util.Map;

import javax.validation.Valid;

import com.example.bunnylist.entities.Bunny;
import com.example.bunnylist.entities.Carrot;
import com.example.bunnylist.entities.CarrotType;
import com.example.bunnylist.entities.Visit;
import com.example.bunnylist.services.BunnyService;
import com.example.bunnylist.services.CarrotService;
import com.example.bunnylist.services.VisitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

public class BunnylistController {

	@Autowired
	private BunnyService bunnyService;

	@Autowired
	private CarrotService carrotService;

	@Autowired
	private VisitService visitService;

	// public BunnylistController() {
	// super();
	// }

	// @GetMapping("/bunnies")
	// public List<Bunny> findAllBunny() {
	// return bunnyService.getAllBunnies();
	// }

	// @GetMapping("/bunnies/{id}")
	// public Bunny findBunnyById(@PathVariable Long id) {
	// return bunnyService.getBunny(id);
	// }

	// @PostMapping("/bunnies")
	// public void addBunny(@RequestBody Bunny bunny) {
	// bunnyService.addBunny(bunny);
	// }

	// @PutMapping("/bunnies/{id}")
	// public void updateBunny(@RequestBody Bunny bunny, @PathVariable String id) {
	// bunnyService.addBunny(bunny);
	// }

	// @DeleteMapping("/bunnies/{id}")
	// public void deleteBunny(@PathVariable Long id) {
	// bunnyService.deleteBunny(id);
	// }

	// @InitBinder
	// public void setAllowedFields(WebDataBinder dataBinder) {
	// bunnyService.setAllowedFields(dataBinder);
	// }

	// @GetMapping("/bunnies/new")
	// public String initCreationForm(Map<String, Object> model) {
	// String ans = bunnyService.initCreationForm(model);
	// return ans;
	// }

	// @PostMapping("/bunnies/new")
	// public String processCreationForm(@Valid Bunny bunny, BindingResult result) {
	// String ans = bunnyService.processCreationForm(bunny, result);
	// return ans;
	// }

	// @GetMapping("/bunnies/find")
	// public String initFindForm(Map<String, Object> model) {
	// String ans = bunnyService.initFindForm(model);
	// return ans;
	// }

	// @GetMapping("/bunnies")
	// public String processFindForm(Bunny bunny, BindingResult result, Map<String,
	// Object> model) {
	// String ans = bunnyService.processFindForm(bunny, result, model);
	// return ans;
	// }

	// @GetMapping("/bunnies/{bunnyId}/edit")
	// public String initUpdateBunnyForm(@PathVariable("bunnyId") Long bunnyId, Model
	// model) {
	// String ans = bunnyService.initUpdateBunnyForm(bunnyId, model);
	// return ans;
	// }

	// @PostMapping("/bunnies/{bunnyId}/edit")
	// public String processUpdateBunnyForm(@Valid Bunny bunny, BindingResult result,
	// @PathVariable("bunnyId") Long bunnyId) {
	// String ans = bunnyService.processUpdateBunnyForm(bunny, result, bunnyId);
	// return ans;
	// }

	// @GetMapping("/bunnies/{bunnyId}")
	// public ModelAndView showBunny(@PathVariable("bunnyId") Long bunnyId) {
	// ModelAndView ans = bunnyService.showBunny(bunnyId);
	// return ans;
	// }

	// // PetController

	// @ModelAttribute("types")
	// public Collection<CarrotType> pupulateCarrotTypes() {
	// Collection<CarrotType> ans = carrotService.populateCarrotTypes();
	// return ans;
	// }

	// @ModelAttribute("bunny")
	// public Bunny findBunny(@PathVariable("bunnyId") Long bunnyId) {
	// Bunny ans = carrotService.findBunny(bunnyId);
	// return ans;
	// }

	// @InitBinder("bunny")
	// public void initBunnyBinder(WebDataBinder dataBinder) {
	// carrotService.initBunnyBinder(dataBinder);
	// }

	// @InitBinder("carrot")
	// public void initCarrotBinder(WebDataBinder dataBinder) {
	// carrotService.initCarrotBinder(dataBinder);
	// }

	// @GetMapping("/carrots/new")
	// public String initCreationForm(Bunny bunny, ModelMap model) {
	// String ans = carrotService.initCreationForm(bunny, model);
	// return ans;
	// }

	// @PostMapping("/carrots/new")
	// public String processCreationForm(Bunny bunny, @Valid Carrot carrot, BindingResult
	// result, ModelMap model) {
	// String ans = carrotService.processCreationForm(bunny, carrot, result, model);
	// return ans;
	// }

	// @GetMapping("/carrots/{carrotId}/edit")
	// public String initUpdateForm(@PathVariable("carrotId") Long carrotId, ModelMap
	// model) {
	// String ans = carrotService.initUpdateForm(carrotId, model);
	// return ans;
	// }

	// @PostMapping("/carrots/{carrotId}/edit")
	// public String processUpdateForm(@Valid Carrot carrot, BindingResult result, Bunny
	// bunny, ModelMap model) {
	// String ans = carrotService.processUpdateForm(carrot, result, bunny, model);
	// return ans;
	// }

	// // VisitController
	// @InitBinder
	// public void setAllowedFieldsForVisit(WebDataBinder dataBinder) { // **
	// visitService.setAllowedFields(dataBinder);
	// }

	// @ModelAttribute("visit")
	// public Visit loadCarrotWithVisit(@PathVariable("carrotId") Long carrotId,
	// Map<String, Object> model) {
	// Visit ans = visitService.loadCarrotWithVisit(carrotId, model);
	// return ans;
	// }

	// @GetMapping("/bunnies/*/carrots/{carrotId}/visit/new")
	// public String initNewVisitForm(@PathVariable("carrotId") Long carrotId, Map<String,
	// Object> model) {
	// String ans = visitService.initNewVisitForm(carrotId, model);
	// return ans;
	// }

	// @PostMapping("/bunnies/{bunnyId}/carrots/{carrotId}/visits/new")
	// public String processNewVisitForm(@Valid Visit visit, BindingResult result) {
	// String ans = visitService.processNewVisitForm(visit, result);
	// return ans;
	// }

}