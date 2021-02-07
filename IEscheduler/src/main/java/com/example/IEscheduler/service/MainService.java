package com.example.IEscheduler.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.IEscheduler.domain.User;
import com.example.IEscheduler.domain.Vehicle;
import com.example.IEscheduler.repository.VehicleRepository;

@Service
public class MainService {
	
	private VehicleRepository vehicleRepo;

	@Autowired
	public void setVehicleRepo(VehicleRepository vehicleRepo) {
		this.vehicleRepo = vehicleRepo;
	}
	
	public List<Vehicle> getVehicles(){
		return vehicleRepo.findAll();
	}
	
	public void newVehicle(String regnum, String man, String type, int yop, User owner, boolean deleted) {
		
		Vehicle vehicle = new Vehicle(regnum, man, type, yop, owner, deleted);
		vehicleRepo.save(vehicle);
		
	}
	
	
}
