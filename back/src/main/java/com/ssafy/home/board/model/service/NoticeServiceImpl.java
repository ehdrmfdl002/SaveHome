package com.ssafy.home.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.home.board.model.Board;
import com.ssafy.home.board.model.mapper.NoticeMapper;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	private NoticeMapper noticeMapper;
	
	@Autowired
	public NoticeServiceImpl(NoticeMapper noticeMapper) {
		this.noticeMapper = noticeMapper;
	}

	@Override
	public int writeArticle(Board board) throws Exception {
		return noticeMapper.writeArticle(board);
	}

	@Override
	public List<Board> listArticle(Board notice) throws Exception {
		return noticeMapper.listArticle(notice);
	}

	@Override
	public Board getArticle(int articleNo) throws Exception {
		return noticeMapper.getArticle(articleNo);
	}

	@Override
	public int updateHit(int articleNo) throws Exception {
		return noticeMapper.updateHit(articleNo);
	}

	@Override
	public int modifyArticle(Board board) throws Exception {
		return noticeMapper.modifyArticle(board);
	}

	@Override
	public int deleteArticle(int articleNo) throws Exception {
		return noticeMapper.deleteArticle(articleNo);
	}

	
}
