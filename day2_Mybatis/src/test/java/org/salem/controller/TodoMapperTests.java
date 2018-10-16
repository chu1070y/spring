package org.salem.controller;

import org.junit.Test;
import org.salem.domain.Todo;
import org.salem.mapper.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

//AbstractTests 꼭 상속받아야함!
@Log4j
public class TodoMapperTests extends AbstractTests{

	@Setter(onMethod_=@Autowired)
	private TodoMapper todo;
	
	@Test
	public void testSelect(){
		log.info(todo.select());
	}
	
	@Test
	public void testInsert() {
		todo.insert("7시에는 집 가고싶다!");
	}
	
	@Test
	public void testDelete() {
		todo.delete(9);
	}
	
	@Test
	public void testUpdate() {
		Todo vo = todo.select().get(0);
		vo.setTitle("헤이 요~");
		todo.update(vo);
	}
	
}
