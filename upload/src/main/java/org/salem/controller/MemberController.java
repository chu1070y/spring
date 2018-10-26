package org.salem.controller;

import org.salem.domain.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class MemberController {
	
	@GetMapping("/login")
	public void login(String id, String pw, Model model) {
		
		log.info("id : " + id +", pw : " + pw);
		
		if(id.equals("aaa") && pw.equals("111")) {
			MemberVO vo = new MemberVO();
			vo.setId(id);
			vo.setPw(pw);
			vo.setName("철수");
			model.addAttribute("member",vo);
		}
		
		
	}
	
}
