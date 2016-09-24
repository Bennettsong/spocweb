package com.spoc.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="member_product")
public class member_product
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int lpid;
	private int pid;
	private String student;
	private String teacher;
	public member_product(int lpid, int pid, String student, String teacher)
	{
		super();
		this.lpid = lpid;
		this.pid = pid;
		this.student = student;
		this.teacher = teacher;
	}
	public member_product(int pid, String student, String teacher)
	{
		super();
		this.pid = pid;
		this.student = student;
		this.teacher = teacher;
	}
	public member_product()
	{
		super();
	}
	public int getLpid()
	{
		return lpid;
	}
	public void setLpid(int lpid)
	{
		this.lpid = lpid;
	}
	public int getPid()
	{
		return pid;
	}
	public void setPid(int pid)
	{
		this.pid = pid;
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
	
}
