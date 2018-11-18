package com.achegaon.srsap.form;

public class SocietyRegistrationForm {
	
	private String socName;
	private String socLicenseStartDate;
	private String socLicenseEndDate;
	private String socIsActive;
	
	public String getSocName() {
		return socName;
	}
	public void setSocName(String socName) {
		this.socName = socName;
	}
	public String getSocLicenseStartDate() {
		return socLicenseStartDate;
	}
	public void setSocLicenseStartDate(String socLicenseStartDate) {
		this.socLicenseStartDate = socLicenseStartDate;
	}
	public String getSocLicenseEndDate() {
		return socLicenseEndDate;
	}
	public void setSocLicenseEndDate(String socLicenseEndDate) {
		this.socLicenseEndDate = socLicenseEndDate;
	}
	public String getSocIsActive() {
		return socIsActive;
	}
	public void setSocIsActive(String socIsActive) {
		this.socIsActive = socIsActive;
	}
}
