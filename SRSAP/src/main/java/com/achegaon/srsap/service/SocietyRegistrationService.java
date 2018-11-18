package com.achegaon.srsap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.achegaon.srsap.domain.Society;
import com.achegaon.srsap.form.SocietyRegistrationForm;
import com.achegaon.srsap.repository.SocietyRepository;
import com.achegaon.srsap.util.DateUtils;

/**
 * This is SocietyRegistrationService for SocietyRegistrationController
 * 
 * @author Lalit Patil Freelancer
 * @version $1.0 $, $Date: 28-10-2018 $
 * 
 */

@Service
public class SocietyRegistrationService {

	@Autowired
	private SocietyRepository societyRepository;
	
	@Autowired
	private DateUtils dateUtils;
	
	public Boolean saveSocietyDetails(SocietyRegistrationForm societyRegistrationForm, String userName) {
		Society society = new Society();
		
		society.setSocName(societyRegistrationForm.getSocName());
		
		if(societyRegistrationForm.getSocLicenseStartDate() != null) {
			society.setSocLicenseStartDate(dateUtils.convertStringToSqlTimestamp(societyRegistrationForm.getSocLicenseStartDate() + "00:00:00"));
		}
		if(societyRegistrationForm.getSocLicenseEndDate() != null) {
			society.setSocLicenseEndDate(dateUtils.convertStringToSqlTimestamp(societyRegistrationForm.getSocLicenseEndDate() + "23:59:59"));
		}
		society.setSocIsActive(new Byte("1"));
		society.setSocCreated(dateUtils.createCurrentTimestamp());
		society.setSocCreatedBy(userName);
		
		society = societyRepository.save(society);
		if(society.getSocId() != null && society.getSocId().intValue() > 0) {
			return true;
		}
		return false;
	}
}
