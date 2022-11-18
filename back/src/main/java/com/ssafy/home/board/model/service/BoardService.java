package com.ssafy.home.board.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.home.board.model.Board;
import com.ssafy.home.board.model.BoardPara;
import com.ssafy.home.util.PageNavigation;


public interface BoardService {
	int writeArticle(Board board) throws Exception;
	List<Board> listArticle(BoardPara boardPara) throws Exception;
	PageNavigation makePageNavi(BoardPara boardPara) throws Exception;
	
	Board getArticle(int articleNo) throws Exception;
	int updateHit(int articleNo) throws Exception;
	int modifyArticle(Board board) throws Exception;
	int deleteArticle(int articleNo) throws Exception;
}
