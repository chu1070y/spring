package org.salem.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.log4j.Log4j;

@Aspect
@Component
@Log4j
@Order(value= Ordered.HIGHEST_PRECEDENCE)
public class TimeAdvice {
	
	@Around("execution(* org.salem.service.*.*(..))")
	public Object checkTime(ProceedingJoinPoint pjp) {
		
		Object result = null;
		long start = System.currentTimeMillis();
		
		try {
			result = pjp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		
		log.info("TOTAL: " + (end-start));
		
		return result;
	}
}
