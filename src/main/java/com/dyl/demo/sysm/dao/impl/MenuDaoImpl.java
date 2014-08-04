package com.dyl.demo.sysm.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.dyl.demo.core.dao.impl.BaseDaoImpl;
import com.dyl.demo.hr.model.Depart;
import com.dyl.demo.sysm.dao.MenuDao;
import com.dyl.demo.sysm.model.Menu;

@Repository
public class MenuDaoImpl extends BaseDaoImpl<Menu> implements MenuDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Menu> findByPid(String pid) {
		Query query = getSession().createQuery("FROM Menu"+
					" where pid = "+pid);//
		return query.list();
	}

}
