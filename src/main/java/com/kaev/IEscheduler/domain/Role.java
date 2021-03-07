package com.kaev.IEscheduler.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name="roles")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable=false)
	private String role;
	
	@ManyToMany (mappedBy = "roles")
	private Set<User> users = new HashSet<User>();

	//constructor
	public Role() {
		super();
	}
	
	public Role(String roleName) {
		super();
	}

	//getters and setters	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	//toString	
	@Override
	public String toString() {
		return "Role [id=" + id + ", role=" + role + ", users=" + users + "]";
	}
	
}
