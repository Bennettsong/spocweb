package com.spoc.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="type_category")
public class Type_category {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int tcid;
	private String description;
	private int stid;
	public int getTcid() {
		return tcid;
	}
	public void setTcid(int tcid) {
		this.tcid = tcid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getStid() {
		return stid;
	}
	public void setStid(int stid) {
		this.stid = stid;
	}
	public Type_category(int tcid, String description, int stid) {
		super();
		this.tcid = tcid;
		this.description = description;
		this.stid = stid;
	}
	public Type_category() {
		super();
	}
	
}
