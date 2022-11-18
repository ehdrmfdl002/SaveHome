package com.ssafy.home.board.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.home.board.model.Board;
import com.ssafy.home.board.model.BoardPara;

@Mapper
public interface BoardMapper {
	int writeArticle(Board board) throws SQLException;
	List<Board> listArticle(BoardPara boardPara) throws SQLException;
	Board getArticle(int articleNo) throws SQLException;
	int updateHit(int articleNo) throws SQLException;
	int modifyArticle(Board board) throws SQLException;
	int deleteArticle(int articleNo) throws SQLException;	
	public int getTotalCount(BoardPara boardPara) throws SQLException;
}
