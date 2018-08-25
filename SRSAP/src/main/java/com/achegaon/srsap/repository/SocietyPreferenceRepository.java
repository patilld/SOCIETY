package com.achegaon.srsap.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.achegaon.srsap.domain.SocietyPreference;

/**
 * The SocietyPreferenceRepository for SocietyPreference domain.
 * 
 * @author Lalit Patil Freelancer
 * @version $1.0 $, $Date: 26-08-2018 $
 * 
 * 
 */

@Repository
public interface SocietyPreferenceRepository extends CrudRepository<SocietyPreference, Integer> {

}
