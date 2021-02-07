package com.example.IEscheduler.controller;

import com.example.IEscheduler.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	private MainService mainService;

	@Autowired	
	public void setMyService(MainService mainService) {
		this.mainService = mainService;
	}
	

	@GetMapping("/")
	public String vehicles(Model model){
		model.addAttribute("vehicles", mainService.getVehicles());
		return "vehicles";
	}
	
	//kivételkezelés
	@RequestMapping("/user/{id}")
	public String searchUserById(@PathVariable(value="id") String id ) throws Exception{

		//pl. nem adpott meg felhasználót
		if(id==null) {
			throw new Exception("Nem adott meg falhaználót!");
		}
		return "user";
	
	}

}
