package com.achegaon.srsap.domain;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is the CustomerDetail domain for customer_details in database
 * 
 * @author Lalit Patil Freelancer
 * @version $1.0 $, $Date: 22-07-2018 $
 * 
 */

@Entity
@Table(name = "customer_details")
public class CustomerDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cde_id", nullable = false)
	private Integer cdeId;
	
	@Column(name = "cde_add_id")
	private Integer cdeAddId;
	
	@Column(name = "cde_title", length = 10)
	private String cdeTitle;
	
	@Column(name = "cde_first_name", length = 40)
	private String cdeFirstName;
	
	@Column(name = "cde_middle_name", length = 40)
	private String cdeMiddleName;
	
	@Column(name = "cde_last_name", length = 40)
	private String cdeLastName;
	
	@Column(name = "cde_dob")
	private Date cdeDob;
	
	@Column(name = "cde_gender", length = 2)
	private String cdeGender;
	
	@Column(name = "cde_occupation", length = 20)
	private String cdeOccupation;
	
	@Column(name = "cde_religion", length = 20)
	private String cdeReligion;
	
	@Column(name = "cde_created")
	private Timestamp cdeCreated;
	
	@Column(name = "cde_created_by", length = 45)
	private String cdeCreatedBy;

	public Integer getCdeId() {
		return cdeId;
	}

	public void setCdeId(Integer cdeId) {
		this.cdeId = cdeId;
	}

	public Integer getCdeAddId() {
		return cdeAddId;
	}

	public void setCdeAddId(Integer cdeAddId) {
		this.cdeAddId = cdeAddId;
	}

	public String getCdeTitle() {
		return cdeTitle;
	}

	public void setCdeTitle(String cdeTitle) {
		this.cdeTitle = cdeTitle;
	}

	public String getCdeFirstName() {
		return cdeFirstName;
	}

	public void setCdeFirstName(String cdeFirstName) {
		this.cdeFirstName = cdeFirstName;
	}

	public String getCdeMiddleName() {
		return cdeMiddleName;
	}

	public void setCdeMiddleName(String cdeMiddleName) {
		this.cdeMiddleName = cdeMiddleName;
	}

	public String getCdeLastName() {
		return cdeLastName;
	}

	public void setCdeLastName(String cdeLastName) {
		this.cdeLastName = cdeLastName;
	}

	public Date getCdeDob() {
		return cdeDob;
	}

	public void setCdeDob(Date cdeDob) {
		this.cdeDob = cdeDob;
	}

	public String getCdeGender() {
		return cdeGender;
	}

	public void setCdeGender(String cdeGender) {
		this.cdeGender = cdeGender;
	}

	public String getCdeOccupation() {
		return cdeOccupation;
	}

	public void setCdeOccupation(String cdeOccupation) {
		this.cdeOccupation = cdeOccupation;
	}

	public String getCdeReligion() {
		return cdeReligion;
	}

	public void setCdeReligion(String cdeReligion) {
		this.cdeReligion = cdeReligion;
	}

	public Timestamp getCdeCreated() {
		return cdeCreated;
	}

	public void setCdeCreated(Timestamp cdeCreated) {
		this.cdeCreated = cdeCreated;
	}

	public String getCdeCreatedBy() {
		return cdeCreatedBy;
	}

	public void setCdeCreatedBy(String cdeCreatedBy) {
		this.cdeCreatedBy = cdeCreatedBy;
	}
	
	

}
