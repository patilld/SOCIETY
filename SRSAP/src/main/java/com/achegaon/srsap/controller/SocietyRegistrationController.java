package com.achegaon.srsap.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.achegaon.srsap.form.SocietyRegistrationForm;
import com.achegaon.srsap.service.SocietyRegistrationService;
import com.achegaon.srsap.sessionbean.SessionBean;
import com.achegaon.srsap.util.locale.MessageByLocaleService;

/**
 * The SocietyRegistrationController to register, update society details
 * 
 * @author Lalit Patil Freelancer
 * @version $1.0 $, $Date: 28-10-2018 $
 * 
 */

@Controller
public class SocietyRegistrationController {
	
	@Autowired
	private SocietyRegistrationService societyRegistrationService;
	
	@Autowired
	private MessageByLocaleService messageByLocaleService;
	
	@RequestMapping(value = "societyRegistration", method = RequestMethod.GET)
	public String societyRegistration(Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		SessionBean sb = null;
		if(session != null) {
			sb = (SessionBean) session.getAttribute("userDetails");
		}
		
		if(sb == null) {
			model.addAttribute("resultMessageWarning", messageByLocaleService.getMessage("message.session.expired"));
			return "redirect:index";
		}
		
		return "Society/societyregistration";
	}

	@RequestMapping(value = "saveSocietyDetails", method = RequestMethod.POST)
	public String societyRegistration(Model model, HttpServletRequest request, @Valid SocietyRegistrationForm societyRegistrationForm, BindingResult bindingResult) {
		
		HttpSession session = request.getSession(false);
		SessionBean sb = null;
		if(session != null) {
			sb = (SessionBean) session.getAttribute("userDetails");
		}
		
		if(sb == null) {
			model.addAttribute("resultMessageWarning", messageByLocaleService.getMessage("message.session.expired"));
			return "redirect:index";
		}
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("resultMessageDanger", messageByLocaleService.getMessage("message.mandatory.required"));
			model.addAttribute("societyRegistrationForm", societyRegistrationForm);
			return "Customer/customerregistration";
		}
		
		Boolean socId = societyRegistrationService.saveSocietyDetails(societyRegistrationForm, sb.getUseUsername());
		if(socId) {
			model.addAttribute("resultMessageSuccess", messageByLocaleService.getMessage("message.saveSocietyDetails.success"));
			return "redirect:homepage";
		}
		
		return "Society/societyregistration";
	}
}
