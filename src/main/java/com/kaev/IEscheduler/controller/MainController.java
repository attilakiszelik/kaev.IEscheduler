package com.kaev.IEscheduler.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.kaev.IEscheduler.domain.User;
import com.kaev.IEscheduler.domain.Vehicle;
import com.kaev.IEscheduler.service.EmailService;
import com.kaev.IEscheduler.service.MainService;

@Controller
public class MainController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	private MainService mainService;
	private EmailService emailService;

	@Autowired	
	public void setMyMainService(MainService mainService) {
		this.mainService = mainService;
	}
	
	@Autowired	
	public void setMyEmailService(EmailService emailService) {
		this.emailService = emailService;
	}
	
	@GetMapping("/scheduler")
	public String scheduler(){
		return "scheduler";
	}
	
	@GetMapping("/vehicles")
	public String vehicles(Model model){
		model.addAttribute("vehicles", mainService.getVehicles());
		model.addAttribute("vehicle",new Vehicle());
		return "vehicles";
	}
	
	@GetMapping("/profile")
	public String profile(){
		return "profile";
	}
	
	@PostMapping("/new")
	public String newSubmit(@ModelAttribute Vehicle vehicle, Model model) {
		mainService.newVehicle(false, vehicle.getRegnum(), vehicle.getMan(), vehicle.getType(), vehicle.getYop(), 1);
		return "redirect:/vehicles";
	}
	
	@PostMapping("/update/{id}")
	public String updateSubmit(@PathVariable(value="id") String id, @ModelAttribute Vehicle vehicle, Model model) {
		Long vehicleid = Long.parseLong(id);
		mainService.updateVehicle(vehicleid, vehicle.getRegnum(), vehicle.getMan(), vehicle.getType(), vehicle.getYop());
		return "redirect:/vehicles";
	}
	
	@PostMapping("/delete/{id}")
	public String deleteSubmit(@PathVariable(value="id") String id, @ModelAttribute Vehicle vehicle, Model model) {
		Long vehicleid = Long.parseLong(id);
		mainService.deleteVehicle(vehicleid);
		return "redirect:/vehicles";
	}
	
	@GetMapping("/registration")
	public String registration(Model model){
		model.addAttribute("user", new User());
		return "auth/registration";
	}
	
	@PostMapping("/reg")
	public String reg(@ModelAttribute User user, Model model){
		emailService.sendMessage(user.getName(), user.getEmail());
		log.debug("Új regisztráció");
		log.debug(user.getName());
		log.debug(user.getEmail());
		log.debug(user.getPassword());
		return "redirect:/auth/login";
	}
	
	//kivételkezelés
	@RequestMapping("/user/{id}")
	public String searchUserById(@PathVariable(value="id") String id ) throws Exception{

		//pl. nem adpott meg felhasználót
		if(id==null) {
			throw new Exception("Nem adott meg felhasználót!");
		}
		return "user";
	
	}

}
