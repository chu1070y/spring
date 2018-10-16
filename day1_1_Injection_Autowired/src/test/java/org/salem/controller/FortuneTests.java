package org.salem.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.salem.ui.FortuneUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class FortuneTests {
	
	@Autowired
	private FortuneUI ui;
	
	@Test
	public void test() {
		ui.start();
	}
	
}

//에러:Public Key Retrieval is not allowed
//이 에러는 mysql의 암호가 암호화안되어 있어서 발생하는 경우다.
