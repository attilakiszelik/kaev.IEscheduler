package com.kaev.IEscheduler.service;

import com.kaev.IEscheduler.domain.User;

public interface UserService {

	public User findByEmail(String email);

	public String registerUser(User user);

	public String activateUser(String activation_key);
	
	public String unlockUser(Long id);

	public String deleteUser(Long id);
	
}
