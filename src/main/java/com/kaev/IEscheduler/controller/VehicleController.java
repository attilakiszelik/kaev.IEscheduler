package com.kaev.IEscheduler.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.kaev.IEscheduler.domain.Vehicle;
import com.kaev.IEscheduler.service.VehicleService;

@Controller
public class VehicleController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	private VehicleService vehicleService;

	@Autowired	
	public void setVehicleService(VehicleService vehicleService) {
		this.vehicleService = vehicleService;
	}
	
	@PostMapping("/new")
	public String newSubmit(@ModelAttribute Vehicle vehicle, Model model) {
		vehicleService.newVehicle(false, vehicle.getRegnum(), vehicle.getMan(), vehicle.getType(), vehicle.getYop(), 1);
		return "redirect:/vehicles";
	}
	
	@PostMapping("/update/{id}")
	public String updateSubmit(@PathVariable(value="id") String id, @ModelAttribute Vehicle vehicle, Model model) {
		Long vehicleid = Long.parseLong(id);
		vehicleService.updateVehicle(vehicleid, vehicle.getRegnum(), vehicle.getMan(), vehicle.getType(), vehicle.getYop());
		return "redirect:/vehicles";
	}
	
	@PostMapping("/delete/{id}")
	public String deleteSubmit(@PathVariable(value="id") String id, @ModelAttribute Vehicle vehicle, Model model) {
		Long vehicleid = Long.parseLong(id);
		vehicleService.deleteVehicle(vehicleid);
		return "redirect:/vehicles";
	}
	
}
