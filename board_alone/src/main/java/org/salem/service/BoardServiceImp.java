package org.salem.service;

import java.util.List;

import org.salem.domain.Board;
import org.salem.domain.Page;
import org.salem.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;

@Service
public class BoardServiceImp implements BoardService{
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;

	@Override
	public List<Board> getList(Page page) {
		
		return mapper.getList(page);
	}

	@Override
	public Integer count() {

		return mapper.count();
	}

	
}
