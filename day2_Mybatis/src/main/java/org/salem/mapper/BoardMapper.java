package org.salem.mapper;

import java.util.List;

import org.salem.domain.Board;
import org.salem.domain.PageParam;

public interface BoardMapper {
	
	//param이라는 방법으로 여러개의 파라미터를 mybatis에 전달할 수 있다.
	public List<Board> search(PageParam pageParam);
	
	public int searchCount(PageParam pageParam);
	
}
