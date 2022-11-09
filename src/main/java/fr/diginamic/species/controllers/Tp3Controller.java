package fr.diginamic.species.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("tp3")
public class Tp3Controller {

	private final String TEMPLATE_TP3 = "tp3/tp3.html";
	private final String TEMPLATE_ADMIN = "tp3/tp3_admin.html";
	private final String TEMPLATE_USER_ADMIN = "tp3/tp3_user_admin.html";
	private final String TEMPLATE_AUTHENTIFIED = "tp3/tp3_authentified.html";
	private final String TEMPLATE_ENABLED = "tp3/tp3_enabled.html";
	private final String TEMPLATE_ID_OR_ADMIN = "tp3/tp3_id_or_admin.html";
	
	@GetMapping
	public String getTp3()
	{
		return TEMPLATE_TP3;
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("admin")
	public String getAdmin()
	{
		return TEMPLATE_ADMIN;
	}
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	@GetMapping("user_admin")
	public String getUserAdmin()
	{
		return TEMPLATE_USER_ADMIN;
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("authentified")
	public String getAuthentified()
	{
		return TEMPLATE_AUTHENTIFIED;
	}
	
	@PreAuthorize("principal.isEnabled()")
	@GetMapping("enabled")
	public String getEnabled()
	{
		return TEMPLATE_ENABLED;
	}
	
	@PreAuthorize("@permissionBean.isIdOkayOrAdmin(#id, principal.getUsername())")
	@GetMapping("id_or_admin/{id}")
	public String getIdOrAdmin(@PathVariable("id") Integer id)
	{
		return TEMPLATE_ID_OR_ADMIN;
	}
}
