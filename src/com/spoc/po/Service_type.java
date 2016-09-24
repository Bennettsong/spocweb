package com.spoc.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="service_type")
public class Service_type {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int stid;
	private String type;
	public int getStid() {
		return stid;
	}
	public void setStid(int stid) {
		this.stid = stid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Service_type(int stid, String type) {
		super();
		this.stid = stid;
		this.type = type;
	}
	public Service_type() {
		super();
	}
	
}
