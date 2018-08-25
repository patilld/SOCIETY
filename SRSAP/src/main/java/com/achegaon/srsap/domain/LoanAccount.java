package com.achegaon.srsap.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is the LoanAccount domain for loan_account in database
 * 
 * @author Lalit Patil Freelancer
 * @version $1.0 $, $Date: 25-08-2018 $
 * 
 */

@Entity
@Table(name = "loan_accounts")
public class LoanAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "lac_id", nullable = false)
	private Integer lacId;
	
	@Column(name = "lac_cac_id")
	private Integer lacCacId;
	
	@Column(name = "lac_amount")
	private Integer lacAmount;
	
	@Column(name = "lac_emi")
	private Short lacEmi;
	
	@Column(name = "lac_emi_amount")
	private Integer lacEmiAmount;

	@Column(name = "lac_rem_amount")
	private Integer lacRemAmount;
	
	@Column(name = "lac_emi_number")
	private Short lacEmiNumber;
	
	@Column(name = "lac_pending_emi")
	private Byte lacPendingEmi;
	
	@Column(name = "lac_interest_rate")
	private Byte lacInterestRate;
	
	@Column(name = "lac_fine")
	private Integer lacFine;
	
	@Column(name = "lac_intimation")
	private Byte lacIntimation;
	
	@Column(name = "lac_guarantor1")
	private Integer lacGuarantor1;
	
	@Column(name = "lac_guarantor2")
	private Integer lacGuarantor2;
	
	@Column(name = "lac_approved")
	private Timestamp lacApproved;
	
	@Column(name = "lac_approved_by", length = 45)
	private String lacApprovedBy;

	public Integer getLacId() {
		return lacId;
	}

	public void setLacId(Integer lacId) {
		this.lacId = lacId;
	}

	public Integer getLacCacId() {
		return lacCacId;
	}

	public void setLacCacId(Integer lacCacId) {
		this.lacCacId = lacCacId;
	}

	public Integer getLacAmount() {
		return lacAmount;
	}

	public void setLacAmount(Integer lacAmount) {
		this.lacAmount = lacAmount;
	}

	public Short getLacEmi() {
		return lacEmi;
	}

	public void setLacEmi(Short lacEmi) {
		this.lacEmi = lacEmi;
	}

	public Integer getLacEmiAmount() {
		return lacEmiAmount;
	}

	public void setLacEmiAmount(Integer lacEmiAmount) {
		this.lacEmiAmount = lacEmiAmount;
	}

	public Integer getLacRemAmount() {
		return lacRemAmount;
	}

	public void setLacRemAmount(Integer lacRemAmount) {
		this.lacRemAmount = lacRemAmount;
	}

	public Short getLacEmiNumber() {
		return lacEmiNumber;
	}

	public void setLacEmiNumber(Short lacEmiNumber) {
		this.lacEmiNumber = lacEmiNumber;
	}

	public Byte getLacPendingEmi() {
		return lacPendingEmi;
	}

	public void setLacPendingEmi(Byte lacPendingEmi) {
		this.lacPendingEmi = lacPendingEmi;
	}

	public Byte getLacInterestRate() {
		return lacInterestRate;
	}

	public void setLacInterestRate(Byte lacInterestRate) {
		this.lacInterestRate = lacInterestRate;
	}

	public Integer getLacFine() {
		return lacFine;
	}

	public void setLacFine(Integer lacFine) {
		this.lacFine = lacFine;
	}

	public Byte getLacIntimation() {
		return lacIntimation;
	}

	public void setLacIntimation(Byte lacIntimation) {
		this.lacIntimation = lacIntimation;
	}

	public Integer getLacGuarantor1() {
		return lacGuarantor1;
	}

	public void setLacGuarantor1(Integer lacGuarantor1) {
		this.lacGuarantor1 = lacGuarantor1;
	}

	public Integer getLacGuarantor2() {
		return lacGuarantor2;
	}

	public void setLacGuarantor2(Integer lacGuarantor2) {
		this.lacGuarantor2 = lacGuarantor2;
	}

	public Timestamp getLacApproved() {
		return lacApproved;
	}

	public void setLacApproved(Timestamp lacApproved) {
		this.lacApproved = lacApproved;
	}

	public String getLacApprovedBy() {
		return lacApprovedBy;
	}

	public void setLacApprovedBy(String lacApprovedBy) {
		this.lacApprovedBy = lacApprovedBy;
	}
}
