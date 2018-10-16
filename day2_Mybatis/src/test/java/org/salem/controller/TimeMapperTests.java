package org.salem.controller;

import org.junit.Test;
import org.salem.mapper.TimeMapper;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
public class TimeMapperTests extends AbstractTests{

	@Setter(onMethod_=@Autowired)
	private TimeMapper mapper;
	
	
	// �������̽��ε� �����̵ȴ�. �� ������ �������� �������̽��� �´� Ŭ������ ����� ����.
	// �������̽��� ���� ������ �� �ʿ䰡 ����.
	@Test
	public void testTime() {
		log.info(mapper.getTime());
	}
	
	@Test
	public void testTime2() {
		log.info(mapper.getTime2());
	}
	
}
