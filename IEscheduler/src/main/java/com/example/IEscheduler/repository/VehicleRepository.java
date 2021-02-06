package com.example.IEscheduler.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.example.IEscheduler.domain.Vehicle;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {

	List<Vehicle> findAll();
	
}
