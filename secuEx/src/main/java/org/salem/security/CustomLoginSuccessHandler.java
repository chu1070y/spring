package org.salem.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler implements AuthenticationFailureHandler, LogoutSuccessHandler {

	//�̷��� extends�� ��ӹ޾Ƽ� ���� �ּҷ� ���Բ� �ϴ°� ���� ����̴�.
	//�׷��� implements �ϳ��� Ŭ���� �ϳ��� ���� ��ӹ޴°� ���ٴ� ���̴�.
	
	
	//������ �������� ���
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		log.warn("Login success");
		
		List<String> roleNames = new ArrayList<>();
		
		authentication.getAuthorities().forEach(auth -> {
			roleNames.add(auth.getAuthority());
		});
		
		log.warn("Role Names: " + roleNames);
		
		if (roleNames.contains("ROLE_ADMIN")) {
			
			response.sendRedirect("/sample/admin");
			return;
		}
		
		if(roleNames.contains("ROLE_MEMBER")) {
			
			response.sendRedirect("/sample/member");
			return;
		}
		
		response.sendRedirect("/");
		
	}

	//������ �������� ���
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		log.info("Login fail");
		
		log.info(exception);
		
	}

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		
		log.info("Logout success");
		
		response.sendRedirect("/customLogin");
		
	}

}
