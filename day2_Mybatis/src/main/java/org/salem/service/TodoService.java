package org.salem.service;

import java.util.List;

import org.salem.domain.StoreVO;
import org.salem.domain.Todo;

public interface TodoService {
	
	public List<Todo> getList();
	
	public List<StoreVO> getStores(String cat);
	
	public int count();

}
