package com.spoc.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Affair_category")
public class Affair_category {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int acid;
	private String name;
	private int flag;
	private int rank;
	
	public Affair_category(int acid, String name, int flag, int rank) {
		super();
		this.acid = acid;
		this.name = name;
		this.flag = flag;
		this.rank = rank;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getFlag() {
		return flag;
	}
	
	public Affair_category(int acid, String name, int flag) {
		super();
		this.acid = acid;
		this.name = name;
		this.flag = flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getAcid() {
		return acid;
	}
	public void setAcid(int acid) {
		this.acid = acid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Affair_category(int acid, String name) {
		super();
		this.acid = acid;
		this.name = name;
	}
	public Affair_category() {
		super();
	}

	
	
}