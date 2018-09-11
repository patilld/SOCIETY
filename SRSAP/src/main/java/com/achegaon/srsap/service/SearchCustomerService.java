package com.achegaon.srsap.service;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.achegaon.srsap.domain.CustomerAccount;
import com.achegaon.srsap.form.SearchCustomerForm;
import com.achegaon.srsap.repository.CustomerAccountRepository;
import com.achegaon.srsap.sessionbean.SessionBean;
import com.achegaon.srsap.util.CustomerServiceUtils;

/**
 * The SearchCustomerService for SearchCustomerController
 * 
 * @author Lalit Patil Freelancer
 * @version $1.0 $, $Date: 01-09-2018 $
 * 
 */

@Service
public class SearchCustomerService {
	
	@Autowired
	private CustomerAccountRepository customerAccountRepository;
	
	@Autowired
	private CustomerServiceUtils customerServiceUtils;
	
	@Value("${accountNumber.startFrom}")
	private Integer accountNumberStartFrom;
	
	@Value("${srsap.directory}")
	private String directory;
	
	public CustomerAccount selectCustomer(SessionBean sb, Integer cacId) {
		if(cacId != null && cacId.intValue() > 0) {
			Optional<CustomerAccount> optCustomerAccount = customerAccountRepository.findById(cacId);
			
			if(optCustomerAccount.isPresent()) {
				//Store the cacId in session
				CustomerAccount customerAccount = optCustomerAccount.get();
				sb.setCacId(customerAccount.getCacId());
				
				return customerAccount;
			}
		}
		return null;
	}
	
	public List<CustomerAccount> searchCustomerList(SearchCustomerForm searchCustomerForm) {
		if(searchCustomerForm != null) {
			CustomerAccount customerAccount = customerServiceUtils.getCustomerAccountByCustomerAccountNumber(customerAccountRepository, searchCustomerForm.getCacNumber(), accountNumberStartFrom);
			Integer cacId = null;
			if(customerAccount != null) {
				cacId = customerAccount.getCacId();
			}
			
			return customerAccountRepository.searchCustomerBySearchCriteria(cacId, searchCustomerForm.getCdeFirstName(), searchCustomerForm.getCdeLastName());
		}
		return null;
	}
	
	public String getImageDataURL(Integer cacId) {
		// Patient image
		// Create Directory if does not exist
		File customerPhotoFile = null;
		String filename = "pic_"+ cacId;
		String customerPhotoDirectoryPath = directory + "customer_photos\\";
		File customerPhotoDirectory = new File(customerPhotoDirectoryPath);
		if(customerPhotoDirectory.exists()){
			File bmpFormat = new File(customerPhotoDirectory, filename+".bmp");
			File gifFormat = new File(customerPhotoDirectory, filename+".gif");
			File jpeFormat = new File(customerPhotoDirectory, filename+".jpe");
			File jpegFormat = new File(customerPhotoDirectory, filename+".jpeg");
			File jpgFormat = new File(customerPhotoDirectory, filename+".jpg");
			
			if(bmpFormat.exists()){
				customerPhotoFile = bmpFormat;
			}
			
			if(gifFormat.exists()){
				customerPhotoFile = gifFormat;
			}
			
			if(jpeFormat.exists()){
				customerPhotoFile = jpeFormat;
			}
			
			if(jpegFormat.exists()){
				customerPhotoFile = jpegFormat;
			}
			
			if(jpgFormat.exists()){
				customerPhotoFile = jpgFormat;
			}
				
			if(customerPhotoFile != null && customerPhotoFile.exists()) {
				try {
					byte[] bytearray = new byte[(int)customerPhotoFile.length()];
		    		FileInputStream is = new FileInputStream(customerPhotoFile);
		    		is.read(bytearray);
		    		byte[] encoded=Base64.encodeBase64(bytearray);
		    		String DataUrl = new String(encoded);
		    		is.close();
		    		String imageDataUrl = "data:image/jpeg;base64,"+ DataUrl;
		    		return imageDataUrl;
				}
	    		catch (Exception e) {
	    			
				}
	    	}
		}
		
		return "/images/patient.png";
	}
}
