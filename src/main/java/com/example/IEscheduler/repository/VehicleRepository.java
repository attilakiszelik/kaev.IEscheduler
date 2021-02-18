package com.example.IEscheduler.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.IEscheduler.domain.Vehicle;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {

	//List<Vehicle> findAll();
	
	@Query(
	value = "SELECT * FROM VEHICLES v WHERE v.deleted = false", 
	nativeQuery = true)
	List<Vehicle> findAllnonDeleted();
	
	Vehicle findById(long id);
	
}
