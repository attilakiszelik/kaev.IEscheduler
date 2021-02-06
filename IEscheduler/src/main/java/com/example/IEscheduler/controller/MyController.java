package com.example.IEscheduler.controller;

//import com.example.IEscheduler.service.MyService;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.IEscheduler.domain.Vehicle;
import java.util.ArrayList;

@Controller
public class MyController {
	
//	private MyService myService;

//	@Autowired	
//	public void setMyService(MyService myService) {
//		this.myService = myService;
//	}

	@GetMapping("/")
	public String vehicles(Model model){
	
		model.addAttribute("vehicles", getVehicles());
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
	
	private ArrayList<Vehicle> getVehicles(){
		
		ArrayList<Vehicle> vehicles = new ArrayList<>();
		
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setId(1);
		vehicle1.setRegnum("ABC-000");
		vehicle1.setMan("MAN");
		vehicle1.setType("régi típus");
		vehicle1.setYop(1960);
		vehicle1.setDeleted(false);
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setId(2);
		vehicle2.setRegnum("ABC-123");
		vehicle2.setMan("MAN");
		vehicle2.setType("új típus");
		vehicle2.setYop(1980);
		vehicle2.setDeleted(false);
		
		vehicles.add(vehicle1);
		vehicles.add(vehicle2);
		
		return vehicles;
		
	}

}
