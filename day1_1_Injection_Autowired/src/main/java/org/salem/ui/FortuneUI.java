package org.salem.ui;

import java.util.Scanner;

import org.salem.service.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Setter;

//@Component�� �������� �����ϰ� �ش޶�� �����ϴ� �� root-context.xml���� ��Ű�� ����������.

@Component
@Setter
public class FortuneUI {
	
	private Scanner scanner = new Scanner(System.in);
	@Autowired
	private FortuneService service;
	
	public void start() {
		System.out.println("������ �غ� �ϰ� ����");
		
		//���� �ν�
		scanner.nextLine();
		String result = service.getResult();
		System.out.println(result);
		
	}
	
}
