package com.spoc.po;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="affairs")
public class Affairs implements Serializable {
	
	@Id
	private String name;
	@Id
	private String type;
	@Id
	private String description;
	@Id
	private String basic;
	@Id
	private String advance;
	@Id
	private String careless;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBasic() {
		return basic;
	}
	public void setBasic(String basic) {
		this.basic = basic;
	}
	public String getAdvance() {
		return advance;
	}
	public void setAdvance(String advance) {
		this.advance = advance;
	}
	public String getCareless() {
		return careless;
	}
	public void setCareless(String careless) {
		this.careless = careless;
	}
	public Affairs(String name, String type, String description,
			String basic, String advance, String careless) {
		super();
		this.name = name;
		this.type = type;
		this.description = description;
		this.basic = basic;
		this.advance = advance;
		this.careless = careless;
	}
	public Affairs() {
		super();
	}
	
	
}
