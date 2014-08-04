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

import com.dyl.demo.hr.dao.RoleDao;
import com.dyl.demo.hr.model.Role;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
public class RoleDaoTest {
	
	@Resource
	private RoleDao roleDao;
	
	@Test
	@Transactional
	public void testfind() throws Exception {
		List<Role> roleList = roleDao.findAll();
		System.out.println(roleList);
	}

}
