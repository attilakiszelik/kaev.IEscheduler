package com.kaev.IEscheduler.service;

import java.util.List;
import java.util.Optional;
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

	private UserRepository userRepo;
	private RoleRepository roleRepo;
	private EmailService emailService;
	private String USER_ROLE = "USER";
	
	@Autowired
	public UserServiceImpl (UserRepository userRepo,RoleRepository roleRepo) {
		this.userRepo = userRepo;
		this.roleRepo = roleRepo;
	}
	
	@Autowired	
	public void setMyEmailService(EmailService emailService) {
		this.emailService = emailService;
	}
	
	@Override
	public List<User> getLockedUsers() {
		return userRepo.findAllLocked();
	}


	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
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
		
		User userCheck = userRepo.findByEmail(user.getEmail()) ;
		
		if (userCheck!=null) return "userAlreadyExists";
		
		Role userRole = roleRepo.findByRole(USER_ROLE);
		
		if (userRole != null) {
			user.getRoles().add(userRole);
		}else {
			user.addRoles(USER_ROLE);
		}
		
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		user.setActivation_key(generateActivation_Key());
		user.setEnabled(false);
		user.setLocked(true);
		userRepo.save(user);
		
		emailService.sendRegMessage(user.getName(), user.getEmail(), user.getActivation_key());
	
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
	public String activateUser(String activation_key) {
		
		User user = userRepo.findByActivation_key(activation_key);
		
		if(user==null) return "userNotFound";
		
		user.setActivation_key("already_activated");
		user.setEnabled(true);
		userRepo.save(user);
		
		emailService.sendActMessage(user.getName(), user.getEmail());
		
		return "userActivated";
	}

	@Override
	public String unlockUser(Long userid) {

		Optional<User> optionalUser = userRepo.findById(userid);
		User user = optionalUser.get();
		
		user.setLocked(false);
		userRepo.save(user);
		
		emailService.sendUnlMessage(user.getName(), user.getEmail());
		
		return "userUnlocked";
	}

	@Override
	public String deleteUser(Long userid) {
		
		Optional<User> optionalUser = userRepo.findById(userid);
		User user = optionalUser.get();
		
		userRepo.delete(user);
		
		emailService.sendDelMessage(user.getName(), user.getEmail());
		
		return "userDeleted";
	}
	
}
