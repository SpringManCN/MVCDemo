package com.dyl.demo.core.dao;

import com.dyl.demo.core.model.User;



/**
 * 用户Dao
 * @author Administrator
 *
 */
public interface UserDao extends BaseDao<User> {
	
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
