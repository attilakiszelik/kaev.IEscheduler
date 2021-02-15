package com.example.IEscheduler.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.IEscheduler.domain.User;
import com.example.IEscheduler.domain.Vehicle;
import com.example.IEscheduler.repository.UserRepository;
import com.example.IEscheduler.repository.VehicleRepository;

@Service
public class MainService {
	
	private VehicleRepository vehicleRepo;
	private UserRepository userRepo;

	@Autowired
	public void setVehicleRepo(VehicleRepository vehicleRepo) {
		this.vehicleRepo = vehicleRepo;
	}
	
	@Autowired
	public void setUserRepo(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	public List<Vehicle> getVehicles(){
		
		//return vehicleRepo.findAll();
		return vehicleRepo.findAllnonDeleted();
		
	}
	
	public void newVehicle(boolean deleted, String regnum, String man, String type, int yop, long userid) {
		
		User owner =  userRepo.findById(userid);
				
		Vehicle vehicle = new Vehicle(deleted, regnum, man, type, yop, owner);
		vehicleRepo.save(vehicle);
		
	}
	
	
}
