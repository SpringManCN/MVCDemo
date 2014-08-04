package com.dyl.demo.hr.service;

import java.util.List;

import com.dyl.demo.hr.model.Depart;

public interface DepartService {
	/**
	 * 保存或更新方法 如果没有记录则保存，有的话就是更新
	 */
	Depart saveOrUpdate(Depart depart);

	/**
	 * 删除
	 */
	void delete(String uuid);

	/**
	 * 根据ID查询
	 * @return
	 */
	Depart findById(String uuid);

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	List<Depart> findAll();
	
	/**
	 * 
	 * @param curPage  	当前页数
	 * @param pageSize	每页显示多少条数据
	 * @return
	 */
	List<Depart> findAll(int curPage,int pageSize);
	
	/**
	 * 根据上级寻找下级
	 * @return
	 */
	List<Depart> findByPid(String pid);

}
