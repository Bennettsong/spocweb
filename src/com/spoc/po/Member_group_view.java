package com.spoc.po;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="member_group_view")
public class Member_group_view implements Serializable{

	 @Id
	 private int lgid;
	 @Id
	 private String loginid;
	 @Id
	 private int gid;
	 @Id
	 private String name;
	public int getLgid() {
		return lgid;
	}
	public void setLgid(int lgid) {
		this.lgid = lgid;
	}
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	
	
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Member_group_view() {
		super();
	}
	 
}
