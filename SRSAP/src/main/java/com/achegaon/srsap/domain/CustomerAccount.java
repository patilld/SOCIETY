package com.achegaon.srsap.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Column(name = "cac_cde_id")
	private Integer cacCdeId;
	
	@Column(name = "cac_sac_id")
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
	
}