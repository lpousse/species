package fr.diginamic.species.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.diginamic.species.entities.Species;
import fr.diginamic.species.services.SpeciesService;

@Controller
@RequestMapping("species")
public class SpeciesController {

	private final String TEMPLATE_SPECIES = "species.html";
	private final String TEMPLATE_CREATE_SPECIES = "species_create.html";
	
	private final String ATTRIBUTE_SPECIES = "species";
	private final String ATTRIBUTE_LIST_SPECIES = "speciesList";
	
	@Autowired
	SpeciesService speciesService;
	
	@GetMapping
	String getAllSpecies(Model model)
	{
		model.addAttribute(ATTRIBUTE_LIST_SPECIES, speciesService.findAll());
		return TEMPLATE_SPECIES;
	}
	
	@GetMapping(path = "/{id}")
	String getSpeciesById(@PathVariable("id") Integer id, Model model)
	{
		Species species = speciesService.searchById(id);
		model.addAttribute(ATTRIBUTE_SPECIES, species);
		return TEMPLATE_CREATE_SPECIES;
	}
	
	@GetMapping(path = "/create")
	String createSpecies(Model model)
	{
		Species species = new Species();
		model.addAttribute(ATTRIBUTE_SPECIES, species);
		return TEMPLATE_CREATE_SPECIES;
	}
	
	@PostMapping
	public String createOrUpdateSpecies(@Valid Species species, BindingResult result)
	{
		if (result.hasErrors())
			return TEMPLATE_CREATE_SPECIES;
		speciesService.save(species);
		return "redirect:/species";
	}
	
	@GetMapping(path = "/delete/{id}")
	public String deleteSpecies(@PathVariable("id") Integer id)
	{
		speciesService.delete(id);
		return "redirect:/species";
	}
}
