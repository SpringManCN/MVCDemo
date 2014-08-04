package com.dyl.demo.test.core.service;



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
public class UaseServiceTest {
	
	@Resource
	private UserDao userDao;
	
	@Test
	@Transactional
	public void testSave() throws Exception {
		User user = userDao.findById("1");
		user.setUserName("雅蠛蝶");
		userDao.saveOrUpdate(user);
	}

}
