package com.dyl.demo.hr.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.dyl.demo.core.dao.impl.BaseDaoImpl;
import com.dyl.demo.hr.dao.DepartDao;
import com.dyl.demo.hr.model.Depart;

@Repository
public class DepartDaoImpl extends BaseDaoImpl<Depart> implements DepartDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Depart> findByPid(String pid) {
		if(pid==null){
			Query query = getSession().createQuery("FROM Depart"+
					" where pid = "+pid);//
			return query.list();
		}else{
			Query query = getSession().createQuery("FROM Depart"+
					" where pid = '"+pid+"'");//
			return query.list();
		}
		
		
	}

}
