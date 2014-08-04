package com.dyl.demo.sysm.dao;

import java.util.List;

import com.dyl.demo.core.dao.BaseDao;
import com.dyl.demo.hr.model.Depart;
import com.dyl.demo.sysm.model.Menu;

public interface MenuDao extends BaseDao<Menu> {
	/**
	 * 根据上级寻找下级
	 * @return
	 */
	List<Menu> findByPid(String pid);
}
