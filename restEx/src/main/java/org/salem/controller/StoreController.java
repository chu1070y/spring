package org.salem.controller;

import org.salem.domain.StoreVO;
import org.salem.service.StoreService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

//@crossorigin은 ajax 문제를 해결해 준다.

/*
 * todo/new (Post)
 * todo/번호 (GET)
 * todo/번호 (Delete)
 * todo/번호 (PUT)
 * todo/list/page번호 (GET)
 * 
 * */

@RestController
@RequestMapping("/store/*")
@Log4j
@CrossOrigin(origins="*")
@AllArgsConstructor
public class StoreController {
	
	private StoreService service;
	
	//여기에 들어오는 값을 지정해주는 것이 pathvariable이다.
	@GetMapping("/{idx}")
	public StoreVO get(@PathVariable("idx") int idx) {
		
		return service.get(idx);
	}
	
	//@RequestBody는 json데이터를 java 객체로 변환해주는 작업을 수행한다.
	@PostMapping("/new")
	public String add(@RequestBody StoreVO vo) {
		
		log.info("--------------");
		log.info(vo);
		
		return "success";
	}
	
	@DeleteMapping("/{idx}")
	public String remove(@PathVariable("idx") int idx) {
		
		log.info("remove.........." + idx);
		service.remove(idx);
		
		return "success";
	}

	
	
	@GetMapping("/sample")
	public StoreVO get() {
		
		StoreVO vo = new StoreVO();
		vo.setSno(1);
		vo.setSname("오리날다");
		vo.setLat(37.123);
		vo.setLng(123.4567);
		
		return vo;
	}
}
