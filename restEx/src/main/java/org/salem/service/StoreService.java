package org.salem.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.salem.domain.StoreVO;
import org.springframework.stereotype.Service;

import lombok.Data;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@Data
public class StoreService {

	private List<StoreVO> list;
	
	public StoreService() {
		
		list = IntStream.range(1,10)
				.mapToObj(i -> {
					StoreVO vo = new StoreVO();
					vo.setSno(i);
					vo.setSname("가게"+i);
					
					return vo;
				}).collect(Collectors.toList());
		
	}
	
	public StoreVO get(int idx) {
		
		return list.get(idx);
	}
	
	public void remove(int idx) {
		
		list.remove(idx);
	}
	
}
