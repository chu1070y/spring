package org.salem.service;

import java.util.List;

import org.salem.domain.Board;
import org.salem.domain.Page;

public interface BoardService {
	
	public List<Board> getList(Page page);
	
	public Integer count();
	
	public int register(Board board);
	
}
