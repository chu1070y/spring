package org.salem.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.salem.mapper.TimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
@Controller
@Log4j
public class HomeController {
	
	@Setter(onMethod_ = @Autowired)
	private TimeMapper timeMapper;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		log.info(timeMapper.getTime2());

		String formattedDate = timeMapper.getTime2();
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
