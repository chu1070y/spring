package org.salem.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Service
@AllArgsConstructor
public class FortuneService {
	
	//@Autowired를 통해 주입을 받는 4번째 방법: 아무것도 안하고 주입이 된다.
	private DataSource ds;
	
//	// 세번째 방법: 언더바를 붙여서 autowired를 선언해주면 set메소드를 직접 만들어서 걸어주는 것과 같다.
//	// jdk 1.7버전은 @Setter(onMethod=@__({@Autowired}))
//	// 밑에 방법은 jdk 1.8버전 가능하다.
//	@Setter(onMethod_= @Autowired)
//	private DataSource ds;
	
	
//	//두번째 setter 방법
//	@Autowired
//	public void setDs(DataSource ds) {
//		this.ds = ds;
//	}
	
	public String getResult() {
		String result = null;
		
		try(Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select now()");
			ResultSet rs = pstmt.executeQuery();
			){
			
			rs.next();
			result = rs.getString(1);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}

	
}
