package com.kaev.IEscheduler.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity(name="Users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false, unique=true)
	private String email;
	
	@Column(nullable=false)
	private String password;
	
	@Column
	private String activation_key;
	
	@Column(nullable=false)
	private boolean enabled;
	
	@Column(nullable=false)
	private boolean locked;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)	
	@JoinTable(
			name="users_roles",
			joinColumns={@JoinColumn(name="user_id")},
			inverseJoinColumns={@JoinColumn(name="role_id")}			
			)
	private Set<Role> roles = new HashSet<Role>();
	
	@OneToMany (mappedBy = "owner")
	private List<Vehicle> vehicles;

	//constructors
	public User() {
		super();
	}
	
	public User(String name, List<Vehicle> vehicles, String email, String password) {
		super();
		this.name = name;
		this.vehicles = vehicles;
		this.email = email;
		this.password = password;
	}

	//getters and setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getActivation_key() {
		return activation_key;
	}

	public void setActivation_key(String activation_key) {
		this.activation_key = activation_key;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", activation_key="
				+ activation_key + ", enabled=" + enabled + ", locked=" + locked + ", vehicles=" + vehicles + "]";
	}
	
	//method
/*	public void addRoles(String roleName) {
		if(this.roles==null||this.roles.isEmpty())
			this.roles=new HashSet<>();
			this.roles.add(new Role(roleName));
		}
	}
*/	
}
