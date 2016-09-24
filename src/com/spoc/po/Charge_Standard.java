package com.spoc.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="charge_standard")
public class Charge_Standard {

	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private int csid;
	 private String basic;
	 private String advance;
	 private String careless;
	 private int acid;
	 private int tcid;
	public int getCsid() {
		return csid;
	}
	public void setCsid(int csid) {
		this.csid = csid;
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
	public int getAcid() {
		return acid;
	}
	public void setAcid(int acid) {
		this.acid = acid;
	}
	public int getTcid() {
		return tcid;
	}
	public void setTcid(int tcid) {
		this.tcid = tcid;
	}
	public Charge_Standard(String basic, String advance, String careless,
			int acid, int tcid) {
		super();
		this.basic = basic;
		this.advance = advance;
		this.careless = careless;
		this.acid = acid;
		this.tcid = tcid;
	}
	public Charge_Standard() {
		super();
	}
	public Charge_Standard(int csid, String basic, String advance,
			String careless, int acid, int tcid) {
		super();
		this.csid = csid;
		this.basic = basic;
		this.advance = advance;
		this.careless = careless;
		this.acid = acid;
		this.tcid = tcid;
	}
	 
	 
}
