package com.kaev.IEscheduler.repository;

import org.springframework.data.repository.CrudRepository;
import com.kaev.IEscheduler.domain.Role;

public interface RoleRepository extends CrudRepository<Role, Long>{
	
	Role findByRole(String Role);

}
