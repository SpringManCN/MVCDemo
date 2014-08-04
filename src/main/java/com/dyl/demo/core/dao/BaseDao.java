package com.dyl.demo.core.dao;

import java.util.List;

/**
 * 所有Dao方法的父类 抽取出了Dao层各个类之间共有的方法
 * 
 * @author Administrator
 * 
 * @param <T>
 */
public interface BaseDao<T> {
	/**
	 * 保存或更新方法 如果没有记录则保存，有的话就是更新
	 * 
	 * @param t
	 */
	T saveOrUpdate(T t);

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
	T findById(String uuid);

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	List<T> findAll();
	
	/**
	 * 
	 * @param curPage  	当前页数
	 * @param pageSize	每页显示多少条数据
	 * @return
	 */
	List<T> findAll(int curPage,int pageSize);
	
	
}
