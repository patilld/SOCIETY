package com.achegaon.srsap.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is the Society domain for societies in database
 * 
 * @author Lalit Patil Freelancer
 * @version $1.0 $, $Date: 03-10-2018 $
 * 
 */

@Entity
@Table(name = "societies")
public class Society {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "soc_id", nullable = false)
	private Integer socId;
	
	@Column(name = "soc_name", nullable = false, length = 60)
	private String socName;
	
	@Column(name = "soc_license_start_date")
	private Timestamp socLicenseStartDate;
	
	@Column(name = "soc_license_end_date")
	private Timestamp socLicenseEndDate;
	
	@Column(name = "soc_is_active")
	private Byte socIsActive;
	
	@Column(name = "soc_created_by", nullable = false, length = 45)
	private String socCreatedBy;
	
	@Column(name = "soc_created", nullable = false)
	private Timestamp socCreated;
	
	@Column(name = "soc_updated_by", length = 45)
	private String socUpdatedBy;
	
	@Column(name = "soc_updated")
	private Timestamp socUpdated;

	public Integer getSocId() {
		return socId;
	}

	public void setSocId(Integer socId) {
		this.socId = socId;
	}

	public String getSocName() {
		return socName;
	}

	public void setSocName(String socName) {
		this.socName = socName;
	}

	public Timestamp getSocLicenseStartDate() {
		return socLicenseStartDate;
	}

	public void setSocLicenseStartDate(Timestamp socLicenseStartDate) {
		this.socLicenseStartDate = socLicenseStartDate;
	}

	public Timestamp getSocLicenseEndDate() {
		return socLicenseEndDate;
	}

	public void setSocLicenseEndDate(Timestamp socLicenseEndDate) {
		this.socLicenseEndDate = socLicenseEndDate;
	}

	public Byte getSocIsActive() {
		return socIsActive;
	}

	public void setSocIsActive(Byte socIsActive) {
		this.socIsActive = socIsActive;
	}

	public String getSocCreatedBy() {
		return socCreatedBy;
	}

	public void setSocCreatedBy(String socCreatedBy) {
		this.socCreatedBy = socCreatedBy;
	}

	public Timestamp getSocCreated() {
		return socCreated;
	}

	public void setSocCreated(Timestamp socCreated) {
		this.socCreated = socCreated;
	}

	public String getSocUpdatedBy() {
		return socUpdatedBy;
	}

	public void setSocUpdatedBy(String socUpdatedBy) {
		this.socUpdatedBy = socUpdatedBy;
	}

	public Timestamp getSocUpdated() {
		return socUpdated;
	}

	public void setSocUpdated(Timestamp socUpdated) {
		this.socUpdated = socUpdated;
	}
}
