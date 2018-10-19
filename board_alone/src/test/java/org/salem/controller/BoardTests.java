package org.salem.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.salem.domain.Page;
import org.salem.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardTests {
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Test
	public void getList() {
		Page page = new Page();
		page.setPage(1);
		log.info(mapper.getList(page));
	}
	
	
	
}
