package com.kaev.IEscheduler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kaev.IEscheduler.domain.Role;
import com.kaev.IEscheduler.domain.User;
import com.kaev.IEscheduler.repository.RoleRepository;
import com.kaev.IEscheduler.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService, UserDetailsService{

	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private final String USER_ROLE = "USER";
	
	@Autowired
	public UserServiceImpl (UserRepository userRepository,RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}
	
	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		User user = findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		return new UserDetailsImpl(user);
	}

	@Override
	public void registerUser(User user) {
		Role userRole = roleRepository.findByRole(USER_ROLE);
/*		
		if (userRole != null) {
			user.getRoles().add(userRole);
		}else {
			user.addRoles(USER_ROLE);
		}
*/		
		User u = userRepository.save(user);
	}
	
}
