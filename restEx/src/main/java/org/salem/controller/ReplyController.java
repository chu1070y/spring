package org.salem.controller;

import org.salem.domain.ReplyVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/reply/*")
@Log4j
public class ReplyController {
	
	@PostMapping("/new")
	public void register(@RequestBody ReplyVO vo) {
		
		log.info("new: " + vo);
	}
	
	
	
}
