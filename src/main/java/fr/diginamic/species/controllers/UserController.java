package fr.diginamic.species.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.diginamic.species.entities.Animal;
import fr.diginamic.species.entities.User;
import fr.diginamic.species.services.UserService;

@Controller
@RequestMapping("user")
public class UserController {

	private final String TEMPLATE_USER = "user.html";
	private final String TEMPLATE_CREATE_USER = "user_create.html";
	
	private final String ATTRIBUTE_LIST_USER = "userList";
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public String getAllUsers(Model model)
	{
		model.addAttribute(ATTRIBUTE_LIST_USER, userService.findAll());
		return TEMPLATE_USER;
	}
	
	@GetMapping(path = "/create")
	public String createUser(Model model)
	{
		return TEMPLATE_CREATE_USER;
	}
	
	@PostMapping
	public @ResponseBody User createUser(@RequestParam String username, @RequestParam String password)
	{
		return userService.createUser(username, password);
	}

}
