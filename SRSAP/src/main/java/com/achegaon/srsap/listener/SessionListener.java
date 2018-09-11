package com.achegaon.srsap.listener;

import java.io.Serializable;
import java.util.Map;
import java.util.Optional;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import com.achegaon.srsap.domain.User;
import com.achegaon.srsap.repository.UserRepository;

/**
 * This is LogoutSessionListener for maintaining logout session
 * 
 * @author Lalit Patil Freelancer
 * @version $1.0 $, $Date: 26-08-2018 $
 * 
 */

public class SessionListener implements HttpSessionBindingListener, Serializable {
	
	private static final long serialVersionUID = 1L;
	private ServletContext servletContext;;
	private String username;
	private String sessionId;
	private Map<String, HttpSession> sessionMap;
	
	private UserRepository userRepository;
	
	public Map<String, HttpSession> getSessionMap() {
		return sessionMap;
	}
	public void setSessionMap(Map<String, HttpSession> sessionMap) {
		this.sessionMap = sessionMap;
	}
	public UserRepository getUserRepository() {
		return userRepository;
	}
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	public ServletContext getServletContext() {
		return servletContext;
	}
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		// We update the database at login through the login check and login controller
		
	}
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		String useUsername = this.getUsername();
		try {
			if(useUsername != null) {
				Optional<User> userOptional = userRepository.findById(useUsername);
				
				if(userOptional.isPresent()) {
					User user = userOptional.get();
					user.setUseSessionId(null);
					user.setUseLoggedIn(new Byte("0"));
					
					// Remove this session from session map
					this.getSessionMap().remove(this.getSessionId());
					
					synchronized(this) {
						int userCount = new Integer((String)this.getServletContext().getAttribute("userCount")).intValue();
						userCount = userCount - 1;
						if(userCount < 0) {
							userCount = 0;
						}
						this.getServletContext().setAttribute("userCount", "" + userCount);
					}
					userRepository.save(user);
				}
				
			}
		}
		catch(Exception e) {
			
		}
	}
}
