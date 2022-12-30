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
import com.ssafy.home.board.model.service.NoticeService;


@CrossOrigin("*")
@RestController
@RequestMapping("/notice")
public class NoticeController {
	
	private final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	private NoticeService noticeService;

	@Autowired
	public NoticeController(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

//	// 공지사항 게시판 이동을 위한 메서드
//	@GetMapping("/list")
//	public String list(Board notice, Model model, HttpSession session) throws Exception {
//		return "notice/list";
//	}
//	
//	
//	@GetMapping("/view/{articleNo}")
//	private String view(@PathVariable("articleNo") int articleNo ) throws Exception {
//		noticeService.updateHit(articleNo);
//		return "notice/view";
//	}
	
	// /notice/100
	// /notice/99
	@GetMapping("{articleNo}")
	public ResponseEntity<Board> getNoticeView(@PathVariable int articleNo) throws Exception {
		noticeService.updateHit(articleNo);
		logger.info("listArticle - 호출");
		return new ResponseEntity<>(noticeService.getArticle(articleNo), HttpStatus.OK);
	}	
	
	@GetMapping
	public ResponseEntity<List<Board>> getNoticeList(Board notice) throws Exception {
		logger.info("getArticle - 호출 : ");
		return new ResponseEntity<>(noticeService.listArticle(notice), HttpStatus.OK);
	}
	
	@PostMapping
	private ResponseEntity<?> write(@RequestBody Board board) throws Exception {
		logger.info("writeArticle - 호출");
		return new ResponseEntity<>(noticeService.writeArticle(board), HttpStatus.OK);
	}

	@PutMapping("{articleNo}")
	private ResponseEntity<?> Modify(@PathVariable int articleNo, @RequestBody Board board) throws Exception {
		board.setArticleNo(articleNo);
		logger.info("modifyArticle - 호출 {}", board);
		return new ResponseEntity<> (noticeService.modifyArticle(board), HttpStatus.OK);
	}
	
	@DeleteMapping("{articleNo}")
	private ResponseEntity<Integer> delete(@PathVariable int articleNo) throws Exception {
		logger.info("deleteArticle - 호출");
		return new ResponseEntity<>(noticeService.deleteArticle(articleNo), HttpStatus.OK);
	}
}
