package org.salem.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Todo {
	
	private Integer tno;
	private String title;
	
	//URL로 date 타입을 받기 위해서 지정해준다.
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date regdate;

}
