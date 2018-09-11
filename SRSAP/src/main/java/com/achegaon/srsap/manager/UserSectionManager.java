package com.achegaon.srsap.manager;

import java.util.List;
import java.util.Optional;

import com.achegaon.srsap.domain.User;
import com.achegaon.srsap.domain.UserRole;
import com.achegaon.srsap.repository.UserGroupRepository;
import com.achegaon.srsap.repository.UserRepository;
import com.achegaon.srsap.repository.UserRoleRepository;
import com.achegaon.srsap.sessionbean.SessionBean;

/**
 * This is the UserSectionManager for manage all user operations
 * 
 * @author Lalit Patil Freelancer
 * @version $1.0 $, $Date: 26-08-2018 $
 * 
 */

public class UserSectionManager {
	
	public boolean checkUsernamePasswordExists(String username, String password, UserRepository userRepository) {
		Optional<User> userOptional = userRepository.findById(username);
		if(userOptional.isPresent()) {
			
			User user = userOptional.get();
			if(user != null && password.equals(user.getUsePassword())) {
				return true;
			}
		}
		return false;
	}

	public User getUser(String username, UserRepository userRepository) {
		Optional<User> userOptional = userRepository.findById(username);
		if(userOptional.isPresent()) {
			return userOptional.get();
		}
		return null;
	}
	
	public boolean checkUserRole(String username, UserRoleRepository userRoleRepository) {
		List<UserRole> userRoles = userRoleRepository.findUserRoleByusrUseUsername(username);
		if(userRoles == null || userRoles.isEmpty()) {
			return false;
		}
		return true;
	}
	
	public SessionBean getUserDetailsBean(String username, UserRepository userRepository, UserGroupRepository userGroupRepository, UserRoleRepository userRoleRepository) {
		SessionBean userDetails = new SessionBean();
		Optional<User> userOptional = userRepository.findById(username);
		
		if(userOptional.isPresent()) {
			User user = userOptional.get();
			int administrationLevel = 4;
			List<UserRole> userRoles = userRoleRepository.findUserRoleByusrUseUsername(username);
			
			userDetails.setUseUsername(username);
			userDetails.setUseFirstName(user.getUseFirstName());
			userDetails.setUseLastName(user.getUseLastName());
			userDetails.setAdministrationLevel(administrationLevel);
			userDetails.setUseRoles(userRoles);
		}
		return userDetails;
	}
}
