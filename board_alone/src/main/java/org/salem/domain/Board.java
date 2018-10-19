package org.salem.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Board {
	
	private String title, writer, content;
	private Date updatedate, regdate;
	private int bno;
	
	
	
}
