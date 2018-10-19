package org.salem.controller;

import java.util.Arrays;
import java.util.List;

import org.salem.domain.OrderList;
import org.salem.domain.StoreVO;
import org.salem.domain.Todo;
import org.salem.mapper.TodoMapper;
import org.salem.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/todo/*") //경로가 todo로 시작하는 애는 얘가 받아먹게된다.
@Log4j
@AllArgsConstructor
public class TodoController {
	
	private TodoService service;
	
	@GetMapping("/board")
	public void board(Model model) {
		
		log.info("board...page");
		
		int count = service.count()/10 + 1;
		
		model.addAttribute("count", count);
	}

	
	@GetMapping("/stores")
	public @ResponseBody List<StoreVO> getStores(String cat){
		
		return service.getStores(cat);
	}
	
	
	//json데이터 보여주려면jackson-databind maven 가져와야한데;;;???
	//responsebody를 붙여주면 jsp가 필요하지 않습니다. 내부적으로 결과를 처리해줍니다.
	@GetMapping("/list2")
	@ResponseBody
	public ResponseEntity<List<Todo>> list2(){
//		return service.getList();
		
		return new ResponseEntity<>(service.getList(), HttpStatus.OK);
		
	}
	
	@GetMapping("/list")
	public void list() {
		log.info("list...page");
	}
	
	@GetMapping("/register")
	public void register() {
		log.info("register");
	}
	
	@GetMapping("/exArray")
	public String exArray(String[] ids) {
		log.info(Arrays.toString(ids));
		return "todo/success";
	}
	
	//spring에서는 List로 파라미터를 받을 수 없어 따로 List 객체를 생성해서 받는다.
	//단, 전달할때 /todo/order?list[0].pid=A&list[0].qty=3 방식으로 전달해야한다. 그러나 이방식은 브라우저에서 지원을 안한다.
	//즉, JS코드로 변환을 해야한다.
	@GetMapping("/order")
	public String order( OrderList list, Model model) {
		log.info(list);
		
		model.addAttribute("total", 3000);
		
		return "todo/success";
	}
	
	@PostMapping("/register")
	public String registerPost(Todo todo, RedirectAttributes rttr) { //자동으로 todo 파리미터를 받아 객체를 생성해준다.
		//위에서 이름을 바꿔서 사용하고 싶으면 @ModelAttribute("result")Todo todo라고 쓰면 됩니다.
		//위에서 @RequestParam("aaa")String name을 추가하면 파라미터가 aaa란 것을 수집하라는 뜻이다.
		log.info(todo);
		
		// 모델에 담지 않아도 사용자가 정의한 객체타입은 아무것도 하지 않아도 자동으로 화면까지 전달됩니다.
		// 규칙은 클래스 앞글자만 소문자로 바뀝니다. 
		// 예를들어 Todo가 success.jsp에 todo로 바뀌어 전달됩니다.
//		return "todo/success";
		
		// flashAttribute는 한번만 사용되면 재활용이 불가능하다. 즉, 도배글을 막을 수 있다 
		rttr.addFlashAttribute("result", "성공");
		
		return "redirect:/todo/list";
		
		
	}
	
}
