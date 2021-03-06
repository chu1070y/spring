package org.salem.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Data;

@Data
public class PageParam {
	
	private static final double PER = 10.0;
	private int page;
	private int display;
	private int total, start, end, bno;
	
	private boolean prev,next;
	
	private boolean extend;
	private String types;
	private String keyword;
	private String[] typeArr;
	
	public PageParam() {
		this.page = 1;
		this.display = 10;
		this.extend=false;
		this.keyword="";
		this.types="";
	}
	
	public String[] getTypeArr() {
		this.typeArr = new String[this.types.length()];
		
		for (int i = 0 ; i < this.types.length(); i++) {
			this.typeArr[i] = this.types.substring(i,i+1);
		}
		
		return this.typeArr;
	}
	
	public int getSkip() {
		return (this.page - 1) * 10;
	}
	
	public void setTotal(int total) {
		this.total = total;
	
		this.end = (int) (Math.ceil(this.page/PER) * 10);
		this.start = this.end - 9;
		
		if((this.end * 10) > total) {
			this.end = (int) Math.ceil(total/10.0);
			this.next = false;
		}else {
			this.next = true;
		}
		
		this.prev = this.start != 1;
	}
	
	public String getLink(String path) {
		
		return UriComponentsBuilder.fromPath(path)
		.queryParam("bno", this.bno)
		.queryParam("page", this.page)
		.queryParam("types", this.types)
		.queryParam("keyword", this.keyword)
		.toUriString();
		
	}
	
	public static void main(String[] args) {
		
		PageParam obj = new PageParam();
		obj.setBno(123);
		obj.setPage(7);

		
		System.out.println(obj.getLink("redirect:/board/read"));
	}
	
}
