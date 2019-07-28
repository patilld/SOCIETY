package com.achegaon.srsap.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.achegaon.srsap.displaybean.CustomerRegistrationDisplayBean;
import com.achegaon.srsap.domain.CustomerAccount;
import com.achegaon.srsap.form.CustomerRegistrationForm;
import com.achegaon.srsap.service.CustomerRegistrationService;
import com.achegaon.srsap.sessionbean.SessionBean;
import com.achegaon.srsap.util.locale.MessageByLocaleService;

/**
 * The CustomerRegistrationController to register, update customer details
 * 
 * @author Lalit Patil Freelancer
 * @version $1.0 $, $Date: 27-08-2018 $
 * 
 * 
 */

@Controller
public class CustomerRegistrationController {

	@Autowired
	private CustomerRegistrationService customerRegistrationService;
	
	@Autowired
	private MessageByLocaleService messageByLocaleService;
	
	@RequestMapping(value = "/customerRegistration", method = RequestMethod.GET)
	public String customerRegistration(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		SessionBean sb = null;
		
		if(session != null) {
			sb = (SessionBean) session.getAttribute("userDetails");
		}
		if(sb == null) {
			model.addAttribute("resultMessageWarning", messageByLocaleService.getMessage("message.session.expired"));
			return "redirect:index";
		}
		
		CustomerRegistrationDisplayBean customerRegistrationDisplayBean = customerRegistrationService.getCustomerRegistrationBean();
		model.addAttribute("customerRegistrationDisplayBean", customerRegistrationDisplayBean);
		model.addAttribute("customerRegistrationForm", new CustomerRegistrationForm());
		return "Customer/customerregistration";
		
	}
	
	@RequestMapping(value = "/saveCustomerDetails", method = RequestMethod.POST)
	public String saveCustomerDetails(Model model, HttpServletRequest request, HttpServletResponse response, @Valid CustomerRegistrationForm customerRegistrationForm, BindingResult bindingResult) {
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
			model.addAttribute("customerRegistrationForm", customerRegistrationForm);
			return "Customer/customerregistration";
		}
		
		String fromCurrentMonth = request.getParameter("openingFromCurrentMonth");
		CustomerAccount customerAccount = customerRegistrationService.saveCustomerDetails(customerRegistrationForm, sb.getUseUsername(), fromCurrentMonth);
		if(customerAccount != null) {
			model.addAttribute("resultMessageSuccess", messageByLocaleService.getMessage("message.saveCustomerDetails.success"));
			model.addAttribute("customerAccount", customerAccount);
			return "Customer/successCustomerRegistration";
		}
		
		return "Customer/customerregistration";
	}

}
