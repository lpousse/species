package fr.diginamic.species.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import fr.diginamic.species.entities.User;
import fr.diginamic.species.services.UserService;

@Service
public class PermissionBean {
	
	@Autowired
	private UserService userService;
	
	public boolean isIdOkayOrAdmin(Integer id, String username)
	{
		User user = userService.findByUsername(username);
		return user.getId() == id || user.getAuthorities().stream().anyMatch(a -> a.getName().equals("ROLE_ADMIN"));
	}
}
