package com.achegaon.srsap.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.achegaon.srsap.domain.UserRole;

/**
 * The UserRoleRepository for UserRole domain.
 * 
 * @author Lalit Patil Freelancer
 * @version $1.0 $, $Date: 26-08-2018 $
 * 
 * 
 */

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, Integer>{

	List<UserRole> findUserRoleByusrUseUsername(String username);

}
