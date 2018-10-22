package org.salem.service;

import java.util.List;

import org.salem.domain.Board;
import org.salem.domain.PageParam;

public interface BoardService {
	
	public List<Board> getList(PageParam param);
	
	public List<Board> getPureList(PageParam param);

	public int register(Board board);

	public int getTotal(PageParam param);
	
	public int getPureTotal();
	
	public Board get(PageParam param);
	
	public int remove(PageParam param);
	
	public int modify(Board board);
	
}
