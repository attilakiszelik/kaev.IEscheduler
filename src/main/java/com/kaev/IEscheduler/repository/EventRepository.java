package com.kaev.IEscheduler.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.kaev.IEscheduler.domain.Event;

public interface EventRepository extends CrudRepository<Event, Long>{

	List<Event> findAll();
	
}
