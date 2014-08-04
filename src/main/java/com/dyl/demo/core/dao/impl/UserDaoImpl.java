package com.dyl.demo.core.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dyl.demo.core.dao.UserDao;
import com.dyl.demo.core.model.User;


/**
 * 用户Dao实现类
 * @author Administrator
 *
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	/**
	 * 根据用户名查找用户
	 */
	@Override
	public User findByName(String name) {
		//设定查询语句
		String sql = "from User where name='" + name + "'";
		try {
			//返回查询到的第一个用户
			User user = (User) getSession().createQuery(sql).list().get(0);
			System.out.println(user.getUserName());
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		
	}

	@Override
	public User findByUser(User user) {
		String sql = "from User  where 1=1";
		if (user != null) {
			if(user.getUserName()!=null&&!user.getUserName().equals("")){
				sql = sql+" and username ='"+user.getUserName()+"'";
			}if(user.getPassword()!=null&&!user.getPassword().equals("")){
				sql = sql+" and password ='"+user.getPassword()+"'";
			}
		}
		//设定查询语句
		try {
			//返回查询到的第一个用户
			@SuppressWarnings("unchecked")
			List<User> userList = getSession().createQuery(sql).list();
			if(userList.size()>0){
				return userList.get(0);
			}
			else{
				return null;
			}
			} catch (Exception e) {
				e.printStackTrace();
			return null;
		}
	}
}
