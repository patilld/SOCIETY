package com.achegaon.srsap.displaybean;

/**
 * The CustomerRegistrationDisplayBean to display the account opening details.
 * 
 * @author Lalit Patil Freelancer
 * @version $1.0 $, $Date: 27-08-2018 $
 * 
 */

public class CustomerRegistrationDisplayBean {

	private Integer lateOpeningCharge;
	private Integer societyCurrentMonth;
	private Short societyApplicationFee;
	private Short societyMonthlyShare;
	private Integer totalPaymentFromStart;
	private Integer totalPaymentFromCurrentMonth;
	
	public Integer getLateOpeningCharge() {
		return lateOpeningCharge;
	}
	public void setLateOpeningCharge(Integer lateOpeningCharge) {
		this.lateOpeningCharge = lateOpeningCharge;
	}
	public Integer getSocietyCurrentMonth() {
		return societyCurrentMonth;
	}
	public void setSocietyCurrentMonth(Integer societyCurrentMonth) {
		this.societyCurrentMonth = societyCurrentMonth;
	}
	public Short getSocietyApplicationFee() {
		return societyApplicationFee;
	}
	public void setSocietyApplicationFee(Short societyApplicationFee) {
		this.societyApplicationFee = societyApplicationFee;
	}
	public Short getSocietyMonthlyShare() {
		return societyMonthlyShare;
	}
	public void setSocietyMonthlyShare(Short societyMonthlyShare) {
		this.societyMonthlyShare = societyMonthlyShare;
	}
	public Integer getTotalPaymentFromStart() {
		return totalPaymentFromStart;
	}
	public void setTotalPaymentFromStart(Integer totalPaymentFromStart) {
		this.totalPaymentFromStart = totalPaymentFromStart;
	}
	public Integer getTotalPaymentFromCurrentMonth() {
		return totalPaymentFromCurrentMonth;
	}
	public void setTotalPaymentFromCurrentMonth(Integer totalPaymentFromCurrentMonth) {
		this.totalPaymentFromCurrentMonth = totalPaymentFromCurrentMonth;
	}
	
}
