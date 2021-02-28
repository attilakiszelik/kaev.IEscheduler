package com.kaev.IEscheduler.service;

import com.kaev.IEscheduler.domain.User;

public interface UserService {

	public User findByEmail(String email);
	
}
