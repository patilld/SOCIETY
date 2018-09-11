package com.achegaon.srsap.service;

import java.sql.Date;
import java.sql.Timestamp;

import org.joda.time.DateTime;
import org.joda.time.Months;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.achegaon.srsap.displaybean.CustomerRegistrationDisplayBean;
import com.achegaon.srsap.domain.Address;
import com.achegaon.srsap.domain.CustomerAccount;
import com.achegaon.srsap.domain.CustomerDetail;
import com.achegaon.srsap.domain.ShareAccount;
import com.achegaon.srsap.domain.SocietyPolicy;
import com.achegaon.srsap.form.CustomerRegistrationForm;
import com.achegaon.srsap.repository.CustomerAccountRepository;
import com.achegaon.srsap.repository.SocietyPolicyRepository;
import com.achegaon.srsap.util.DateUtils;

/**
 * The CustomerRegistrationService for AddCustomerController
 * 
 * @author Lalit Patil Freelancer
 * @version $1.0 $, $Date: 27-08-2018 $
 * 
 */

@Service
public class CustomerRegistrationService {
	
	@Autowired
	private CustomerAccountRepository customerAccountRepository;
	
	@Autowired
	private SocietyPolicyRepository societyPolicyRepository;
	
	public CustomerRegistrationDisplayBean getCustomerRegistrationBean() {
		SocietyPolicy societyPolicy = societyPolicyRepository.findTopSocietyPolicyByOrderBySplUpdatedDesc();
		CustomerRegistrationDisplayBean crdb = new CustomerRegistrationDisplayBean();
		Integer month = this.getSocietyMonth(societyPolicy.getSplStartDate());
		crdb.setSocietyCurrentMonth(month);
		crdb.setLateOpeningCharge(this.getLateOpeningCharge(month));
		crdb.setSocietyApplicationFee(societyPolicy.getSplApplicationFee());
		crdb.setSocietyMonthlyShare(societyPolicy.getSplMonthlyShare());
		
		Integer shareAmount = month * societyPolicy.getSplMonthlyShare();
		Integer lateOeningAmount = shareAmount * societyPolicy.getSplLateOpeningChargePercent()/100;
		Integer totalPaymentFromStart = shareAmount + lateOeningAmount + societyPolicy.getSplApplicationFee();
		
		Integer totalPaymentFromCurrentMonth = societyPolicy.getSplMonthlyShare() + societyPolicy.getSplApplicationFee();
		
		crdb.setTotalPaymentFromStart(totalPaymentFromStart);
		crdb.setTotalPaymentFromCurrentMonth(totalPaymentFromCurrentMonth);
		return crdb;
	}
	
	public Integer getSocietyMonth(Date date) {
		
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
		DateTime start = formatter.parseDateTime(date.toString() + " 00:00:00");
		DateTime end = new DateTime();
        start = start.withDayOfMonth(1);
        end = end.withDayOfMonth(1);
        return Months.monthsBetween(start, end).getMonths() + 1;
	}
	
	public Integer getLateOpeningCharge(Integer month) {
		SocietyPolicy spl = societyPolicyRepository.findTopSocietyPolicyByOrderBySplUpdatedDesc();
		return Integer.valueOf((int) Math.ceil((double)(month * spl.getSplMonthlyShare()) * spl.getSplLateOpeningChargePercent() / 100));
	}
	
public CustomerAccount saveCustomerDetails(CustomerRegistrationForm customerRegistrationForm, String username, String fromCurrentMonth) {
		
		DateUtils du = new DateUtils();
		Timestamp currentTimestamp = du.createCurrentTimestamp();
				
		//Register Customer details
		CustomerDetail customerDetail = new CustomerDetail();
		customerDetail.setCdeTitle(customerRegistrationForm.getCdTitle());
		customerDetail.setCdeFirstName(customerRegistrationForm.getCdFirstName());
		customerDetail.setCdeMiddleName(customerRegistrationForm.getCdMiddleName());
		customerDetail.setCdeLastName(customerRegistrationForm.getCdLastName());
		customerDetail.setCdeDob(du.convertStringToSqlDate(customerRegistrationForm.getCdDob()));
		customerDetail.setCdeGender(customerRegistrationForm.getCdGender());
		customerDetail.setCdeOccupation(customerRegistrationForm.getCdOccupation());
		customerDetail.setCdeReligion(customerRegistrationForm.getCdReligion());
		customerDetail.setCdeCreatedBy(username);
		customerDetail.setCdeCreated(currentTimestamp);
		
		//Save address details
		Address address = new Address();
		address.setAddLine1(customerRegistrationForm.getAddLine1());
		address.setAddLine2(customerRegistrationForm.getAddLine2());
		address.setAddLine3(customerRegistrationForm.getAddLine3());
		address.setAddCity(customerRegistrationForm.getAddCity());
		address.setAddTaluka(customerRegistrationForm.getAddCounty());
		address.setAddDistrict(customerRegistrationForm.getAddDistrict());
		address.setAddState(customerRegistrationForm.getAddState());
		address.setAddPostCode(customerRegistrationForm.getAddPostalCode());
		address.setAddCountry(customerRegistrationForm.getAddCountry());
		address.setAddMobile(customerRegistrationForm.getAddMobile());
		address.setAddEmail(customerRegistrationForm.getAddEmail());
		address.setAddAdded(currentTimestamp);
		address.setAddAddedBy(username);
		
		customerDetail.setAddress(address);
		
		CustomerRegistrationDisplayBean customerRegistrationDisplayBean = this.getCustomerRegistrationBean();
		
		// Open share account
		ShareAccount shareAccount = new ShareAccount();
			
		if(fromCurrentMonth != null) {
			shareAccount.setSacBalance(Integer.valueOf(customerRegistrationDisplayBean.getSocietyMonthlyShare()));
			shareAccount.setSacFine(0);
		}
		else {
			shareAccount.setSacBalance(customerRegistrationDisplayBean.getSocietyCurrentMonth() * customerRegistrationDisplayBean.getSocietyMonthlyShare());
			shareAccount.setSacFine(customerRegistrationDisplayBean.getLateOpeningCharge());
		}
		
		shareAccount.setSacRemMonth(Byte.valueOf("0"));
		shareAccount.setSacOpenedBy(username);
		shareAccount.setSacOpened(currentTimestamp);
		
		//Save Customer Account
		CustomerAccount customerAccount = new CustomerAccount();
			
		customerAccount.setCacCdeId(customerDetail.getCdeId());
		customerAccount.setCacOpeningBal(shareAccount.getSacBalance());
		customerAccount.setCacOpeningMonth(customerRegistrationDisplayBean.getSocietyCurrentMonth());
		customerAccount.setCacApplicationFee(customerRegistrationDisplayBean.getSocietyApplicationFee());
		customerAccount.setCacLoanGuarantorCount(new Byte("0"));
		customerAccount.setCacActive(new Byte("1"));
		customerAccount.setCacOpenedBy(username);
		customerAccount.setCacOpened(currentTimestamp);
		customerAccount.setShareAccount(shareAccount);
		customerAccount.setCustomerDetail(customerDetail);
			
		customerAccount = customerAccountRepository.save(customerAccount);
			
		if(customerAccount != null && customerAccount.getCacId() != null && customerAccount.getCacId().intValue() > 0) {
			return customerAccount;
		}
		return null;
	}
}
