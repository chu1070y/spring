package org.salem.security;

import org.salem.domain.MemberVO;
import org.salem.mapper.MemberMapper;
import org.salem.security.domain.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
public class CustomUserDetailsService implements UserDetailsService {

	@Setter(onMethod_ = @Autowired)
	private MemberMapper mapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		log.info("loadUserByUsername............................");
		log.info("PARAM: " + username);
		
		MemberVO vo = mapper.getMember(username);		
		
		log.info(vo);
		
		return new CustomUser(vo);
		
	}

}
