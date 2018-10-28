package com.achegaon.srsap.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.achegaon.srsap.domain.Society;

/**
 * The SocietyRepository for Society domain.
 * 
 * @author Lalit Patil Freelancer
 * @version $1.0 $, $Date: 03-10-2018 $
 * 
 * 
 */

@Repository
public interface SocietyRepository extends CrudRepository<Society, Integer> {

}
