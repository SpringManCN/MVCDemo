package com.dyl.demo.hr.dao;

import java.util.List;

import com.dyl.demo.core.dao.BaseDao;
import com.dyl.demo.hr.model.Depart;

public interface DepartDao extends BaseDao<Depart> {
	/**
	 * 根据上级寻找下级
	 * @return
	 */
	List<Depart> findByPid(String pid);
}
