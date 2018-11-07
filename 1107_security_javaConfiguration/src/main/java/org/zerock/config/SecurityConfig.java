package org.zerock.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.zerock.security.CustomLoginSuccessHandler;
import org.zerock.security.CustomUserDetailsService;

import lombok.extern.log4j.Log4j;

@Configuration
@EnableWebSecurity
@Log4j
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		
		return new CustomUserDetailsService();
	}
	
	@Bean
	public AuthenticationSuccessHandler loginSuccessHandler() {
		
		return new CustomLoginSuccessHandler();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//���� �α��� ���� �ֱ�
//		auth.inMemoryAuthentication()
//			.withUser("admin").password("{noop}admin")
//			.roles("ADMIN", "MEMBER");
//		
//		auth.inMemoryAuthentication()
//		.withUser("member").password("{noop}member")
//		.roles("MEMBER");
		
		//db�� �ִ� ������ �α��� �ϱ�
		auth.userDetailsService(userDetailsService())
		    .passwordEncoder(passwordEncoder());
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		log.warn("----------------------------------");
		log.warn("security configure");
		log.warn("----------------------------------");
		
		http.authorizeRequests()
			.antMatchers("/sample/member").access("hasRole('ROLE_MEMBER')")
			.antMatchers("/sample/admin").access("hasRole('ROLE_ADMIN')");
		
		//�α��� ������ �⺻���� �����Ҳ���
//		http.formLogin();
		
		//Ŀ���� �α��� ������
		http.formLogin()
			.loginPage("/customLogin")
			.loginProcessingUrl("/login")
			.successHandler(loginSuccessHandler());
		
		//�α׾ƿ� ó��
		http.logout()
			.logoutUrl("/customLogout")
			.invalidateHttpSession(true)
			.deleteCookies("remeber-me","JSESSION_ID");
		
		//�ڵ��α��� üũ�ڽ� �����
		http.rememberMe().tokenValiditySeconds(604800);
		
	}
	
	
}
