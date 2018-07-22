package com.achegaon.srsap.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is the Address domain for addresses in database
 * 
 * @author Lalit Patil Freelancer
 * @version $1.0 $, $Date: 22-07-2018 $
 * 
 */

@Entity
@Table(name = "addresses")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "add_id", nullable = false)
	private Integer addId;
	
	@Column(name = "add_line1", length = 30)
	private String addLine1;
	
	@Column(name = "add_line2", length = 30)
	private String addLine2;
	
	@Column(name = "add_line3", length = 30)
	private String addLine3;

	@Column(name = "add_city", length = 30)
	private String addCity;
	
	@Column(name = "add_taluka", length = 30)
	private String addTaluka;
	
	@Column(name = "add_district", length = 30)
	private String addDistrict;
	
	@Column(name = "add_state", length = 30)
	private String addState;
	
	@Column(name = "add_post_code", length = 10)
	private String addPostCode;
	
	@Column(name = "add_country", length = 30)
	private String addCountry;
	
	@Column(name = "add_mobile", length = 15)
	private String addMobile;
	
	@Column(name = "add_email", length = 40)
	private String addEmail;
	
	@Column(name = "add_added")
	private Timestamp addAdded;
	
	@Column(name = "add_added_by", length = 45)
	private String addAddedBy;

	public Integer getAddId() {
		return addId;
	}

	public void setAddId(Integer addId) {
		this.addId = addId;
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

	public String getAddTaluka() {
		return addTaluka;
	}

	public void setAddTaluka(String addTaluka) {
		this.addTaluka = addTaluka;
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

	public String getAddPostCode() {
		return addPostCode;
	}

	public void setAddPostCode(String addPostCode) {
		this.addPostCode = addPostCode;
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

	public Timestamp getAddAdded() {
		return addAdded;
	}

	public void setAddAdded(Timestamp addAdded) {
		this.addAdded = addAdded;
	}

	public String getAddAddedBy() {
		return addAddedBy;
	}

	public void setAddAddedBy(String addAddedBy) {
		this.addAddedBy = addAddedBy;
	}
}
