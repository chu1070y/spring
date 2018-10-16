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
	
	
	// 인터페이스인데 실행이된다. 그 이유는 스프링이 인터페이스에 맞는 클래스를 만들어 낸다.
	// 인터페이스를 따로 구현해 줄 필요가 없다.
	@Test
	public void testTime() {
		log.info(mapper.getTime());
	}
	
	@Test
	public void testTime2() {
		log.info(mapper.getTime2());
	}
	
}
