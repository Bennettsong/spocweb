package com.spoc.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="honor")
public class Honor
{
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	private String hid;
	private String time;
	private String img;
	private String description;
	public Honor(String hid, String time, String img, String description)
	{
		super();
		this.hid = hid;
		this.time = time;
		this.img = img;
		this.description = description;
	}
	public Honor(String hid, String time,  String description)
	{
		super();
		this.hid = hid;
		this.time = time;
		this.description = description;
	}
	public String getHid()
	{
		return hid;
	}
	public void setHid(String hid)
	{
		this.hid = hid;
	}
	public String getTime()
	{
		return time;
	}
	public void setTime(String time)
	{
		this.time = time;
	}
	public String getImg()
	{
		return img;
	}
	public void setImg(String img)
	{
		this.img = img;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public Honor()
	{
		super();
	}

}
