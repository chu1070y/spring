package org.salem.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import org.salem.domain.StoreVO;
import org.salem.domain.Todo;
import org.salem.mapper.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;

@Service
public class TodoServiceImpl implements TodoService{
	
	private Map<String, List<StoreVO>> storeMap;
	
	@Setter(onMethod_=@Autowired)
	private TodoMapper mapper;
	
	public TodoServiceImpl() {
		storeMap = new HashMap<>();
		
		List<StoreVO> korList = new ArrayList<>();
		korList.add(new StoreVO(1,"청진식당"));
		korList.add(new StoreVO(2,"뚝배기집"));
		korList.add(new StoreVO(3,"부민옥"));
		korList.add(new StoreVO(4,"종로분식"));
		
		storeMap.put("kor", korList);
		
		List<StoreVO> jpList = new ArrayList<>();
		jpList.add(new StoreVO(1,"신주쿠카레"));
		jpList.add(new StoreVO(2,"이춘복참치"));
		jpList.add(new StoreVO(3,"가쓰야"));
		jpList.add(new StoreVO(4,"갓덴스시"));
		
		storeMap.put("jp", jpList);
		
	}
	
	@Override
	public List<Todo> getList() {

		return mapper.select();
	}

	@Override
	public List<StoreVO> getStores(String cat) {
		return storeMap.get(cat);
	}

	@Override
	public int count() {
		return mapper.count();
	}


	

}
