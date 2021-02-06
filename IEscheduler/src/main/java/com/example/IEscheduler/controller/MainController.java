package com.example.IEscheduler.controller;

//import com.example.IEscheduler.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.IEscheduler.domain.Vehicle;
import com.example.IEscheduler.repository.VehicleRepository;
import java.util.List;

@Controller
public class MainController {
	
//	private MyService myService;

//	@Autowired	
//	public void setMyService(MyService myService) {
//		this.myService = myService;
//	}
	
	@Autowired
	VehicleRepository vehicleRepo;

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
	
	private List<Vehicle> getVehicles(){
		
		List<Vehicle> vehicles = vehicleRepo.findAll();
		return vehicles;
		
	}

}
