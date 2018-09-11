package com.achegaon.srsap.util;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.achegaon.srsap.domain.CustomerAccount;
import com.achegaon.srsap.repository.CustomerAccountRepository;

/**
 * The CustomerServiceUtils for utility function related to customer
 * 
 * @author Lalit Patil Freelancer
 * @version $1.0 $, $Date: 28-08-2018 $
 * 
 */


@Component
public class CustomerServiceUtils {
	
	public String getCustomerAccountNumber(CustomerAccount customerAccount, Integer accountNumberStartFrom) {
		return Integer.toString(customerAccount.getCacId() + accountNumberStartFrom);
	}
	
	public CustomerAccount getCustomerAccountByCustomerAccountNumber(CustomerAccountRepository customerAccountRepository, String accountNumber, Integer accountNumberStartFrom) {
		
		if(accountNumber != null && !accountNumber.isEmpty()) {
			Integer cacId = Integer.parseInt(accountNumber) - accountNumberStartFrom.intValue();
			Optional<CustomerAccount> optCustomerAccount = customerAccountRepository.findById(cacId);
			if(optCustomerAccount.isPresent()) {
				return optCustomerAccount.get();
			}
		}
		
		return null;
	}
}
