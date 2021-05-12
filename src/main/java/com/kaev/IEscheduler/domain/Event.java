package com.kaev.IEscheduler.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.kaev.IEscheduler.enums.service_TYPE;

@Entity(name="Events")
public class Event {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long id;
	private Date date;
	private String time;
	@ManyToOne
	private Vehicle vehicle;
	@Enumerated(EnumType.STRING)
	private service_TYPE service;
	
	//constructors
	public Event() {
		super();

	}
	
	public Event(Date date, String time, Vehicle vehicle, service_TYPE service) {
		super();
		this.date = date;
		this.time = time;
		this.vehicle = vehicle;
		this.service = service;
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

	//toString
	@Override
	public String toString() {
		return "Event [id=" + id + ", date=" + date + ", time=" + time + ", vehicle=" + vehicle + "]";
	}
	
}
