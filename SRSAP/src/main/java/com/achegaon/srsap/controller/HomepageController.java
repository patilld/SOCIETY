package com.achegaon.srsap.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.achegaon.srsap.sessionbean.SessionBean;
import com.achegaon.srsap.util.locale.MessageByLocaleService;

/**
 * The HomepageController for displaying homepage for shreeram society
 * 
 * @author Lalit Patil Freelancer
 * @version $1.0 $, $Date: 27-08-2018 $
 * 
 */

@Controller
public class HomepageController {
	
	@Autowired
	private MessageByLocaleService messageByLocaleService;
	
	@RequestMapping(value = "/homepage", method = RequestMethod.GET)
	public String homepage(Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		SessionBean sb = null;
		if(session != null) {
			sb = (SessionBean) session.getAttribute("userDetails");
		}
		
		if(session == null || sb == null) {
			model.addAttribute("resultMessageWarning", messageByLocaleService.getMessage("message.session.expired"));
			return "redirect:index";
		}
		
		return "Login/homepage";
	}
}
