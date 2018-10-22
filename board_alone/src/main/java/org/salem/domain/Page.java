package org.salem.domain;

import lombok.Data;

@Data
public class Page {

	private static final double PER = 10.0;
	private int page;
	private int display;
	private int total, start, end, bno;
	
	private boolean prev,next;
	
	public Page() {
		this.page = 1;
		this.display = 10;
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
}
