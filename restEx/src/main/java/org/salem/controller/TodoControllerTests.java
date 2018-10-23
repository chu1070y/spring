package org.salem.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.salem.domain.ReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
					   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
public class TodoControllerTests {
	
	@Setter(onMethod_ = @Autowired)
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	//가짜 request
	@Before
	public void setUp() {
		
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	
	//서버를 띄우지 않아도 여기서 모든 테스트를 할 수 있다. @ContextConfiguration에 xml 둘 다 지정해야한다.
	@Test
	public void createTest() throws Exception{
		
		ReplyVO vo = new ReplyVO();
		vo.setBno(123);
		vo.setReply("댓글 좋아용...");
		vo.setReplyer("왈로위자드");
		
		String str = new Gson().toJson(vo);
		
		System.out.println(str);
		
		// "/reply/new" 주소에 post방식으로 접근하고 json타입의 데이터를 보내는 코드
		mockMvc.perform(
				post("/reply/new")
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.content(str)
				);
	}
	
	//에러뜨면 코드로 배우는 스프링 웹 프로젝트(개정판) p.357참고 (서블릿 버전 수정)
}
