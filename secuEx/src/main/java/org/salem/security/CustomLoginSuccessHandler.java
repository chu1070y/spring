package org.salem.security;

import java.io.IOException;

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
		
		log.info("Login success");
		
		authentication.getAuthorities().forEach(auth -> {
			log.info(auth);
		});
		log.info("-----------------");
		
		super.onAuthenticationSuccess(request, response, authentication);
		
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