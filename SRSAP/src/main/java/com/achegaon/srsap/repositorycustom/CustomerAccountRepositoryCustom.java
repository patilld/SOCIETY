package com.achegaon.srsap.repositorycustom;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.springframework.data.repository.NoRepositoryBean;

import com.achegaon.srsap.domain.CustomerAccount;

/**
 * The CustomerAccountRepositoryCustom to implement custom queries
 * 
 * @author Lalit Patil Freelancer
 * @version $1.0 $, $Date: 02-09-2018 $
 * 
 */

@NoRepositoryBean
public interface CustomerAccountRepositoryCustom {
	
	//List<CustomerAccount> searchCustomerBySearchCriteria(Integer cacId, String cdeFirstName, String cdeLastName);
}
