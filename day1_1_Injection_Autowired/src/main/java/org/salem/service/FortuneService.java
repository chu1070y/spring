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
	
	//@Autowired�� ���� ������ �޴� 4��° ���: �ƹ��͵� ���ϰ� ������ �ȴ�.
	private DataSource ds;
	
//	// ����° ���: ����ٸ� �ٿ��� autowired�� �������ָ� set�޼ҵ带 ���� ���� �ɾ��ִ� �Ͱ� ����.
//	// jdk 1.7������ @Setter(onMethod=@__({@Autowired}))
//	// �ؿ� ����� jdk 1.8���� �����ϴ�.
//	@Setter(onMethod_= @Autowired)
//	private DataSource ds;
	
	
//	//�ι�° setter ���
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
