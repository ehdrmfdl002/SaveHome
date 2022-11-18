package com.ssafy.home.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	@GetMapping("/")
//	public String index() {
//		return "index";
//	}
	@GetMapping({"/", "/home"})
	public String index() {
		return "index";
	}
	
}
