package com.dyl.demo.hr.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dyl.demo.hr.dao.RoleDao;
import com.dyl.demo.hr.model.Role;
import com.dyl.demo.hr.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	
	@Resource
	private RoleDao roleDao;

	@Override
	public Role saveOrUpdate(Role role) {
		return roleDao.saveOrUpdate(role);
	}

	@Override
	public void delete(String uuid) {
		roleDao.delete(uuid);
	}

	@Override
	public Role findById(String uuid) {
		return roleDao.findById(uuid);
	}

	@Override
	public List<Role> findAll() {
		return roleDao.findAll();
	}

	@Override
	public List<Role> findAll(int curPage, int pageSize) {
		return roleDao.findAll(curPage,pageSize);
	}

}
