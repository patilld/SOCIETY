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
	@Column(name = "soa_id", nullable = false)
	private Integer soaId;
	
	@Column(name = "soa_cac_id", nullable = false)
	private Integer soaCacId;

	@Column(name = "soa_sac_amount")
	private Integer soaSacAmount;

	@Column(name = "soa_lac_amount")
	private Integer soaLacAmount;
	
	@Column(name = "soa_emergency_amount")
	private Integer soaEmergencyAmount;
	
	@Column(name = "soa_loan_given_amount")
	private Integer soaLoanGivenAmount;
	
	@Column(name = "soa_fund")
	private Integer soaFund;
	
	@Column(name = "soa_transacted")
	private Timestamp soaTransacted;
	
	@Column(name = "soa_transacted_by", length = 45)
	private String soaTransactedBy;

	public Integer getSoaId() {
		return soaId;
	}

	public void setSoaId(Integer soaId) {
		this.soaId = soaId;
	}

	public Integer getSoaCacId() {
		return soaCacId;
	}

	public void setSoaCacId(Integer soaCacId) {
		this.soaCacId = soaCacId;
	}

	public Integer getSoaSacAmount() {
		return soaSacAmount;
	}

	public void setSoaSacAmount(Integer soaSacAmount) {
		this.soaSacAmount = soaSacAmount;
	}

	public Integer getSoaLacAmount() {
		return soaLacAmount;
	}

	public void setSoaLacAmount(Integer soaLacAmount) {
		this.soaLacAmount = soaLacAmount;
	}

	public Integer getSoaEmergencyAmount() {
		return soaEmergencyAmount;
	}

	public void setSoaEmergencyAmount(Integer soaEmergencyAmount) {
		this.soaEmergencyAmount = soaEmergencyAmount;
	}

	public Integer getSoaLoanGivenAmount() {
		return soaLoanGivenAmount;
	}

	public void setSoaLoanGivenAmount(Integer soaLoanGivenAmount) {
		this.soaLoanGivenAmount = soaLoanGivenAmount;
	}

	public Integer getSoaFund() {
		return soaFund;
	}

	public void setSoaFund(Integer soaFund) {
		this.soaFund = soaFund;
	}

	public Timestamp getSoaTransacted() {
		return soaTransacted;
	}

	public void setSoaTransacted(Timestamp soaTransacted) {
		this.soaTransacted = soaTransacted;
	}

	public String getSoaTransactedBy() {
		return soaTransactedBy;
	}

	public void setSoaTransactedBy(String soaTransactedBy) {
		this.soaTransactedBy = soaTransactedBy;
	}

}
