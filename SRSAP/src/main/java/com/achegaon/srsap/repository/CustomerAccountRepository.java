package com.achegaon.srsap.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.achegaon.srsap.domain.CustomerAccount;
import com.achegaon.srsap.repositorycustom.CustomerAccountRepositoryCustom;

/**
 * The CustomerAccountRepository repository for CustomerAccount domain.
 * 
 * @author Lalit Patil Freelancer
 * @version $1.0 $, $Date: 26-08-2018 $
 * 
 * 
 */

@Repository
public interface CustomerAccountRepository extends CrudRepository<CustomerAccount, Integer> {

	List<CustomerAccount> findCustomerAccountByOrderByCustomerDetail_CdeFirstNameAsc();

}
