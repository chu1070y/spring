package org.salem.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Component
@Aspect
@Log4j
public class NullAdvice {
	
	//ProceedingJoinPoint AOP에서 얘는 만병통치약
	@Around("execution(* org.salem.service.SampleService*.*(..))")
	public Object checkNull(ProceedingJoinPoint pjp) {
		
		log.info("checkNull..........................");
		log.info("checkNull..........................");
		log.info("checkNull..........................");
		
		Object result = null;
		
		try {
			
			boolean checkNull = false;
			Object[] params = pjp.getArgs();
			
			for(Object object: params) {
				if(object == null) {
					throw new Exception("Null");
				}
			}
			
			//proceed는 invoke이다. / 얘가 메소드를 실행하는 애이다.
			result = pjp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
