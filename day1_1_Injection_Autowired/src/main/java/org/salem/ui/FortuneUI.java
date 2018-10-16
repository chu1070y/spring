package org.salem.ui;

import java.util.Scanner;

import org.salem.service.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Setter;

//@Component는 스프링이 관리하게 해달라고 선언하는 것 root-context.xml에서 패키지 얘기해줘야함.

@Component
@Setter
public class FortuneUI {
	
	private Scanner scanner = new Scanner(System.in);
	@Autowired
	private FortuneService service;
	
	public void start() {
		System.out.println("마음의 준비를 하고 엔터");
		
		//엔터 인식
		scanner.nextLine();
		String result = service.getResult();
		System.out.println(result);
		
	}
	
}
