package com.kaev.IEscheduler.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaev.IEscheduler.domain.Event;
import com.kaev.IEscheduler.domain.User;
import com.kaev.IEscheduler.domain.Vehicle;
import com.kaev.IEscheduler.enums.service_TYPE;
import com.kaev.IEscheduler.repository.EventRepository;
import com.kaev.IEscheduler.repository.UserRepository;
import com.kaev.IEscheduler.repository.VehicleRepository;

@Service
public class EventService {

	private EventRepository eventRepo;
	private VehicleRepository vehicleRepo;
	private UserRepository userRepo;
	
	@Autowired
	public void setEventRepo(EventRepository eventRepo) {
		this.eventRepo = eventRepo;
	}
	
	@Autowired
	public void setVehicleRepo(VehicleRepository vehicleRepo) {
		this.vehicleRepo = vehicleRepo;
	}
	
	@Autowired
	public void setUserRepo(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	public List<Event> getEvents(){
		
		return eventRepo.findAll();
		
	}
	
	public void newEvent(Date date, String time, String userEmail, String selected_regnum, String selected_service, String status) {

		User user = userRepo.findByEmail(userEmail);
		Vehicle vehicle =  vehicleRepo.findByRegnum(selected_regnum);
		service_TYPE service = service_TYPE.of(selected_service);

		Event event = new Event(date, time, user, vehicle, service, status);
		eventRepo.save(event);
		
	}
	
}
