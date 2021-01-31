package com.example.IEscheduler.domain;

public class Vehicle {
	
	private int id;
	private String regnum; //registration number
	private String man; //manufacturer
	private String type;
	private int yop; //year of production
	private boolean deleted;
	
	//constructor
	public Vehicle() {

	}

	//getters-setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
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
				+ ", deleted=" + deleted + "]";
	}


	

}
