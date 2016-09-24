package com.spoc.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {

	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private int adminid;
	 private String usertype;
	 private int value;
	 
	public int getAdminid() {
		return adminid;
	}

	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Admin(String usertype, int value) {
		super();
		this.usertype = usertype;
		this.value = value;
	}

	public Admin(int adminid, String usertype, int value) {
		super();
		this.adminid = adminid;
		this.usertype = usertype;
		this.value = value;
	}

	public Admin() {
		super();
	}
	 
	 

}
