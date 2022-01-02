package com.kaev.IEscheduler.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.kaev.IEscheduler.domain.Event;

public interface EventRepository extends CrudRepository<Event, Long>{

	@Query(
	value = "SELECT * FROM EVENTS e WHERE e.STATUS = 'required' ", 
	nativeQuery = true)
	List<Event> findAllRequested();

	@Query(
	value = "SELECT * FROM EVENTS e WHERE e.STATUS = 'accepted' ", 
	nativeQuery = true)	
	List<Event> findAllApproved();
	
	List<Event> findAllById(Long id);
	
	Event findById(long id);
	
}
