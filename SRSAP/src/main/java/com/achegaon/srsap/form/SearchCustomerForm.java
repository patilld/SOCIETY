package com.achegaon.srsap.form;

/**
 * This is the SearchCustomerForm for search custommer page
 * 
 * @author Lalit Patil Freelancer
 * @version $1.0 $, $Date: 28-08-2018 $
 * 
 */

public class SearchCustomerForm {

	private String cacNumber;
	private String cdeFirstName;
	private String cdeLastName;
	
	public String getCacNumber() {
		return cacNumber;
	}
	public void setCacNumber(String cacNumber) {
		this.cacNumber = cacNumber;
	}
	public String getCdeFirstName() {
		return cdeFirstName;
	}
	public void setCdeFirstName(String cdeFirstName) {
		this.cdeFirstName = cdeFirstName;
	}
	public String getCdeLastName() {
		return cdeLastName;
	}
	public void setCdeLastName(String cdeLastName) {
		this.cdeLastName = cdeLastName;
	}
}
