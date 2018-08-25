package com.achegaon.srsap.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is the UserGroup domain for user_groups in database
 * 
 * @author Lalit Patil Freelancer
 * @version $1.0 $, $Date: 22-07-2018 $
 * 
 */

@Entity 
@Table(name = "user_groups")
public class UserGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ugr_id", nullable = false)
	private Integer ugrId;
	
	@Column(name = "ugr_name", length = 40)
	private String ugrName;
	
	@Column(name = "ugr_administration")
	private Short ugrAdministration;
	
	@Column(name = "ugr_grade", length = 40)
	private String ugrGrade;

	public Integer getUgrId() {
		return ugrId;
	}

	public void setUgrId(Integer ugrId) {
		this.ugrId = ugrId;
	}

	public String getUgrName() {
		return ugrName;
	}

	public void setUgrName(String ugrName) {
		this.ugrName = ugrName;
	}

	public Short getUgrAdministration() {
		return ugrAdministration;
	}

	public void setUgrAdministration(Short ugrAdministration) {
		this.ugrAdministration = ugrAdministration;
	}

	public String getUgrGrade() {
		return ugrGrade;
	}

	public void setUgrGrade(String ugrGrade) {
		this.ugrGrade = ugrGrade;
	}
}
