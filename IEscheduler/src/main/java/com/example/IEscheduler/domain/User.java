package com.example.IEscheduler.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

	@GeneratedValue
	@Id
	private long id;
	private String name;
	@OneToMany (mappedBy = "owner")
	private List<Vehicle> vehicles;

	//constructor
	private User() {
	
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

	//toString
	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + "]";
	}
	
}
