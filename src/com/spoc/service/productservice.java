package com.spoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spoc.dao.productdao;
import com.spoc.dao.productsdao;
import com.spoc.po.member_product;
import com.spoc.po.product;

@Service("productservice")
public class productservice
{
	@Autowired
	private productdao prodao;
	@Autowired
	private productsdao prosdao;
	public List<product> getpath()
	{
		return prodao.getpath();
	}
	public List<product> getProducts()
	{
		return prodao.getproducts();
	}
	public void deleteproducts(int[] str)
	{
		product pr=null;
		for(int i=0;i<str.length;i++)
		{
			pr=new product();
			pr.setPid(str[i]);
			prodao.deleteproducts(pr);
			prosdao.deleteproducts(str[i]);
		}
	}
	public void updateproducts(product pr,member_product mpr)
	{
		prodao.updateproducts(pr);
		prosdao.updateproducts(mpr);
	}
	public product getproduct(int pid)
	{
		return prodao.getproduct(pid);
	}
	public member_product getproducts(int pid)
	{
		return prosdao.getproducts(pid);
	}
	public int addproduct(product pr)
	{
		int pid=prodao.addproduct(pr);
		return pid;
	}
	public void addmember_product(member_product mpr)
	{
		prosdao.addmember_product(mpr);
	}
}
