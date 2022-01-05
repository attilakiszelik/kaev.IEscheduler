package com.kaev.IEscheduler.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kaev.IEscheduler.enums.service_TYPE;

@Entity(name="Events")
public class Event implements Serializable{

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long id;
	private Date date;
	private String time;
	@ManyToOne
	private User user;
	@ManyToOne
	@JsonIgnore
	private Vehicle vehicle;
	@Enumerated(EnumType.STRING)
	private service_TYPE service;
	private String status;
	
	//transient properties
	@Transient
	private transient String selectedRegnum;
	@Transient
	private transient String selectedService;

	//constructors
	public Event() {
		super();

	}
	
	public Event(Date date, String time, User user, Vehicle vehicle, service_TYPE service, String status) {
		super();
		this.date = date;
		this.time = time;
		this.user = user;
		this.vehicle = vehicle;
		this.service = service;
		this.status = status;
	}

	//getters and setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public service_TYPE getService() {
		return service;
	}

	public void setService(service_TYPE service) {
		this.service = service;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	//transient properties's getters and setters
	public String getSelectedRegnum() {
		return selectedRegnum;
	}

	public void setSelectedRegnum(String selectedRegnum) {
		this.selectedRegnum = selectedRegnum;
	}
	
	public String getSelectedService() {
		return selectedService;
	}

	public void setSelectedService(String selectedService) {
		this.selectedService = selectedService;
	}

	//toString
	@Override
	public String toString() {
		return "Event [id=" + id + ", date=" + date + ", time=" + time + ", user=" + user + ", vehicle=" + vehicle
				+ ", service=" + service + ", status=" + status + "]";
	}
	
}
