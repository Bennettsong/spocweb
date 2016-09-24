package com.spoc.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="group_manage")
public class Group_manage {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private int gid;
  private String name;
  private String description;
public int getGid() {
	return gid;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public void setGid(int gid) {
	this.gid = gid;
}

public Group_manage() {
	super();
}

public Group_manage(String name, String description) {
	super();
	this.name = name;
	this.description = description;
}

public Group_manage(int gid, String name, String description) {
	super();
	this.gid = gid;
	this.name = name;
	this.description = description;
}
  
  
}
