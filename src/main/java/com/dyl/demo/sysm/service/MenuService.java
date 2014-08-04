package com.dyl.demo.sysm.service;

import java.util.List;

import com.dyl.demo.sysm.model.Menu;

public interface MenuService {
	
	/**
	 * 保存或更新方法 如果没有记录则保存，有的话就是更新
	 * 
	 * @param t
	 */
	Menu saveOrUpdate(Menu menu);

	/**
	 * 删除
	 * 
	 * @param t
	 */
	void delete(String uuid);

	/**
	 * 根据ID查询
	 * 
	 * @param id
	 * @return
	 */
	Menu findById(String uuid);

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	List<Menu> findAll();
	
	/**
	 * 
	 * @param curPage  	当前页数
	 * @param pageSize	每页显示多少条数据
	 * @return
	 */
	List<Menu> findAll(int curPage,int pageSize);
	
	/**
	 * 根据上级寻找下级
	 * @return
	 */
	List<Menu> findByPid(String pid);

}
