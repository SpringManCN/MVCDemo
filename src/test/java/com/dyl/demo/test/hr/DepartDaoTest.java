package com.dyl.demo.test.hr;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.dyl.demo.hr.dao.DepartDao;
import com.dyl.demo.hr.model.Depart;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
public class DepartDaoTest {
	
	@Resource
	private DepartDao departDao;
	
	@Test
	@Transactional
	public void testFind() throws Exception {
		List<Depart> dList = departDao.findByPid("402881ea479ad9dc01479ae005e50000");
		System.out.println(dList);
	}
}
