package com.spoc.po;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="member")
public class Member {

	@Id
	private String loginid;
	private String password;
	private String name;
	private String sex;
	private String img;
	private String date;
	private String college;
	private String grade;
	private String major;
	private String qq;
	private String phone;
	private String address;
	private String introduction;
	private String job;
	private int flag;
	private int adminid;
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getAdminid() {
		return adminid;
	}
	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}
	public Member(String loginid, String password, String name, String sex,
			String img, String date, String college, String grade,
			String major, String qq, String phone, String address,
			String introduction, String job, int flag, int adminid) { //学生全部信息
		super();
		this.loginid = loginid;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.img = img;
		this.date = date;
		this.college = college;
		this.grade = grade;
		this.major = major;
		this.qq = qq;
		this.phone = phone;
		this.address = address;
		this.introduction = introduction;
		this.job = job;
		this.flag = flag;
		this.adminid = adminid;
	}
	public Member() {
		super();
	}
	
	public Member(String loginid, String password, String name, String sex,
			String date, String college, String grade, String major, String qq,
			String phone, String address, String introduction, String job,
			int flag, int adminid) {  //学生信息（除照片）
		super();
		this.loginid = loginid;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.date = date;
		this.college = college;
		this.grade = grade;
		this.major = major;
		this.qq = qq;
		this.phone = phone;
		this.address = address;
		this.introduction = introduction;
		this.job = job;
		this.flag = flag;
		this.adminid = adminid;
	}
	public Member(String loginid, String password, String name, String sex,
			String img, String date, String college, String qq, String phone,
			String address, int flag, int adminid) {  //老师全部信息
		super();
		this.loginid = loginid;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.img = img;
		this.date = date;
		this.college = college;
		this.qq = qq;
		this.phone = phone;
		this.address = address;
		this.flag = flag;
		this.adminid = adminid;
		
	}
	
	public Member(int i,String loginid, String password, String name, String sex,
			String img, String date, String college, String grade,
			String major, String qq, String phone, String address, String job,
			int flag, int adminid) {
		super();
		this.loginid = loginid;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.img = img;
		this.date = date;
		this.college = college;
		this.grade = grade;
		this.major = major;
		this.qq = qq;
		this.phone = phone;
		this.address = address;
		this.job = job;
		this.flag = flag;
		this.adminid = adminid;
	}
	
	public Member(String loginid, String password, String name, String sex,
			String img, String date, String college, String grade,
			String major, String qq, String phone, String address,
			String introduction, int flag, int adminid,int i) {
		super();
		this.loginid = loginid;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.img = img;
		this.date = date;
		this.college = college;
		this.grade = grade;
		this.major = major;
		this.qq = qq;
		this.phone = phone;
		this.address = address;
		this.introduction = introduction;
		this.flag = flag;
		this.adminid = adminid;
	}
	
	public Member(int i,String loginid, String password, String name, String sex,
			String date, String college, String grade, String major, String qq,
			String phone, String address, String job, int flag, int adminid) {
		super();
		this.loginid = loginid;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.date = date;
		this.college = college;
		this.grade = grade;
		this.major = major;
		this.qq = qq;
		this.phone = phone;
		this.address = address;
		this.job = job;
		this.flag = flag;
		this.adminid = adminid;
	}
	
	public Member(String loginid, String password, String name, String sex,
			String date, String college, String grade, String major, String qq,
			String phone, String address, String introduction, int flag,
			int adminid,int i) {
		super();
		this.loginid = loginid;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.date = date;
		this.college = college;
		this.grade = grade;
		this.major = major;
		this.qq = qq;
		this.phone = phone;
		this.address = address;
		this.introduction = introduction;
		this.flag = flag;
		this.adminid = adminid;
	}
	public Member(String loginid, String password, String name, String sex,
			String date, String college, String grade, String major, String qq,
			String phone, String address, int flag, int adminid) {
		super();
		this.loginid = loginid;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.date = date;
		this.college = college;
		this.grade = grade;
		this.major = major;
		this.qq = qq;
		this.phone = phone;
		this.address = address;
		this.flag = flag;
		this.adminid = adminid;
	}
	public Member(String loginid, String password, String name, String sex,
			String img, String date, String college, String grade,
			String major, String qq, String phone, String address, int flag,
			int adminid) {
		super();
		this.loginid = loginid;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.img = img;
		this.date = date;
		this.college = college;
		this.grade = grade;
		this.major = major;
		this.qq = qq;
		this.phone = phone;
		this.address = address;
		this.flag = flag;
		this.adminid = adminid;
	}
	public Member(String loginid, String password, String name, String sex,
			String date, String college, String qq, String phone,
			String address, int flag, int adminid) {  //老师信息（除了照片）
		super();
		this.loginid = loginid;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.date = date;
		this.college = college;
		this.qq = qq;
		this.phone = phone;
		this.address = address;
		this.flag = flag;
		this.adminid = adminid;
	}
	
	
	
	
	
}
