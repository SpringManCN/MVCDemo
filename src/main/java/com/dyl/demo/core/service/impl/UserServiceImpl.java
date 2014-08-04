package com.dyl.demo.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dyl.demo.core.dao.UserDao;
import com.dyl.demo.core.model.User;
import com.dyl.demo.core.service.UserService;


@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserDao userDao;

	@Override
	public User saveOrUpdate(User user) {
		return userDao.saveOrUpdate(user);
	}

	@Override
	public void delete(String uuid) {
		userDao.delete(uuid);
		
	}

	@Override
	public User findById(String uuid) {
		return userDao.findById(uuid);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public List<User> findAll(int curPage, int pageSize) {
		return userDao.findAll(curPage, pageSize);
	}

	@Override
	public User findByName(String name) {
		return userDao.findByName(name);
	}

	@Override
	public User findByUser(User user) {
		return userDao.findByUser(user);
	}
	

}
