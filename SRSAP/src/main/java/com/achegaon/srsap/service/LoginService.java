package com.achegaon.srsap.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.achegaon.srsap.domain.User;
import com.achegaon.srsap.listener.SessionListener;
import com.achegaon.srsap.manager.UserSectionManager;
import com.achegaon.srsap.repository.UserGroupRepository;
import com.achegaon.srsap.repository.UserRepository;
import com.achegaon.srsap.repository.UserRoleRepository;
import com.achegaon.srsap.sessionbean.SessionBean;
import com.achegaon.srsap.util.LoginUtils;
import com.achegaon.srsap.util.locale.MessageByLocaleService;

/**
 * This is LoginService for LoginController
 * 
 * @author Lalit Patil Freelancer
 * @version $1.0 $, $Date: 28-08-2018 $
 * 
 */

@Service
public class LoginService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserRoleRepository userRoleRepository;
	
	@Autowired
	private UserGroupRepository userGroupRepository;
	
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private MessageByLocaleService messageByLocaleService;
	
	public String getUserSessionId(String username) {
		Optional<User> userOptional = userRepository.findById(username);
		if(userOptional.isPresent()) {
			return userOptional.get().getUseSessionId();
		}
		return null;
	}
	
	public void saveUser(String username) {
		Optional<User> userOptional = userRepository.findById(username);
		if(userOptional.isPresent()) {
			
			User user = userOptional.get();
			user.setUseSessionId(null);
			user.setUseLoggedIn(new Byte("0"));
			userRepository.save(user);
		}
	}
	
	public boolean isValidUser(String username, String password, HttpServletRequest request) {
		LoginUtils loginUtils = new LoginUtils();
		Optional<User> userOptional = userRepository.findById(username);
		
		if(userOptional.isPresent()) {
			
			User user = userOptional.get();
			int result = loginUtils.loginCheck(username, password, userRepository, userRoleRepository);
			if(result > 0) {
				UserSectionManager usm = new UserSectionManager();
				SessionBean sb = usm.getUserDetailsBean(username, userRepository, userGroupRepository, userRoleRepository);
				if(sb != null) {
					HttpSession session = request.getSession();
					sb.setUseSessionId(session.getId());
					
					@SuppressWarnings("unchecked")
					Map<String, HttpSession> sessionMap = (Map<String, HttpSession>) this.servletContext.getAttribute("sessionMap");
					
					if(sessionMap == null) {
						synchronized(this) {
							//We double check the session map is not set to ensure the thread that has 
	                		//just got the lock for this object has not just got it after it has just been set
							if(this.servletContext.getAttribute("sessionMap") == null) {
								sessionMap = new HashMap<String, HttpSession>(500);
								this.servletContext.setAttribute("sessionMap", sessionMap);
								this.servletContext.setAttribute("userCount", "0");
								this.servletContext.setAttribute("maxUserCount", "500");
							}
						}
					}
					else {
						sessionMap.put(session.getId(), session);
					}
					
					synchronized(this) {
						int userCount = new Integer((String)this.servletContext.getAttribute("userCount")).intValue();
						int maxUserCount = new Integer((String)this.servletContext.getAttribute("maxUserCount")).intValue();
						userCount = userCount + 1;
						this.servletContext.setAttribute("userCount", "" + userCount);
						if(userCount > maxUserCount) {
							this.servletContext.setAttribute("maxUserCount", "" + userCount);
						}
					}
					
					user.setUseSessionId(session.getId());
					user.setUseLoggedIn(new Byte("1"));
					userRepository.save(user);
				
					SessionListener sl = new SessionListener();
					sl.setServletContext(servletContext);
					sl.setUsername(user.getUseUsername());
					sl.setSessionMap(sessionMap);
					sl.setSessionId(session.getId());
					sl.setUserRepository(userRepository);
					session.setAttribute("sessionListener", sl);
					session.setAttribute("userDetails", sb);
				}
				return true;
			}
			else {
				if(result == -1) {
					request.setAttribute("resultMessageDanger", messageByLocaleService.getMessage("message.login.fail.usernamepassword"));
				}
				else if(result == -2) {
					request.setAttribute("resultMessageDanger", messageByLocaleService.getMessage("message.login.fail.nonactiveuser"));
				}
				else if(result == -3) {
					request.setAttribute("resultMessageDanger", messageByLocaleService.getMessage("message.login.fail.notauthorized"));
				}
				return false;
			}
		}
		else {
			request.setAttribute("resultMessageDanger", messageByLocaleService.getMessage("message.login.fail.username"));
			return false;
		}
	}

}
