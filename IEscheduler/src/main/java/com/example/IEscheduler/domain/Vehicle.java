package com.example.IEscheduler.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Vehicle {
	
	@GeneratedValue
	@Id
	private long id;
	private String regnum; //registration number
	private String man; //manufacturer
	private String type; //type
	private int yop; //year of production
	@ManyToOne
	private User owner;
	private boolean deleted;
	
	//constructor
	private Vehicle() {

	}

	//getters-setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getYop() {
		return yop;
	}

	public void setYop(int yop) {
		this.yop = yop;
	}
	
	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	//toString
	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", regnum=" + regnum + ", man=" + man + ", type=" + type + ", yop=" + yop
				+ ", owner=" + owner + ", deleted=" + deleted + "]";
	}

}
