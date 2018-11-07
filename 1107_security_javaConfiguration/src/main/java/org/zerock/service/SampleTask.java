package org.zerock.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Log4j
@Component
public class SampleTask {
	
	@Scheduled(cron="0 * * * * *")
	public void doJob() {
		
		log.warn("---------------");
		log.warn("---------------");
		log.warn("---------------");
		log.warn("---------------");
		log.warn("---------------");
		log.warn("END");
	}
	
	
}
	