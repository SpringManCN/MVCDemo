package com.dyl.demo.core.service;

import java.util.List;

import com.dyl.demo.core.model.User;

public interface UserService {
	
	/**
	 * 保存或更新方法 如果没有记录则保存，有的话就是更新
	 */
	User saveOrUpdate(User user);

	/**
	 * 删除
	 */
	void delete(String uuid);

	/**
	 * 根据ID查询
	 * @param uuuid
	 * @return
	 */
	User findById(String uuid);

	/**
	 * 查询所有
	 * @return
	 */
	List<User> findAll();

	/**
	 * 分页查询所有
	 * @param curPage
	 * @param pageSize
	 * @return
	 */
	List<User> findAll(int curPage,int pageSize);
	
	
	/**
	 * 根据用户名查找用户
	 * @param name
	 * @return
	 */
	public User findByName(String name);
	
	/**
	 * 多条件查询用户
	 * @param name
	 * @return
	 */
	public User findByUser(User user);
}
