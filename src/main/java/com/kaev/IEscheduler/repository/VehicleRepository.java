package com.kaev.IEscheduler.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.kaev.IEscheduler.domain.Vehicle;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
	
	List<Vehicle> findAll();
	
	@Query(
	value = "SELECT * FROM VEHICLES v WHERE v.DELETED = false", 
	nativeQuery = true)
	List<Vehicle> findAllNonDeleted();
	
	@Query(
	value = "SELECT * FROM VEHICLES v WHERE v.DELETED = false AND v.OWNER_ID = :owner_id", 
	nativeQuery = true)
	List<Vehicle> findAllNonDeletedOfUser(@Param("owner_id") long owner_id);
	
	@Query(
	value = "SELECT id FROM VEHICLES v WHERE v.deleted = false", 
	nativeQuery = true)
	long[] getIds();
	
	Vehicle findById(long id);
	
	Vehicle findByRegnum(String regnum);
	
}
