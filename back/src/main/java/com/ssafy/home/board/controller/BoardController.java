package com.ssafy.home.board.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.home.board.model.Board;
import com.ssafy.home.board.model.BoardPara;
import com.ssafy.home.board.model.service.BoardService;

@CrossOrigin("*")
@RestController
@RequestMapping("/board")
public class BoardController {
	
	private final Logger logger = LoggerFactory.getLogger(BoardController.class);
	private BoardService boardService;

	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@GetMapping
	private ResponseEntity<List<Board>> getBoardlist(BoardPara boardPara) throws Exception {
		logger.info("listArticle - 호출");
		return new ResponseEntity<>(boardService.listArticle(boardPara), HttpStatus.OK);
	}
	
	@GetMapping("/{articleNo}")
	private ResponseEntity<Board> getNoticeview(@PathVariable int articleNo) throws Exception {
		logger.info("getArticle - 호출 : " + articleNo);
		boardService.updateHit(articleNo);
		return new ResponseEntity<>(boardService.getArticle(articleNo), HttpStatus.OK);
	}

	@PostMapping
	private ResponseEntity<?> write(@RequestBody Board board) throws Exception {
		logger.info("writeArticle - 호출");
		System.out.println(board);
		return new ResponseEntity<>(boardService.writeArticle(board), HttpStatus.OK);
	}

	@PutMapping("/{articleNo}")
	private ResponseEntity<?> Modify(@PathVariable int articleNo, @RequestBody Board board) throws Exception {
		logger.info("modifyArticle - 호출 {}", board);
		board.setArticleNo(articleNo);
		return new ResponseEntity<> (boardService.modifyArticle(board), HttpStatus.OK);
	}
	
	@DeleteMapping("/{articleNo}")
	private ResponseEntity<Integer> delete(@PathVariable int articleNo) throws Exception {
		logger.info("deleteArticle - 호출");
		Board tmp = boardService.getArticle(articleNo);
		return new ResponseEntity<>(boardService.deleteArticle(articleNo), HttpStatus.OK);
	}
}
