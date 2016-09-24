package com.spoc.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="member_group")
public class Member_group {

	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private int lgid;
	 private String loginid;
	 private int gid;
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
	public Member_group(int lgid, String loginid, int gid) {
		super();
		this.lgid = lgid;
		this.loginid = loginid;
		this.gid = gid;
	}
	public Member_group() {
		super();
	}
	 
}
