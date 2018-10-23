package org.salem.mapper;

import java.util.List;

import org.salem.domain.Board;
import org.salem.domain.Page;

public interface BoardMapper {
	
	public List<Board> getList(Page page);
	
	public Integer count();
	
	public int register(Board board);
}
