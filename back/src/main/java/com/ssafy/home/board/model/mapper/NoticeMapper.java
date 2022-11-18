package com.ssafy.home.board.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.home.board.model.Board;

@Mapper
public interface NoticeMapper {
	int writeArticle(Board notice) throws SQLException;
	List<Board> listArticle(Board notice) throws SQLException;
	int totalArticleCount(Map<String, String> map) throws SQLException;
	Board getArticle(int articleNo) throws SQLException;
	int updateHit(int articleNo) throws SQLException;
	int modifyArticle(Board notice) throws SQLException;
	int deleteArticle(int articleNo) throws SQLException;
	
}
