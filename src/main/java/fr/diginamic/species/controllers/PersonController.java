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

import fr.diginamic.species.entities.Person;
import fr.diginamic.species.services.PersonService;

@Controller
@RequestMapping("person")
public class PersonController {

	private final String TEMPLATE_PERSON = "person.html";
	private final String TEMPLATE_CREATE_PERSON = "person_create.html";
	
	private final String ATTRIBUTE_PERSON = "person";
	private final String ATTRIBUTE_LIST_PERSON = "personList";
	
	@Autowired
	PersonService personService;
	
	@GetMapping
	String getAllPersons(Model model)
	{
		model.addAttribute(ATTRIBUTE_LIST_PERSON, personService.findAll());
		return TEMPLATE_PERSON;
	}
	
	@GetMapping(path = "/{id}")
	String getPersonById(@PathVariable("id") Integer id, Model model)
	{
		Person person = personService.searchById(id);
		model.addAttribute(ATTRIBUTE_PERSON, person);
		return TEMPLATE_CREATE_PERSON;
	}
	
	@GetMapping(path = "/create")
	String createPerson(Model model)
	{
		Person person = new Person();
		model.addAttribute(ATTRIBUTE_PERSON, person);
		return TEMPLATE_CREATE_PERSON;
	}
	
	@PostMapping
	public String createOrUpdatePerson(@Valid Person person, BindingResult result)
	{
		if (result.hasErrors())
			return TEMPLATE_CREATE_PERSON;
		personService.save(person);
		return "redirect:/person";
	}
	
	@GetMapping(path = "/delete/{id}")
	public String deletePerson(@PathVariable("id") Integer id)
	{
		personService.delete(id);
		return "redirect:/person";
	}
}
