package com.achegaon.srsap.domain;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is the SocietyPolicy domain for society_policies in database
 * 
 * @author Lalit Patil Freelancer
 * @version $1.0 $, $Date: 25-08-2018 $
 * 
 */

@Entity
@Table(name = "society_policies")
public class SocietyPolicy {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "spl_id", nullable = false)
	private Integer splId;
	
	@Column(name = "spl_start_date")
	private Date splStartDate;
	
	@Column(name = "spl_late_opening_charge_percent")
	private Byte splLateOpeningChargePercent;
	
	@Column(name = "spl_application_fee")
	private Short splApplicationFee;
	
	@Column(name = "spl_monthly_share")
	private Short splMonthlyShare;
	
	@Column(name = "spl_loan_interest_rate")
	private Byte splLoanInterestRate;
	
	@Column(name = "spl_loan_late_fee")
	private Short splLoanLateFee;
	
	@Column(name = "spl_share_late_fee")
	private Short splShareLateFee;
	
	@Column(name = "spl_loan_max_amount")
	private Integer splLoanMaxAmount;
	
	@Column(name = "spl_loan_max_emi")
	private Short splLoanMaxEmi;
	
	@Column(name = "spl_payment_date")
	private Date splPaymentDate;
	
	@Column(name = "spl_payment_due_date")
	private Date splPaymentDueDate;
	
	@Column(name = "spl_updated")
	private Timestamp splUpdated;
	
	@Column(name = "spl_updated_by", length = 45)
	private String splUpdatedBy;

	public Integer getSplId() {
		return splId;
	}

	public void setSplId(Integer splId) {
		this.splId = splId;
	}

	public Date getSplStartDate() {
		return splStartDate;
	}

	public void setSplStartDate(Date splStartDate) {
		this.splStartDate = splStartDate;
	}

	public Byte getSplLateOpeningChargePercent() {
		return splLateOpeningChargePercent;
	}

	public void setSplLateOpeningChargePercent(Byte splLateOpeningChargePercent) {
		this.splLateOpeningChargePercent = splLateOpeningChargePercent;
	}

	public Short getSplApplicationFee() {
		return splApplicationFee;
	}

	public void setSplApplicationFee(Short splApplicationFee) {
		this.splApplicationFee = splApplicationFee;
	}

	public Short getSplMonthlyShare() {
		return splMonthlyShare;
	}

	public void setSplMonthlyShare(Short splMonthlyShare) {
		this.splMonthlyShare = splMonthlyShare;
	}

	public Byte getSplLoanInterestRate() {
		return splLoanInterestRate;
	}

	public void setSplLoanInterestRate(Byte splLoanInterestRate) {
		this.splLoanInterestRate = splLoanInterestRate;
	}

	public Short getSplLoanLateFee() {
		return splLoanLateFee;
	}

	public void setSplLoanLateFee(Short splLoanLateFee) {
		this.splLoanLateFee = splLoanLateFee;
	}

	public Short getSplShareLateFee() {
		return splShareLateFee;
	}

	public void setSplShareLateFee(Short splShareLateFee) {
		this.splShareLateFee = splShareLateFee;
	}

	public Integer getSplLoanMaxAmount() {
		return splLoanMaxAmount;
	}

	public void setSplLoanMaxAmount(Integer splLoanMaxAmount) {
		this.splLoanMaxAmount = splLoanMaxAmount;
	}

	public Short getSplLoanMaxEmi() {
		return splLoanMaxEmi;
	}

	public void setSplLoanMaxEmi(Short splLoanMaxEmi) {
		this.splLoanMaxEmi = splLoanMaxEmi;
	}

	public Date getSplPaymentDate() {
		return splPaymentDate;
	}

	public void setSplPaymentDate(Date splPaymentDate) {
		this.splPaymentDate = splPaymentDate;
	}

	public Date getSplPaymentDueDate() {
		return splPaymentDueDate;
	}

	public void setSplPaymentDueDate(Date splPaymentDueDate) {
		this.splPaymentDueDate = splPaymentDueDate;
	}

	public Timestamp getSplUpdated() {
		return splUpdated;
	}

	public void setSplUpdated(Timestamp splUpdated) {
		this.splUpdated = splUpdated;
	}

	public String getSplUpdatedBy() {
		return splUpdatedBy;
	}

	public void setSplUpdatedBy(String splUpdatedBy) {
		this.splUpdatedBy = splUpdatedBy;
	}
	
}
