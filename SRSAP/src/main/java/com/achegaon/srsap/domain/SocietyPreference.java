package com.achegaon.srsap.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is the SocietyPreference domain for society_preferences in database
 * 
 * @author Lalit Patil Freelancer
 * @version $1.0 $, $Date: 25-08-2018 $
 * 
 */

@Entity
@Table(name = "society_preferences")
public class SocietyPreference {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "spr_id", nullable = false)
	private Integer sprId;
	
	@Column(name = "spr_name", length = 50)
	private String sprName;
	
	@Column(name = "spr_value", length = 255)
	private String sprValue;

	@Column(name = "spr_created")
	private Timestamp sprCreated;
	
	@Column(name = "spr_created_by", length = 45)
	private String sprCreatedBy;
	
	@Column(name = "spr_last_updated")
	private Timestamp sprLastUpdated;
	
	@Column(name = "spr_last_updated_by", length = 45)
	private String sprLastUpdatedBy;

	public Integer getSprId() {
		return sprId;
	}

	public void setSprId(Integer sprId) {
		this.sprId = sprId;
	}

	public String getSprName() {
		return sprName;
	}

	public void setSprName(String sprName) {
		this.sprName = sprName;
	}

	public String getSprValue() {
		return sprValue;
	}

	public void setSprValue(String sprValue) {
		this.sprValue = sprValue;
	}

	public Timestamp getSprCreated() {
		return sprCreated;
	}

	public void setSprCreated(Timestamp sprCreated) {
		this.sprCreated = sprCreated;
	}

	public String getSprCreatedBy() {
		return sprCreatedBy;
	}

	public void setSprCreatedBy(String sprCreatedBy) {
		this.sprCreatedBy = sprCreatedBy;
	}

	public Timestamp getSprLastUpdated() {
		return sprLastUpdated;
	}

	public void setSprLastUpdated(Timestamp sprLastUpdated) {
		this.sprLastUpdated = sprLastUpdated;
	}

	public String getSprLastUpdatedBy() {
		return sprLastUpdatedBy;
	}

	public void setSprLastUpdatedBy(String sprLastUpdatedBy) {
		this.sprLastUpdatedBy = sprLastUpdatedBy;
	}
}
