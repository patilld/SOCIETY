package com.achegaon.srsap.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.achegaon.srsap.domain.CustomerAccount;
import com.achegaon.srsap.form.SearchCustomerForm;
import com.achegaon.srsap.service.SearchCustomerService;
import com.achegaon.srsap.sessionbean.SessionBean;
import com.achegaon.srsap.util.locale.MessageByLocaleService;

/**
 * The SearchCustomerController for search customer
 * 
 * @author Lalit Patil Freelancer
 * @version $1.0 $, $Date: 29-08-2018 $
 * 
 */

@Controller
public class SearchCustomerController {
	
	@Autowired
	private SearchCustomerService searchCustomerService;
	
	@Autowired
	private MessageByLocaleService messageByLocaleService;
	
	@RequestMapping(value = "/searchCustomer", method = RequestMethod.GET)
	public String searchCustomer(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		SessionBean sb = null;
		if(session != null) {
			sb = (SessionBean) session.getAttribute("userDetails");
		}
		
		if(sb == null) {
			model.addAttribute("resultMessageWarning", messageByLocaleService.getMessage("message.session.expired"));
			return "redirect:index";
		}
		
		model.addAttribute("searchCustomerForm", new SearchCustomerForm());
		return "Customer/searchcustomer";
	}
	
	@RequestMapping(value = "/customerList", method = RequestMethod.POST)
	public String customerList(Model model, HttpServletRequest request, @ModelAttribute("searchCustomerForm") SearchCustomerForm searchCustomerForm) {
		HttpSession session = request.getSession(false);
		SessionBean sb = null;
		if(session != null) {
			sb = (SessionBean) session.getAttribute("userDetails");
		}
		if(sb == null) {
			model.addAttribute("resultMessageWarning", messageByLocaleService.getMessage("message.session.expired"));
			return "redirect:index";
		}
		
		List<CustomerAccount> customerList = searchCustomerService.searchCustomerList(searchCustomerForm);
		model.addAttribute("customerList", customerList);
		model.addAttribute("searchedCustomer", "true");
		return "Customer/searchcustomer";
	}
	
	@RequestMapping(value = "/selectTheCustomer/{cacId}", method = RequestMethod.GET)
	public String selectTheCustomer(Model model, HttpServletRequest request, @PathVariable("cacId") Integer cacId) {
		HttpSession session = request.getSession(false);
		SessionBean sb = null;
		if(session != null) {
			sb = (SessionBean) session.getAttribute("userDetails");
		}
		if(sb == null) {
			model.addAttribute("resultMessageWarning", messageByLocaleService.getMessage("message.session.expired"));
			return "redirect:index";
		}
		
		if(cacId != null && cacId.intValue() > 0) {
			CustomerAccount customerAccount = searchCustomerService.selectCustomer(sb, cacId);
			if(customerAccount != null) {
				String imageDataUrl = searchCustomerService.getImageDataURL(customerAccount.getCacId());
				model.addAttribute("customerImage", imageDataUrl);
				model.addAttribute("customerAccount", customerAccount);
				return "Customer/customerDetails";
			}
		}
		return "Customer/searchcustomer";
	}
}
