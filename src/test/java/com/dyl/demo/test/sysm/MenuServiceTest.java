package com.dyl.demo.test.sysm;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.dyl.demo.sysm.dao.MenuDao;
import com.dyl.demo.sysm.model.Menu;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
public class MenuServiceTest {
	
	@Resource
	private MenuDao menuDao;
	
	@Test
	@Transactional
	public void testFind() throws Exception {
		List<Menu> mList = menuDao.findByPid(null);
		System.out.println(mList);
	}
}
