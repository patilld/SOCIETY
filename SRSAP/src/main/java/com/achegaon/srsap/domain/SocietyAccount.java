package com.achegaon.srsap.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is the SocietyAccount domain for society_accounts in database
 * 
 * @author Lalit Patil Freelancer
 * @version $1.0 $, $Date: 25-08-2018 $
 * 
 */

@Entity
@Table(name = "society_accounts")
public class SocietyAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "soc_id", nullable = false)
	private Integer socId;
	
	@Column(name = "soc_cac_id", nullable = false)
	private Integer socCacId;

	@Column(name = "soc_sac_amount")
	private Integer socSacAmount;

	@Column(name = "soc_lac_amount")
	private Integer socLacAmount;
	
	@Column(name = "soc_emergency_amount")
	private Integer socEmergencyAmount;
	
	@Column(name = "soc_loan_given_amount")
	private Integer socLoanGivenAmount;
	
	@Column(name = "soc_fund")
	private Integer socFund;
	
	@Column(name = "soc_transacted")
	private Timestamp socTransacted;
	
	@Column(name = "soc_transacted_by", length = 45)
	private String socTransactedBy;

	public Integer getSocId() {
		return socId;
	}

	public void setSocId(Integer socId) {
		this.socId = socId;
	}

	public Integer getSocCacId() {
		return socCacId;
	}

	public void setSocCacId(Integer socCacId) {
		this.socCacId = socCacId;
	}

	public Integer getSocSacAmount() {
		return socSacAmount;
	}

	public void setSocSacAmount(Integer socSacAmount) {
		this.socSacAmount = socSacAmount;
	}

	public Integer getSocLacAmount() {
		return socLacAmount;
	}

	public void setSocLacAmount(Integer socLacAmount) {
		this.socLacAmount = socLacAmount;
	}

	public Integer getSocEmergencyAmount() {
		return socEmergencyAmount;
	}

	public void setSocEmergencyAmount(Integer socEmergencyAmount) {
		this.socEmergencyAmount = socEmergencyAmount;
	}

	public Integer getSocLoanGivenAmount() {
		return socLoanGivenAmount;
	}

	public void setSocLoanGivenAmount(Integer socLoanGivenAmount) {
		this.socLoanGivenAmount = socLoanGivenAmount;
	}

	public Integer getSocFund() {
		return socFund;
	}

	public void setSocFund(Integer socFund) {
		this.socFund = socFund;
	}

	public Timestamp getSocTransacted() {
		return socTransacted;
	}

	public void setSocTransacted(Timestamp socTransacted) {
		this.socTransacted = socTransacted;
	}

	public String getSocTransactedBy() {
		return socTransactedBy;
	}

	public void setSocTransactedBy(String socTransactedBy) {
		this.socTransactedBy = socTransactedBy;
	}

}
