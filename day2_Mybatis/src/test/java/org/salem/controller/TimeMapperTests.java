package org.salem.controller;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.salem.domain.PageParam;
import org.salem.mapper.BoardMapper;
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
	
	
	@Setter(onMethod_=@Autowired)
	private BoardMapper boardMapper;
	
	@Test
	public void testSearch() {
		
		PageParam pageParam = new PageParam();
		
		pageParam.setTypes(new String[] {"t","c"});
		
		pageParam.setKeyword("sample");
		
		log.info(boardMapper.search(pageParam));
		log.info(boardMapper.searchCount(pageParam));
	}
	
	
}
