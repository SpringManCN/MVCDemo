package com.dyl.demo.test.core.dao;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.dyl.demo.core.dao.UserDao;
import com.dyl.demo.core.model.User;
import com.dyl.demo.util.MD5Util;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
public class UserDaoTest {
	
	@Resource
	private UserDao userDao;
	
	@Test
	@Transactional
	public void testFindByUser() throws Exception {
		User user =new User();
		user.setUserName("dyl");
		user.setPassword(MD5Util.MD5("dyl"));
		
		User user1 = userDao.findByUser(user);
		System.out.println(user1);
	}

}
