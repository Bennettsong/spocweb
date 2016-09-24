package com.spoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spoc.dao.HonorDao;
import com.spoc.po.Affair_category;
import com.spoc.po.Apply;
import com.spoc.po.Honor;
import com.spoc.po.Member;
import com.spoc.po.Type_category;

@Service("honorService")
public class HonorService
{
	@Autowired
	private HonorDao honordao;
	public List<Honor> getHonor()
    {
    	return honordao.getHonor();
    }
	public void updateHonor(int hid)
	{
		honordao.updateHonor(hid);
	}
	public void addHonor(Honor honor)
	{
		honordao.doHonor(honor);
	}
	public void update(Honor Hn)
	{
		honordao.updategonor(Hn);
	}
	public void deleteHonor(String[] str)
	{
		String hid;
		for(int i=0;i<str.length;i++)
		{
			hid=(str[i]);
			honordao.deleteHonor(hid);;
		}
	}
	
	
	
	
	
	

	public HonorDao getHonordao()
	{
		return honordao;
	}

	public void setHonordao(HonorDao honordao)
	{
		this.honordao = honordao;
	}

}
