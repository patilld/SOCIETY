package com.achegaon.srsap.domain;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * This is the CustomerAccount domain for customer_accounts in database
 * 
 * @author Lalit Patil Freelancer
 * @version $1.0 $, $Date: 22-07-2018 $
 * 
 */

@Entity
@Table(name = "customer_accounts")
public class CustomerAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cac_id", nullable = false)
	private Integer cacId;
	
	@Column(name = "cac_cde_id", insertable = false, updatable = false)
	private Integer cacCdeId;
	
	@Column(name = "cac_sac_id", insertable = false, updatable = false)
	private Integer cacSacId;
	
	@Column(name = "cac_lac_id")
	private Integer cacLacId;
	
	@Column(name = "cac_opening_bal")
	private Integer cacOpeningBal;
	
	@Column(name = "cac_opening_month")
	private Integer cacOpeningMonth;
	
	@Column(name = "cac_application_fee")
	private Short cacApplicationFee;
	
	@Column(name = "cac_introducer_cac_id")
	private Integer cacIntroducerCacId;
	
	@Column(name = "cac_loan_guarantor_count")
	private Byte cacLoanGuarantorCount;
	
	@Column(name = "cac_active")
	private Byte cacActive;
	
	@Column(name = "cac_opened")
	private Timestamp cacOpened;
	
	@Column(name = "cac_opened_by", length = 45)
	private String cacOpenedBy;
	
	@OneToOne(optional=true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="cac_cde_id", updatable=false, insertable=true)
	private CustomerDetail customerDetail;
	
	@OneToOne(optional=true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="cac_sac_id", updatable=false, insertable=true)
	private ShareAccount shareAccount;

	public CustomerDetail getCustomerDetail() {
		return customerDetail;
	}

	public void setCustomerDetail(CustomerDetail customerDetail) {
		this.customerDetail = customerDetail;
	}

	public ShareAccount getShareAccount() {
		return shareAccount;
	}

	public void setShareAccount(ShareAccount shareAccount) {
		this.shareAccount = shareAccount;
	}

	public Integer getCacId() {
		return cacId;
	}

	public void setCacId(Integer cacId) {
		this.cacId = cacId;
	}

	public Integer getCacCdeId() {
		return cacCdeId;
	}

	public void setCacCdeId(Integer cacCdeId) {
		this.cacCdeId = cacCdeId;
	}

	public Integer getCacSacId() {
		return cacSacId;
	}

	public void setCacSacId(Integer cacSacId) {
		this.cacSacId = cacSacId;
	}

	public Integer getCacLacId() {
		return cacLacId;
	}

	public void setCacLacId(Integer cacLacId) {
		this.cacLacId = cacLacId;
	}

	public Integer getCacOpeningBal() {
		return cacOpeningBal;
	}

	public void setCacOpeningBal(Integer cacOpeningBal) {
		this.cacOpeningBal = cacOpeningBal;
	}

	public Integer getCacOpeningMonth() {
		return cacOpeningMonth;
	}

	public void setCacOpeningMonth(Integer cacOpeningMonth) {
		this.cacOpeningMonth = cacOpeningMonth;
	}

	public Short getCacApplicationFee() {
		return cacApplicationFee;
	}

	public void setCacApplicationFee(Short cacApplicationFee) {
		this.cacApplicationFee = cacApplicationFee;
	}

	public Integer getCacIntroducerCacId() {
		return cacIntroducerCacId;
	}

	public void setCacIntroducerCacId(Integer cacIntroducerCacId) {
		this.cacIntroducerCacId = cacIntroducerCacId;
	}

	public Byte getCacLoanGuarantorCount() {
		return cacLoanGuarantorCount;
	}

	public void setCacLoanGuarantorCount(Byte cacLoanGuarantorCount) {
		this.cacLoanGuarantorCount = cacLoanGuarantorCount;
	}

	public Byte getCacActive() {
		return cacActive;
	}

	public void setCacActive(Byte cacActive) {
		this.cacActive = cacActive;
	}

	public Timestamp getCacOpened() {
		return cacOpened;
	}

	public void setCacOpened(Timestamp cacOpened) {
		this.cacOpened = cacOpened;
	}

	public String getCacOpenedBy() {
		return cacOpenedBy;
	}

	public void setCacOpenedBy(String cacOpenedBy) {
		this.cacOpenedBy = cacOpenedBy;
	}
	
}