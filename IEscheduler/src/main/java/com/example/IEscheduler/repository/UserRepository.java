package com.example.IEscheduler.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.example.IEscheduler.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

	List<User> findAll();
	
}
