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

//����:Public Key Retrieval is not allowed
//�� ������ mysql�� ��ȣ�� ��ȣȭ�ȵǾ� �־ �߻��ϴ� ����.
