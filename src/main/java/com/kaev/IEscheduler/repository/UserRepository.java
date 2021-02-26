package com.kaev.IEscheduler.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.kaev.IEscheduler.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

	List<User> findAll();
	
	User findById(long id);
	
}
