package com.dyl.demo.hr.service;

import java.util.List;

import com.dyl.demo.hr.model.Role;

public interface RoleService {
	/**
	 * 保存或更新方法 如果没有记录则保存，有的话就是更新
	 */
	Role saveOrUpdate(Role role);

	/**
	 * 删除
	 */
	void delete(String uuid);

	/**
	 * 根据ID查询
	 * @return
	 */
	Role findById(String uuid);

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	List<Role> findAll();
	
	/**
	 * 
	 * @param curPage  	当前页数
	 * @param pageSize	每页显示多少条数据
	 * @return
	 */
	List<Role> findAll(int curPage,int pageSize);
}
