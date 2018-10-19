package org.salem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.salem.domain.Board;
import org.salem.domain.PageParam;

public interface BoardMapper {
	
	@Select("select * from tbl_board order by bno desc limit ${skip}, 10")
	public List<Board> getList(PageParam param);
	
	@Select("select * from tbl_board where bno = #{bno}")
	public Board get(PageParam param);
	
	@Insert("insert into tbl_board(title, content,writer) "
			+ "values (#{title},#{content},#{writer})")
	public int insert(Board board);
	
	@Select("select count(*) from tbl_board")
	public int count();
	
}
