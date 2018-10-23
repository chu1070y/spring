package org.salem.controller;

import org.salem.domain.Board;
import org.salem.domain.Page;
import org.salem.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RequestMapping("/board/*")
@Controller
@Log4j
public class BoardController {

	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	
	@GetMapping("/list")
	public void listGET(Model model, @ModelAttribute("page") Page page) {
		log.info("list page.......");
		
		page.setTotal(service.count());
		log.info("skip: " + page.getSkip());
		log.info("list: " + service.getList(page));
		model.addAttribute("list",service.getList(page));
	}
	
	@GetMapping("/register")
	public void registerGET() {
		log.info("regiser page......");
	}
	
	@PostMapping("/register")
	public String registerPOST(RedirectAttributes rttr,Board board) {
		log.info("register post.....");
		
		rttr.addFlashAttribute(service.register(board));
		
		return "redirect:/board/list";
	}
	
	
}
