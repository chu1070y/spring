package org.zerock.controller;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.config.RootConfig;
import org.zerock.mapper.TimeMapper;
import org.zerock.service.SampleBean;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
public class SampleTests {

	@Setter(onMethod_ = @Autowired)
	private SampleBean bean;
	
	@Setter(onMethod_ = @Autowired)
	private DataSource ds;
	
	@Setter(onMethod_ = @Autowired)
	private TimeMapper mapper;
	
	@Test
	public void testTime() {
		log.info(mapper.getTime());
	}

	@Test
	public void testCon() {
		
		try(Connection con = ds.getConnection()){
			
			log.info(con);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testExist() {
		log.info("================");
		log.info(bean);
		log.info(bean.doA("ABCDE"));
		log.info("================");
		log.info("================");
		
	}
	
	//둘다 안들어가야 정상입니다.
	@Test
	public void testTransaction() {
		
		String str = "losing org.springframework.context.support.GenericApplicationContext@3dd4520b: startup date [Wed Nov 07 14:58:12 KST 2018]; root of context hierarchy ";
		bean.doB(str);
		
	}
	
}
