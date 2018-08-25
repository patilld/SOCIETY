package com.achegaon.srsap.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is the User domain for users in database
 * 
 * @author Lalit Patil Freelancer
 * @version $1.0 $, $Date: 22-07-2018 $
 * 
 */

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "use_username", nullable = false, length = 45)
	private String useUsername;

	@Column(name = "use_cac_id")
	private Integer useCacId;
	
	@Column(name = "use_title", length = 10)
	private String useTitle;
	
	@Column(name = "use_first_name", nullable = false, length = 40)
	private String useFirstName;
	
	@Column(name = "use_last_name", nullable = false, length = 40)
	private String useLastName;
	
	@Column(name = "use_password", nullable = false, length = 60)
	private String usePassword;
	
	@Column(name = "use_active")
	private Byte useActive;
	
	@Column(name = "use_logged_in")
	private Byte useLoggedIn;
	
	@Column(name = "use_session_id", length = 150)
	private String useSessionId;
	
	@Column(name = "use_added")
	private Timestamp useAdded;
	
	@Column(name = "use_added_by", length = 45)
	private String useAddedBy;

	public String getUseUsername() {
		return useUsername;
	}

	public void setUseUsername(String useUsername) {
		this.useUsername = useUsername;
	}

	public Integer getUseCacId() {
		return useCacId;
	}

	public void setUseCacId(Integer useCacId) {
		this.useCacId = useCacId;
	}

	public String getUseTitle() {
		return useTitle;
	}

	public void setUseTitle(String useTitle) {
		this.useTitle = useTitle;
	}

	public String getUseFirstName() {
		return useFirstName;
	}

	public void setUseFirstName(String useFirstName) {
		this.useFirstName = useFirstName;
	}

	public String getUseLastName() {
		return useLastName;
	}

	public void setUseLastName(String useLastName) {
		this.useLastName = useLastName;
	}

	public String getUsePassword() {
		return usePassword;
	}

	public void setUsePassword(String usePassword) {
		this.usePassword = usePassword;
	}

	public Byte getUseActive() {
		return useActive;
	}

	public void setUseActive(Byte useActive) {
		this.useActive = useActive;
	}

	public Byte getUseLoggedIn() {
		return useLoggedIn;
	}

	public void setUseLoggedIn(Byte useLoggedIn) {
		this.useLoggedIn = useLoggedIn;
	}

	public String getUseSessionId() {
		return useSessionId;
	}

	public void setUseSessionId(String useSessionId) {
		this.useSessionId = useSessionId;
	}

	public Timestamp getUseAdded() {
		return useAdded;
	}

	public void setUseAdded(Timestamp useAdded) {
		this.useAdded = useAdded;
	}

	public String getUseAddedBy() {
		return useAddedBy;
	}

	public void setUseAddedBy(String useAddedBy) {
		this.useAddedBy = useAddedBy;
	}
}
