package com.ssafy.home.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.home.board.model.Board;
import com.ssafy.home.board.model.BoardPara;
import com.ssafy.home.board.model.mapper.BoardMapper;
import com.ssafy.home.util.PageNavigation;

@Service
public class BoardServiceImpl implements BoardService {
	
	private BoardMapper boardMapper;
	
	@Autowired
	public BoardServiceImpl (BoardMapper boardMapper) {
		this.boardMapper = boardMapper;
	}

	@Override
	public int writeArticle(Board board) throws Exception {
		return boardMapper.writeArticle(board);
	}

	@Override
	public List<Board> listArticle(BoardPara boardPara) throws Exception {
		int start = boardPara.getPg() == 0 ? 0 : (boardPara.getPg() - 1) * boardPara.getSpp();
		boardPara.setStart(start);
		return boardMapper.listArticle(boardPara);
	}

	@Override
	public Board getArticle(int articleNo) throws Exception {
		return boardMapper.getArticle(articleNo);
	}

	@Override
	public int updateHit(int articleNo) throws Exception {
		return boardMapper.updateHit(articleNo);
	}

	@Override
	public int modifyArticle(Board board) throws Exception {
		return boardMapper.modifyArticle(board);
	}

	@Override
	public int deleteArticle(int articleNo) throws Exception {
		return boardMapper.deleteArticle(articleNo);
	}

	@Override
	public PageNavigation makePageNavi(BoardPara boardPara) throws Exception {
		int size = 5;
		PageNavigation pageNavigation = new PageNavigation();
		pageNavigation.setCurrentPage(boardPara.getPg());
		pageNavigation.setNaviSize(size);
		int totalCount = boardMapper.getTotalCount(boardPara);
		pageNavigation.setTotalCount(totalCount);  
		int totalPageCount = (totalCount - 1) / boardPara.getSpp() + 1;//27
		pageNavigation.setTotalPageCount(totalPageCount);
		boolean startRange = boardPara.getPg() <= size;
		pageNavigation.setStartRange(startRange);
		boolean endRange = (totalPageCount - 1) / size * size < boardPara.getPg();
		pageNavigation.setEndRange(endRange);
		pageNavigation.makeNavigator();
		return pageNavigation;
	}


	
}
