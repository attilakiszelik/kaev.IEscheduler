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
		newVehicle("ZZZ-111", "IVECO", "nagy", 2020, 1, false);
		return vehicleRepo.findAll();
	}
	
	public void newVehicle(String regnum, String man, String type, int yop, long userid, boolean deleted) {
		
		User owner =  userRepo.findById(userid);
				
		Vehicle vehicle = new Vehicle(regnum, man, type, yop, owner, deleted);
		vehicleRepo.save(vehicle);
		
	}
	
	
}
