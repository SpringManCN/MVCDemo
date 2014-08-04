package com.dyl.demo.core.dao.impl;


import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.dyl.demo.core.dao.BaseDao;




/**
 * BaseDao实现类
 * 
 * @author Administrator
 * 
 * @param <T>
 */
@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements BaseDao<T> {
	// log4j日志
	private Log log = LogFactory.getLog(this.getClass());

	@Resource
	private SessionFactory sessionFactory;
	private Class<T> clazz;

	public BaseDaoImpl() {
		// 使用反射技术得到T的真实类型
		ParameterizedType pt = (ParameterizedType) this.getClass()
				.getGenericSuperclass(); // 获取当前new的对象的 泛型的父类 类型
		this.clazz = (Class<T>) pt.getActualTypeArguments()[0]; // 获取第一个类型参数的真实类型
		log.info("clazz ---> " + clazz);
	}

	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public T saveOrUpdate(T t) {
		getSession().saveOrUpdate(t);
		return t;

	}

	@Override
	public void delete(String uuid) {
		Object obj = findById(uuid);
		getSession().delete(obj);

	}

	@Override
	public T findById(String uuid) {
		return (T) getSession().get(clazz, uuid);
	}

	@Override
	public List<T> findAll() {
		return getSession().createQuery(//
				"FROM " + clazz.getSimpleName())//
				.list();
	}

	@Override
	public List<T> findAll(int curPage, int pageSize) {
		Query query=getSession().createQuery("FROM " + clazz.getSimpleName());
		// 分页
		if (curPage != 0 && pageSize != 0) {
			query.setFirstResult((curPage - 1) * pageSize);
			query.setMaxResults(pageSize);
		}
		return query.list();
	}

	
	
    

}
