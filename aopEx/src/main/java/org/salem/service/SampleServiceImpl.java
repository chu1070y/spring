package org.salem.service;

import org.salem.mapper.T1Mapper;
import org.salem.mapper.T2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class SampleServiceImpl implements SampleService{

	@Setter(onMethod_ = @Autowired)
	private T1Mapper t1Mapper;
	
	@Setter(onMethod_ = @Autowired)
	private T2Mapper t2Mapper;
	
	
	@Override
	public Integer doAdd(String str1, String str2) throws Exception {
		
		log.info("doAdd 메소드 실행중....");
		Thread.sleep(1000);
		
		return Integer.parseInt(str1) + Integer.parseInt(str2);
	}


	//@Transactional은 하나라도 문제가 생기면 다른 하나가 정상작동하더라도 db에 못들어가게 한다.
	@Transactional
	@Override
	public void addMulti(String str) {
		
		t1Mapper.insert(str);
		t2Mapper.insert(str);
		
	}

}
