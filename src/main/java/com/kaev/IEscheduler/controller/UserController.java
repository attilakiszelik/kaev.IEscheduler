package com.kaev.IEscheduler.controller;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.kaev.IEscheduler.domain.User;
import com.kaev.IEscheduler.service.UserService;

@Controller
public class UserController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	private UserService userService;

	@Autowired	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/registration")
	public String registration(Model model){
		model.addAttribute("user", new User());
		return "auth/registration";
	}
	
	@PostMapping("/reg")
	public String reg(@ModelAttribute User user, Model model){
		userService.registerUser(user);
		log.debug("új regisztráció");
		log.debug("felhasználó név: " + user.getName());
		log.debug("e-mail cím: " + user.getEmail());
		log.debug("jelszó (titkosítva): " + user.getPassword());
		log.debug("activation_key: " + user.getActivation_key());
		log.debug("enabled: " + user.isEnabled());
		log.debug("locked: " + user.isLocked());
		return "redirect:/auth/login?registrationsuccess";
	}
	
	@GetMapping("/activation/{activation_key}")
	public String authentication(@PathVariable(value="activation_key") String activation_key, HttpServletResponse response) {
		
		String result= userService.activateUser(activation_key);
		
		if ( result.equals("userNotFound") )
			return "redirect:/auth/login?usernotfound";
		
		if( result.equals("userActivated") )
			log.debug("regisztráció aktiválva!");

		return "redirect:/";
	}
	
	@PostMapping("/unlock/accept/{id}")
	public String unlockAccept(@PathVariable(value="id") String id) {
		Long userid = Long.parseLong(id);
		userService.unlockUser(userid);
		log.debug("felhasználói fiók feloldva!");
		return "redirect:/registrations";
	}
	
	@PostMapping("/unlock/decline/{id}")
	public String unlockDecline(@PathVariable(value="id") String id) {
		Long userid = Long.parseLong(id);
		userService.deleteUser(userid);
		log.debug("felhasználói fiók törölve!");
		return "redirect:/registrations";
	}
	
}
