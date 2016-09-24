package com.spoc.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spoc.dao.TypeCategoryDao;
import com.spoc.po.Service_type;
import com.spoc.po.Type_category;

@Service("typeCategoryService")
public class TypeCategoryService {

	@Autowired
	private TypeCategoryDao typeCategoryDao;
	
	public void addTypeCategory(Type_category tc)
	{
		typeCategoryDao.doTypeCategory(tc);
	}
	
	public void deleteTypeCategory(String[] str)
	{
		int tcid=0;
		for(int i=0;i<str.length;i++)
		{
			tcid=Integer.valueOf(str[i]);
			typeCategoryDao.deleteTypeCategory(tcid);
		}
	}
	
	public List<Type_category> getTypes()
	{
		return typeCategoryDao.getTypes();
	}
	
	public List<Type_category> getType(String str)
	{
		return typeCategoryDao.getType(str);
	}
	
	public void update(Type_category tc)
	{
		typeCategoryDao.updateTypeCategory(tc);
	}
}
