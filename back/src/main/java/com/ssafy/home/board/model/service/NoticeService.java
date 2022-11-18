package com.ssafy.home.board.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.home.board.model.Board;


public interface NoticeService {
	int writeArticle(Board notice) throws Exception;
	List<Board> listArticle(Board notice) throws Exception;
	Board getArticle(int articleNo) throws Exception;
	int updateHit(int articleNo) throws Exception;
	int modifyArticle(Board notice) throws Exception;
	int deleteArticle(int articleNo) throws Exception;
}
