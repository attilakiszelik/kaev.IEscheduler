package com.kaev.IEscheduler.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kaev.IEscheduler.domain.User;
import com.kaev.IEscheduler.domain.Vehicle;
import com.kaev.IEscheduler.enums.vehicle_TYPE;
import com.kaev.IEscheduler.repository.UserRepository;
import com.kaev.IEscheduler.repository.VehicleRepository;

@Service
public class VehicleService {
	
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

	public List<Vehicle> getVehicles(String userEmail){
		
		Long owner_id = userRepo.findIDByEmail(userEmail);
		
		Long role_id = userRepo.findROLE_IDByUSER_ID(owner_id);
		
		//return vehicleRepo.findAll();
		//return vehicleRepo.findAllNonDeleted();
		//return vehicleRepo.findAllNonDeletedOfUser(owner_id);
		
		if(role_id == 1){
			
			return vehicleRepo.findAllNonDeleted();
			
		} else {
			
			return vehicleRepo.findAllNonDeletedOfUser(owner_id);
			
		}
		
		
	}
	
	public void newVehicle(boolean deleted, String regnum, String man, vehicle_TYPE type, Integer yop, String userEmail) {
		
		User owner =  userRepo.findByEmail(userEmail);
				
		Vehicle vehicle = new Vehicle(deleted, regnum, man, type, yop, owner);
		vehicleRepo.save(vehicle);
		
	}
	
	public void updateVehicle(long vehicleid, String regnum, String man, vehicle_TYPE type, Integer yop) {
		
		Vehicle vehicle = vehicleRepo.findById(vehicleid);
		vehicle.setRegnum(regnum);
		vehicle.setMan(man);
		vehicle.setType(type);
		vehicle.setYop(yop);
		vehicleRepo.save(vehicle);
			
	}
	
	public void deleteVehicle(long vehicleid) {
		
		Vehicle vehicle = vehicleRepo.findById(vehicleid);
		vehicle.setDeleted(true);
		vehicleRepo.save(vehicle);
		
	}
	
	public long[] getIds() {
		
		long [] ids = vehicleRepo.getIds();
		return ids;
		
	}
	
}
