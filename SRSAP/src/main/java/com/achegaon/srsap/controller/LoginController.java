package com.achegaon.srsap.controller;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

import javax.mail.MessagingException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.achegaon.srsap.form.LoginForm;
import com.achegaon.srsap.service.LoginService;
import com.achegaon.srsap.sessionbean.SessionBean;
import com.achegaon.srsap.util.locale.MessageByLocaleService;

/**
 * The LoginController for all Login operations
 * 
 * @author Lalit Patil Freelancer
 * @version $1.0 $, $Date: 26-08-2018 $
 * 
 */


@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	MessageByLocaleService messageByLocaleService;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, MessagingException {
		
		HttpSession session = request.getSession(false);
		SessionBean sb = null;
		if(session != null) {
			sb = (SessionBean) session.getAttribute("userDetails");
			if(sb == null) {
				return "Login/login";
			}
			String sessionId = loginService.getUserSessionId(sb.getUseUsername());
			if(Objects.equals(sessionId, sb.getUseSessionId())) {
				return "redirect:homepage";
			}
		}
		
		model.addAttribute("loginForm", new LoginForm());
		model.addAttribute("resultMessageInfo", messageByLocaleService.getMessage("login.message"));
		return "Login/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, HttpServletRequest request, HttpServletResponse response, @Valid @ModelAttribute("loginForm") LoginForm loginForm, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("resultMessageDanger", messageByLocaleService.getMessage("login.required"));
			return "Login/login";
		}
		
		String username = loginForm.getUsername().toLowerCase();
		String password = loginForm.getPassword();
		String sessionId = loginService.getUserSessionId(username);
		
		if(sessionId != null && !sessionId.isEmpty()) {
			@SuppressWarnings("unchecked")
			Map<String, HttpSession> sessionMap = (Map<String, HttpSession> ) servletContext.getAttribute("sessionMap");
			if(sessionMap != null && sessionMap.get(sessionId) != null) {
				HttpSession userSession = (HttpSession) sessionMap.get(sessionId);
				if(userSession != null) {
					userSession.invalidate();
				}
			}
			else {
				loginService.saveUser(username);
			}
		}
		
		boolean isValidUser = loginService.isValidUser(username, password, request);
		if(isValidUser) {
			return "redirect:homepage";
		}
		
		String resultMessageDanger = (String) request.getAttribute("resultMessageDanger");
		if(resultMessageDanger != null && !resultMessageDanger.isEmpty()) {
			model.addAttribute("resultMessageDanger", resultMessageDanger);
		}
		return "Login/login";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session != null) {
			session.removeAttribute("sessionListener");
			session.removeAttribute("userDetails");
			session.invalidate();
		}
		return "redirect:index";
	}
}
