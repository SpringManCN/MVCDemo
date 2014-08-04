package com.dyl.demo.sysm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dyl.demo.sysm.dao.MenuDao;
import com.dyl.demo.sysm.model.Menu;
import com.dyl.demo.sysm.service.MenuService;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {
	
	@Resource
	private MenuDao menuDao;

	@Override
	public Menu saveOrUpdate(Menu menu) {
		return menuDao.saveOrUpdate(menu);
	}

	@Override
	public void delete(String uuid) {
		menuDao.delete(uuid);
	}

	@Override
	public Menu findById(String uuid) {
		return menuDao.findById(uuid);
	}

	@Override
	public List<Menu> findAll() {
		return menuDao.findAll();
	}

	@Override
	public List<Menu> findAll(int curPage, int pageSize) {
		return menuDao.findAll(curPage, pageSize);
	}

	@Override
	public List<Menu> findByPid(String pid) {
		return menuDao.findByPid(pid);
	}

}
