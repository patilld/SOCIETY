package com.achegaon.srsap.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This is the ShareAccount domain for share_accounts in database
 * 
 * @author Lalit Patil Freelancer
 * @version $1.0 $, $Date: 25-08-2018 $
 * 
 */

public class ShareAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sac_id", nullable = false)
	private Integer sacId;
	
	@Column(name = "sac_balance")
	private Integer sacBalance;
	
	@Column(name = "sac_fine")
	private Integer sacFine;

	@Column(name = "sac_rem_month")
	private Byte sacRemMonth;
	
	@Column(name = "sac_opened")
	private Timestamp sacOpened;
	
	@Column(name = "sac_opened_by", length = 45)
	private String sacOpenedBy;

	public Integer getSacId() {
		return sacId;
	}

	public void setSacId(Integer sacId) {
		this.sacId = sacId;
	}

	public Integer getSacBalance() {
		return sacBalance;
	}

	public void setSacBalance(Integer sacBalance) {
		this.sacBalance = sacBalance;
	}

	public Integer getSacFine() {
		return sacFine;
	}

	public void setSacFine(Integer sacFine) {
		this.sacFine = sacFine;
	}

	public Byte getSacRemMonth() {
		return sacRemMonth;
	}

	public void setSacRemMonth(Byte sacRemMonth) {
		this.sacRemMonth = sacRemMonth;
	}

	public Timestamp getSacOpened() {
		return sacOpened;
	}

	public void setSacOpened(Timestamp sacOpened) {
		this.sacOpened = sacOpened;
	}

	public String getSacOpenedBy() {
		return sacOpenedBy;
	}

	public void setSacOpenedBy(String sacOpenedBy) {
		this.sacOpenedBy = sacOpenedBy;
	}
	
}
