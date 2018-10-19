package org.salem.mapper;

import java.util.List;

import org.salem.domain.Todo;

public interface TodoMapper {
	
	public int count();
	
	public List<Todo> select();
	
	public void insert(String title);
	
	public void delete(Integer tno);
	
	public void update(Todo todo);
	
}
