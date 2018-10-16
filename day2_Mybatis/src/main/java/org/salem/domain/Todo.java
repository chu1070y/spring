package org.salem.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Todo {
	
	private Integer tno;
	private String title;
	private Date regdate;

}
