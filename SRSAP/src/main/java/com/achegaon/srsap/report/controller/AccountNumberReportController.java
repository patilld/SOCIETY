package com.achegaon.srsap.report.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.achegaon.srsap.report.service.AccountNumberReportService;
import com.achegaon.srsap.sessionbean.SessionBean;
import com.achegaon.srsap.util.locale.MessageByLocaleService;

/**
 * The AccountNumberReportController
 * 
 * @author Lalit Patil Freelancer
 * @version $1.0 $, $Date: 29-08-2018 $
 * 
 */

@Controller
public class AccountNumberReportController {
	
	@Autowired
	private AccountNumberReportService accountNumberReportService;
	
	@Autowired
	private MessageByLocaleService messageByLocaleService;
	
	@RequestMapping(value = "accountNumberReport", method = RequestMethod.GET)
	public String accountNumberReport(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		SessionBean sb = null;
		if(session != null) {
			sb = (SessionBean) session.getAttribute("userDetails");
		}
		
		if(sb == null) {
			model.addAttribute("resultMessageWarning", messageByLocaleService.getMessage("message.session.expired"));
			return "redirect:index";
		}
		
		List customerAccountList = accountNumberReportService.getCustomerAccount();
		model.addAttribute("customerAccountList", customerAccountList);
		
		return "Report/accountnumberreport";
	}
	
	@RequestMapping(value = "/downloadAccountNumberReport", method = RequestMethod.GET)
	public String downloadAccountNumberReport(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession(false);
		SessionBean sb = null;
		if(session != null) {
			sb = (SessionBean) session.getAttribute("userDetails");
		}
		if(sb == null) {
			model.addAttribute("resultMessageWarning", messageByLocaleService.getMessage("message.session.expired"));
			return "redirect:index";
		}
		
		accountNumberReportService.createAccountNumberPDFReport(response);
		return null;
	}
}
