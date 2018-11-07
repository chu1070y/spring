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
		
		//직접 로그인 정보 넣기
//		auth.inMemoryAuthentication()
//			.withUser("admin").password("{noop}admin")
//			.roles("ADMIN", "MEMBER");
//		
//		auth.inMemoryAuthentication()
//		.withUser("member").password("{noop}member")
//		.roles("MEMBER");
		
		//db에 있는 정보로 로그인 하기
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
		
		//로그인 페이지 기본으로 제공할꺼냐
//		http.formLogin();
		
		//커스텀 로그인 페이지
		http.formLogin()
			.loginPage("/customLogin")
			.loginProcessingUrl("/login")
			.successHandler(loginSuccessHandler());
		
		//로그아웃 처리
		http.logout()
			.logoutUrl("/customLogout")
			.invalidateHttpSession(true)
			.deleteCookies("remeber-me","JSESSION_ID");
		
		//자동로그인 체크박스 만들기
		http.rememberMe().tokenValiditySeconds(604800);
		
	}
	
	
}
