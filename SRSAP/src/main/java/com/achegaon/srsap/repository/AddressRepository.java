package com.achegaon.srsap.repository;

import org.springframework.data.repository.CrudRepository;

import com.achegaon.srsap.domain.Address;

/**
 * The AddressRepository for Address domain.
 * 
 * @author Lalit Patil Freelancer
 * @version $1.0 $, $Date: 26-08-2018 $
 * 
 * 
 */

public interface AddressRepository extends CrudRepository<Address, Integer> {
	
}
