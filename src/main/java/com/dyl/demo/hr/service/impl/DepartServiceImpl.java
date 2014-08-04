package com.dyl.demo.hr.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dyl.demo.hr.dao.DepartDao;
import com.dyl.demo.hr.model.Depart;
import com.dyl.demo.hr.service.DepartService;

@Service
@Transactional
public class DepartServiceImpl implements DepartService {
	
	@Resource
	private DepartDao departDao;

	@Override
	public Depart saveOrUpdate(Depart depart) {
		return departDao.saveOrUpdate(depart);
	}

	@Override
	public void delete(String uuid) {
		departDao.delete(uuid);
	}

	@Override
	public Depart findById(String uuid) {
		return departDao.findById(uuid);
	}

	@Override
	public List<Depart> findAll() {
		return departDao.findAll();
	}

	@Override
	public List<Depart> findAll(int curPage, int pageSize) {
		return departDao.findAll(curPage,pageSize);
	}

	@Override
	public List<Depart> findByPid(String pid) {
		return departDao.findByPid(pid);
	}

}
