package com.achegaon.srsap.util;

import com.achegaon.srsap.manager.UserSectionManager;
import com.achegaon.srsap.repository.UserRepository;
import com.achegaon.srsap.repository.UserRoleRepository;

/**
 * This is LoginUtils for login utility functions
 * 
 * @author Lalit Patil Freelancer
 * @version $1.0 $, $Date: 26-08-2018 $
 * 
 */

public class LoginUtils {
	
	public int loginCheck(String username, String password, UserRepository userRepository, UserRoleRepository userRoleRepository) {
		
		/**
		 * Return values
		 * -1 (Failure) Invalid username and password combination
		 * -2 (Failure) Not active User
		 * -3 (Failure) User not have a user group that says log in previleges
		 *  1 (Success) Normal user
		 */
		UserSectionManager usm = new UserSectionManager();
		
		if(!usm.checkUsernamePasswordExists(username, password, userRepository)) {
			return -1;
		}
		
		if(usm.getUser(username, userRepository).getUseActive().intValue() == 0) {
			return -2;
		}
		
		if(!usm.checkUserRole(username, userRoleRepository)) {
			return -3;
		}
		
		return 1;
	}
}
