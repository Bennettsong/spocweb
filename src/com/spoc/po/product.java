package com.spoc.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class product
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int pid;
	private String name;
	private String time;
	private String description;
	private String pro_path;
	private String img_path;
	private int flag;
	public product(int pid, String name, String time, String description,
			String pro_path, String img_path, int flag)
	{
		super();
		this.pid = pid;
		this.name = name;
		this.time = time;
		this.description = description;
		this.pro_path = pro_path;
		this.img_path = img_path;
		this.flag = flag;
	}
	public product(String name, String time, String description,
			String pro_path, String img_path, int flag)
	{
		super();
		this.name = name;
		this.time = time;
		this.description = description;
		this.pro_path = pro_path;
		this.img_path = img_path;
		this.flag = flag;
	}
	public product(String name, String time, String description,
			String img_path, int flag)
	{
		super();
		this.name = name;
		this.time = time;
		this.description = description;
		this.img_path = img_path;
		this.flag = flag;
	}
	public product()
	{
		super();
	}
	public int getPid()
	{
		return pid;
	}
	public void setPid(int pid)
	{
		this.pid = pid;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getTime()
	{
		return time;
	}
	public void setTime(String time)
	{
		this.time = time;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public String getPro_path()
	{
		return pro_path;
	}
	public void setPro_path(String pro_path)
	{
		this.pro_path = pro_path;
	}
	public String getImg_path()
	{
		return img_path;
	}
	public void setImg_path(String img_path)
	{
		this.img_path = img_path;
	}
	public int getFlag()
	{
		return flag;
	}
	public void setFlag(int flag)
	{
		this.flag = flag;
	}
	
}
