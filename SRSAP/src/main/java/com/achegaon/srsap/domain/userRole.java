package com.achegaon.srsap.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is the userRole domain for user_roles in database
 * 
 * @author Lalit Patil Freelancer
 * @version $1.0 $, $Date: 22-07-2018 $
 * 
 */

@Entity
@Table(name = "user_roles")
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usr_id", nullable = false)
	private Integer usrId;
	
	@Column(name = "usr_use_username", length = 45)
	private String usrUseUsername;
	
	@Column(name = "usr_name", length = 40)
	private String usrName;
	
	@Column(name = "usr_ugr_id")
	private Integer usrUgrId;

	public Integer getUsrId() {
		return usrId;
	}

	public void setUsrId(Integer usrId) {
		this.usrId = usrId;
	}

	public String getUsrUseUsername() {
		return usrUseUsername;
	}

	public void setUsrUseUsername(String usrUseUsername) {
		this.usrUseUsername = usrUseUsername;
	}

	public String getUsrName() {
		return usrName;
	}

	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}

	public Integer getUsrUgrId() {
		return usrUgrId;
	}

	public void setUsrUgrId(Integer usrUgrId) {
		this.usrUgrId = usrUgrId;
	}
}
