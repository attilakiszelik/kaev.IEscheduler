package com.kaev.IEscheduler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kaev.IEscheduler.authentication.myAuthenticationFacade;
import com.kaev.IEscheduler.domain.Event;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
import com.kaev.IEscheduler.domain.Vehicle;
import com.kaev.IEscheduler.enums.service_TYPE;
import com.kaev.IEscheduler.service.UserServiceImpl;
import com.kaev.IEscheduler.service.VehicleService;

@Controller
public class MainController {
	
    @Autowired
    private myAuthenticationFacade authenticationFacade;
	
	private VehicleService vehicleService;
	private UserServiceImpl userService;

	@Autowired	
	public void setVehicleService(VehicleService vehicleService) {
		this.vehicleService = vehicleService;
	}
	
	@Autowired	
	public void setUserService(UserServiceImpl userService) {
		this.userService = userService;
	}
	
	@GetMapping("/")
	public String main(){
		return "redirect:/scheduler";
	}
	
	@GetMapping("/scheduler")
	public String scheduler(Model model){
		
		Authentication authentication = authenticationFacade.getAuthentication();
        String userEmail = authentication.getName();
		
		model.addAttribute("event", new Event());
		model.addAttribute("vehicleList", vehicleService.getVehicles(userEmail));
		model.addAttribute("serviceList", service_TYPE.values());
		return "scheduler";	
	}
	
	@GetMapping("/vehicles")
	public String vehicles(Model model){
		
		Authentication authentication = authenticationFacade.getAuthentication();
        String userEmail = authentication.getName();
		
		model.addAttribute("vehicles", vehicleService.getVehicles(userEmail));
		model.addAttribute("vehicle",new Vehicle());
		return "vehicles";
	}
	
	@GetMapping("/profile")
	public String profile(){
		return "profile";
	}
	
	@GetMapping("/registrations")
	public String registrations(Model model){
		model.addAttribute("users", userService.getLockedUsers());
		return "registrations";
	}
/*	
	//kivételkezelés
	@RequestMapping("/user/{id}")
	public String searchUserById(@PathVariable(value="id") String id ) throws Exception{

		//pl. nem adott meg felhasználót
		if(id==null) {
			throw new Exception("Nem adott meg felhasználót!");
		}
		return "user";
	
	}
*/
}
