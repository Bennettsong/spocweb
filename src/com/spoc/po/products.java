package com.spoc.po;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="products")
public class products implements Serializable
{
	@Id
	private int lpid;
	@Id
	private int pid;
	@Id
	private String name;
	@Id
	private String description;
	@Id
	private String time;
	@Id
	private String student;
	@Id
	private String teacher;
	@Id
	private String pro_path;
	@Id
	private String img_path;
	@Id
	private int flag;
	
	public int getPid()
	{
		return pid;
	}
	public void setPid(int pid)
	{
		this.pid = pid;
	}
	
	public String getTime()
	{
		return time;
	}
	public void setTime(String time)
	{
		this.time = time;
	}	
	public products()
	{
		super();
	}
	public products(int lpid, int pid, String name, String description,
			String time, String student, String teacher, String pro_path,
			String img_path, int flag)
	{
		super();
		this.lpid = lpid;
		this.pid = pid;
		this.name = name;
		this.description = description;
		this.time = time;
		this.student = student;
		this.teacher = teacher;
		this.pro_path = pro_path;
		this.img_path = img_path;
		this.flag = flag;
	}		
	public String getImg_path()
	{
		return img_path;
	}
	public void setImg_path(String img_path)
	{
		this.img_path = img_path;
	}
	public int getLpid()
	{
		return lpid;
	}
	public void setLpid(int lpid)
	{
		this.lpid = lpid;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public String getStudent()
	{
		return student;
	}
	public void setStudent(String student)
	{
		this.student = student;
	}
	public String getTeacher()
	{
		return teacher;
	}
	public void setTeacher(String teacher)
	{
		this.teacher = teacher;
	}
	public String getPro_path()
	{
		return pro_path;
	}
	public void setPro_path(String pro_path)
	{
		this.pro_path = pro_path;
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
