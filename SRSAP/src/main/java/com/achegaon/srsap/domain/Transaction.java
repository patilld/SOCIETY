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
 * This is the Transaction domain for transactions in database
 * 
 * @author Lalit Patil Freelancer
 * @version $1.0 $, $Date: 25-08-2018 $
 * 
 */

@Entity
@Table(name = "transactions")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tra_id", nullable = false)
	private Integer traId;
	
	@Column(name = "tra_cac_id")
	private Integer traCacId;
	
	@Column(name = "tra_lac_id")
	private Integer traLacId;
	
	@Column(name = "tra_amount")
	private Integer traAmount;
	
	@Column(name = "tra_late_fee")
	private Short traLateFee;
	
	@Column(name = "tra_particulars", length = 255)
	private String traParticulars;
	
	@Column(name = "tra_payment")
	private Integer traPayment;
	
	@Column(name = "tra_collected")
	private Date traCollected;
	
	@Column(name = "tra_collected_by", length = 45)
	private String traCollectedBy;
	
	@Column(name = "tra_transacted")
	private Timestamp traTransacted;
	
	@Column(name = "tra_transacted_by", length = 45)
	private String traTransactedBy;

	public Integer getTraId() {
		return traId;
	}

	public void setTraId(Integer traId) {
		this.traId = traId;
	}

	public Integer getTraCacId() {
		return traCacId;
	}

	public void setTraCacId(Integer traCacId) {
		this.traCacId = traCacId;
	}

	public Integer getTraLacId() {
		return traLacId;
	}

	public void setTraLacId(Integer traLacId) {
		this.traLacId = traLacId;
	}

	public Integer getTraAmount() {
		return traAmount;
	}

	public void setTraAmount(Integer traAmount) {
		this.traAmount = traAmount;
	}

	public Short getTraLateFee() {
		return traLateFee;
	}

	public void setTraLateFee(Short traLateFee) {
		this.traLateFee = traLateFee;
	}

	public String getTraParticulars() {
		return traParticulars;
	}

	public void setTraParticulars(String traParticulars) {
		this.traParticulars = traParticulars;
	}

	public Integer getTraPayment() {
		return traPayment;
	}

	public void setTraPayment(Integer traPayment) {
		this.traPayment = traPayment;
	}

	public Date getTraCollected() {
		return traCollected;
	}

	public void setTraCollected(Date traCollected) {
		this.traCollected = traCollected;
	}

	public String getTraCollectedBy() {
		return traCollectedBy;
	}

	public void setTraCollectedBy(String traCollectedBy) {
		this.traCollectedBy = traCollectedBy;
	}

	public Timestamp getTraTransacted() {
		return traTransacted;
	}

	public void setTraTransacted(Timestamp traTransacted) {
		this.traTransacted = traTransacted;
	}

	public String getTraTransactedBy() {
		return traTransactedBy;
	}

	public void setTraTransactedBy(String traTransactedBy) {
		this.traTransactedBy = traTransactedBy;
	}
	
}
