package com.example.IEscheduler.controller;

import com.example.IEscheduler.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	private MainService mainService;

	@Autowired	
	public void setMyService(MainService mainService) {
		this.mainService = mainService;
	}

	@RequestMapping("/")
	public String vehicles(Model model){
		model.addAttribute("vehicles", mainService.getVehicles());
		return "vehicles";
	}
	
	@RequestMapping("/new")
	public String newVehicle(Model model){
		mainService.newVehicle(false, "ZZZ-111", "IVECO", "nagy", 2020, 1);
		model.addAttribute("vehicles", mainService.getVehicles());
		return "vehicles";
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
