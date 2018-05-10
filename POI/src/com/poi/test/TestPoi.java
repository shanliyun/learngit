package com.poi.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.poi.service.RdxbdmService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:conf/applicationContext.xml")
public class TestPoi {
	@Autowired
	private RdxbdmService rdxbdmService;
	@Test
	public void test(){
		rdxbdmService.insertDb();	
	}
}
