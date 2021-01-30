package com.example.IEscheduler.domain;

public class Vehicles {
	
	private int id;
	private String regnum; //registration number
	private String man; //manufacturer
	private String type;
	private String yop; //year of production
	
	//constructor
	public Vehicles() {

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

	public String getYop() {
		return yop;
	}

	public void setYop(String yop) {
		this.yop = yop;
	}

	//toString
	@Override
	public String toString() {
		return "Vehicles [id=" + id + ", regnum=" + regnum + ", man=" + man + ", type=" + type + ", yop=" + yop + "]";
	}
	

}
