package com.achegaon.srsap.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * This is the CustomerRegistrationForm for Customer Registration page
 * 
 * @author Lalit Patil Freelancer
 * @version $1.0 $, $Date: 27-08-2018 $
 * 
 */

public class CustomerRegistrationForm {

	private String cdTitle;
	
	@NotNull
	@NotBlank
	private String cdFirstName;
	private String cdMiddleName;
	
	@NotNull
	@NotBlank
	private String cdLastName;
	
	@NotNull
	@NotBlank
	private String cdDob;
	
	@NotNull
	@NotBlank
	private String cdGender;
	
	private String cdOccupation;
	private String cdReligion;
	
	@NotNull
	@NotBlank
	private String addLine1;
	
	private String addLine2;
	private String addLine3;
	private String addCity;
	private String addCounty;
	private String addDistrict;
	private String addState;
	
	@NotNull
	@NotBlank
	private String addPostalCode;
	
	private String addCountry;
	
	@NotNull
	@NotBlank
	private String addMobile;
	
	private String addEmail;
	
	public String getCdTitle() {
		return cdTitle;
	}
	public void setCdTitle(String cdTitle) {
		this.cdTitle = cdTitle;
	}
	public String getCdFirstName() {
		return cdFirstName;
	}
	public void setCdFirstName(String cdFirstName) {
		this.cdFirstName = cdFirstName;
	}
	public String getCdMiddleName() {
		return cdMiddleName;
	}
	public void setCdMiddleName(String cdMiddleName) {
		this.cdMiddleName = cdMiddleName;
	}
	public String getCdLastName() {
		return cdLastName;
	}
	public void setCdLastName(String cdLastName) {
		this.cdLastName = cdLastName;
	}
	public String getCdDob() {
		return cdDob;
	}
	public void setCdDob(String cdDob) {
		this.cdDob = cdDob;
	}
	public String getCdGender() {
		return cdGender;
	}
	public void setCdGender(String cdGender) {
		this.cdGender = cdGender;
	}
	public String getCdOccupation() {
		return cdOccupation;
	}
	public void setCdOccupation(String cdOccupation) {
		this.cdOccupation = cdOccupation;
	}
	public String getCdReligion() {
		return cdReligion;
	}
	public void setCdReligion(String cdReligion) {
		this.cdReligion = cdReligion;
	}
	public String getAddLine1() {
		return addLine1;
	}
	public void setAddLine1(String addLine1) {
		this.addLine1 = addLine1;
	}
	public String getAddLine2() {
		return addLine2;
	}
	public void setAddLine2(String addLine2) {
		this.addLine2 = addLine2;
	}
	public String getAddLine3() {
		return addLine3;
	}
	public void setAddLine3(String addLine3) {
		this.addLine3 = addLine3;
	}
	public String getAddCity() {
		return addCity;
	}
	public void setAddCity(String addCity) {
		this.addCity = addCity;
	}
	public String getAddCounty() {
		return addCounty;
	}
	public void setAddCounty(String addCounty) {
		this.addCounty = addCounty;
	}
	public String getAddDistrict() {
		return addDistrict;
	}
	public void setAddDistrict(String addDistrict) {
		this.addDistrict = addDistrict;
	}
	public String getAddState() {
		return addState;
	}
	public void setAddState(String addState) {
		this.addState = addState;
	}
	public String getAddPostalCode() {
		return addPostalCode;
	}
	public void setAddPostalCode(String addPostalCode) {
		this.addPostalCode = addPostalCode;
	}
	public String getAddCountry() {
		return addCountry;
	}
	public void setAddCountry(String addCountry) {
		this.addCountry = addCountry;
	}
	public String getAddMobile() {
		return addMobile;
	}
	public void setAddMobile(String addMobile) {
		this.addMobile = addMobile;
	}
	public String getAddEmail() {
		return addEmail;
	}
	public void setAddEmail(String addEmail) {
		this.addEmail = addEmail;
	}
	
}
