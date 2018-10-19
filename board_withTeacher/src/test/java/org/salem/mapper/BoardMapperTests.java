package org.salem.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.salem.domain.Board;
import org.salem.domain.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Test
	public void testAll() {
		
		PageParam param = new PageParam();
		param.setPage(1);
		
		log.info(mapper.getList(param));
		
		mapper.getList(param).forEach(board -> log.info(board));
		
	}
	
	@Test
	public void testInsert() {
		Board board = new Board();
		board.setTitle("가무새야 가무새야 뭐하니?");
		board.setContent("fdsafds");
		board.setWriter("까악~가악~");
		
		log.info(mapper.insert(board));
	}
	
	@Test
	public void test() {
		
		PageParam param = new PageParam();
		param.setBno(130044);
		
		log.info(mapper.get(param));
		
		
	}
	
}
