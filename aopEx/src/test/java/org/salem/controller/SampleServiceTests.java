package org.salem.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.salem.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Log4j
public class SampleServiceTests {

	@Setter(onMethod_ = @Autowired)
	private SampleService service;
	
	@Test
	public void testMulti() {
		
		String str = "11나나나나나나나나나나쏴아나나나나나나나나나나쏴아나나나나나나나나나나쏴아나나나나나나나나나나쏴아나나나나나나나나나나쏴아";
		
		service.addMulti(str);
		
	}
	
	@Test
	public void testAdd()throws Exception {
		
		log.info(service.getClass().getName());
		
		log.info("RESULT: " + service.doAdd("123", "100"));
		
		//메소드 실행 자체를 막아버린다.
//		log.info("RESULT: " + service.doAdd("123", null));
	}
	
	
}
