package com.kaev.IEscheduler.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.kaev.IEscheduler.enums.vehicle_TYPE;

@Entity(name="Vehicles")
public class Vehicle {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long id;
	private boolean deleted;
	private String regnum; //registration number
	private String man; //manufacturer
	@Enumerated(EnumType.STRING)
	private vehicle_TYPE type; //type
	private Integer yop; //year of production
	@ManyToOne
	private User owner;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)	
	@JoinTable(
			name="vehicles_events",
			joinColumns={@JoinColumn(name="vehicle_id")},
			inverseJoinColumns={@JoinColumn(name="event_id")}			
			)
	private List<Event> events;

	//constructors
	public Vehicle() {
		super();
	}
	
	public Vehicle(boolean deleted, String regnum, String man, vehicle_TYPE type, Integer yop, User owner) {
		super();
		this.deleted = deleted;
		this.regnum = regnum;
		this.man = man;
		this.type = type;
		this.yop = yop;
		this.owner = owner;
	}

	//getters-setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public String getRegnum() {
		return regnum;
	}

	public void setRegnum(String regnum) {
		this.regnum = regnum;
	}

	public String getMan() {
		return man;
	}

	public void setMan(String man) {
		this.man = man;
	}

	public vehicle_TYPE getType() {
		return type;
	}

	public void setType(vehicle_TYPE type) {
		this.type = type;
	}

	public Integer getYop() {
		return yop;
	}

	public void setYop(Integer yop) {
		this.yop = yop;
	}
	
	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	//toString
	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", deleted=" + deleted + ", regnum=" + regnum + ", man=" + man + ", type=" + type + ", yop=" + yop
				+ ", owner=" + owner + "]";
	}

}
