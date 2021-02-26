package com.kaev.IEscheduler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kaev.IEscheduler.domain.Vehicle;
import com.kaev.IEscheduler.service.MainService;

@Controller
public class MainController {
	
	private MainService mainService;

	@Autowired	
	public void setMyService(MainService mainService) {
		this.mainService = mainService;
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
