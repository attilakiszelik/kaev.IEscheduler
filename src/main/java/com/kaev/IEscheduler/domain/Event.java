package com.kaev.IEscheduler.domain;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Events")
public class Event {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long id;
	private Date date;
	private Time time;
	private Vehicle vehicle;
	
	//constructors
	public Event() {
		super();

	}
	
	public Event(long id, Date date, Time time, Vehicle vehicle) {
		super();
		this.id = id;
		this.date = date;
		this.time = time;
		this.vehicle = vehicle;
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

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	//toString
	@Override
	public String toString() {
		return "Event [id=" + id + ", date=" + date + ", time=" + time + ", vehicle=" + vehicle + "]";
	}
	
}
