package com.spoc.service;

import java.io.File;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spoc.dao.MemberDao;
import com.spoc.dao.Member_groupDao;
import com.spoc.po.Member;


@Service("memberService")
public class MemberService {

	@Autowired
	private MemberDao memberDao;
	@Autowired
	private Member_groupDao member_groupDao;
	
	public boolean checkLoginid(String loginid)
	{
		return memberDao.checkLoginid(loginid);
	}
	
	public List<Member> getStudents()
	{
		
	   return memberDao.getStudents();
	}
	
	public List<Member> getTeachers()
	{
		
	   return memberDao.getTeachers();
	}
	
	public List<Member> getMember(String membername,int flag)
	{
		Member member=new Member();
		member.setName(membername);
		member.setFlag(flag);
		
		return memberDao.getMember(member);
		
		
	}
	
	public void deleteMembers(String[] str,String path)
	{
	   Member member=null;
		for(int i=0;i<str.length;i++)
		{
			member=new Member();
			member.setLoginid(str[i]);			
			member_groupDao.deleteMember(str[i]);
			
			Member mb=memberDao.getMember(str[i]);
			String relativePath=mb.getImg();
			relativePath=relativePath.substring(2);
			File file=new File(path+relativePath);			
			file.delete(); 			
			memberDao.deleteMember(member);	
			
		}
	}
	
	public Member getUniqueMember(String loginid)
	{
		return memberDao.getMember(loginid);
	}
	
	public void addMember(Member member)
	{
		memberDao.doMember(member);
	}
	
	public void updateMember(Member member,String hide)
	{
		memberDao.updateMember(member,hide);
	}
	
	public void updateMember2(Member member,String hide)
	{
		Member memberFormal=memberDao.getMember(hide);
		member.setImg(memberFormal.getImg());
		memberDao.updateMember(member,hide);
	}
}
