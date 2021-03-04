package com.kaev.IEscheduler.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	public String registerUser(User user) {
		
		User userCheck = userRepository.findByEmail(user.getEmail()) ;
		
		if (userCheck!=null) return "userAlreadyExists";
		
		Role userRole = roleRepository.findByRole(USER_ROLE);
/*		
		if (userRole != null) {
			user.getRoles().add(userRole);
		}else {
			user.addRoles(USER_ROLE);
		}
*/		
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		user.setActivation_key(generateActivation_Key());
		user.setEnabled(false);
		user.setLocked(true);
		userRepository.save(user);
		
		return "userRegistrated";
	}

	private String generateActivation_Key() {

		char[] activation_key = new char[30];
		
		Random random = new Random();
		
		for (int i=0; i<activation_key.length; i++) {
			
			activation_key[i]=(char) ('a' + random.nextInt(26));
			
		}
		
		return new String(activation_key);
	}

	@Override
	public String userActivation(String activation_key) {
		
		User user = userRepository.findByActivation_key(activation_key);
		
		if(user==null) return "userNotFound";
		
		user.setActivation_key("already_activated");
		user.setEnabled(true);
		userRepository.save(user);
		
		return "userActivated";
	}
	
}
