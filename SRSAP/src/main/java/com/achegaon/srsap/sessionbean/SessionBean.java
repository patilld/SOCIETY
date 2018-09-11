package com.achegaon.srsap.sessionbean;

import java.io.Serializable;
import java.util.List;

public class SessionBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String useUsername;		// Current user's username
	private String useFirstName;	// Current user's firstname
	private String useLastName;		// Current user's lastname
	private String useSessionId;	// current session Id
	private List useRoles;			// List of all user roles
	private int administrationLevel;	// Determine user administrator previlliages
	// 0 = Default
	// 1 = Read-Only
	// 2 = Standard
	// 3 = Administrator
	// 4 = super-user
	
	//Customer details
	private Integer cacId;		// Customer account Id

	public String getUseUsername() {
		return useUsername;
	}
	public int getAdministrationLevel() {
		return administrationLevel;
	}
	public void setAdministrationLevel(int administrationLevel) {
		this.administrationLevel = administrationLevel;
	}
	public List getUseRoles() {
		return useRoles;
	}
	public void setUseRoles(List useRoles) {
		this.useRoles = useRoles;
	}

	public void setUseUsername(String useUsername) {
		this.useUsername = useUsername;
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
	public String getUseSessionId() {
		return useSessionId;
	}
	public void setUseSessionId(String useSessionId) {
		this.useSessionId = useSessionId;
	}
	public Integer getCacId() {
		return cacId;
	}
	public void setCacId(Integer cacId) {
		this.cacId = cacId;
	}
}
