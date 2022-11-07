package fr.diginamic.species.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.diginamic.species.entities.Animal;
import fr.diginamic.species.enums.Sex;
import fr.diginamic.species.services.AnimalService;
import fr.diginamic.species.services.SpeciesService;


@Controller
@RequestMapping("animal")
public class AnimalController {

	private final String TEMPLATE_ANIMAL = "animal.html";
	private final String TEMPLATE_CREATE_ANIMAL = "animal_create.html";
	
	private final String ATTRIBUTE_ANIMAL = "animal";
	private final String ATTRIBUTE_LIST_ANIMAL = "animalList";
	private final String ATTRIBUTE_LIST_SEX = "sexList";
	private final String ATTRIBUTE_LIST_SPECIES = "speciesList";
	
	@Autowired
	AnimalService animalService;
	@Autowired
	SpeciesService speciesService;
	
	@GetMapping
	public String getAllAnimals(Model model)
	{
		model.addAttribute(ATTRIBUTE_LIST_ANIMAL, animalService.findAll());
		return TEMPLATE_ANIMAL;
	}
	
	@GetMapping(path = "/{id}")
	public String getAnimalById(@PathVariable("id") Integer id, Model model)
	{
		Animal animal = animalService.searchById(id);
		model.addAttribute(ATTRIBUTE_ANIMAL, animal);
		setCommonAttributes(model);
		return TEMPLATE_CREATE_ANIMAL;
	}
	
	@GetMapping(path = "/create")
	public String createAnimal(Model model)
	{
		Animal animal = new Animal();
		model.addAttribute(ATTRIBUTE_ANIMAL, animal);
		setCommonAttributes(model);
		return TEMPLATE_CREATE_ANIMAL;
	}
	
	@PostMapping
	public String createOrUpdateAnimal(@Valid Animal animal, BindingResult result, Model model)
	{
		if (result.hasErrors())
		{
			setCommonAttributes(model);
			return TEMPLATE_CREATE_ANIMAL;
		}
		animalService.save(animal);
		return "redirect:/animal";
	}
	
	@GetMapping(path = "/delete/{id}")
	public String deleteAnimal(@PathVariable("id") Integer id)
	{
		animalService.delete(id);
		return "redirect:/animal";
	}
	
	private void setCommonAttributes(Model model)
	{
		model.addAttribute(ATTRIBUTE_LIST_SEX, Sex.values());
		model.addAttribute(ATTRIBUTE_LIST_SPECIES, speciesService.findAll());
	}
}
