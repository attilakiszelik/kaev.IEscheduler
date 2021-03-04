package com.kaev.IEscheduler.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.kaev.IEscheduler.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

	List<User> findAll();
	
	User findById(long id);
	
	User findByEmail(String email);

	@Query(
	value = "SELECT * FROM USERS u WHERE u.activation_key = :activation_key", 
	nativeQuery = true)
	User findByActivation_key(@Param("activation_key") String activation_key);
	
}
