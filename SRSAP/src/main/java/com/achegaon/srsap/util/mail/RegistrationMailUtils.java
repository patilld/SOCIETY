package com.achegaon.srsap.util.mail;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.achegaon.srsap.domain.CustomerAccount;


@Component
public class RegistrationMailUtils {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private TemplateEngine templateEngine;
	
	@Value("${accountNumber.startFrom}")
	private Integer accountNumberStartFrom;
	
	public Boolean customerRegistrationMail(CustomerAccount customerAccount) throws UnsupportedEncodingException, MessagingException {
		
	if(customerAccount != null && customerAccount.getCustomerDetail() != null && customerAccount.getCustomerDetail().getAddress() != null && customerAccount.getCustomerDetail().getAddress().getAddEmail() != null) {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(message);
		
        messageHelper.setFrom("lalit.patil1144@gmail.com", "Lalit Patil");
	        
        messageHelper.setTo(customerAccount.getCustomerDetail().getAddress().getAddEmail());
        messageHelper.setSubject("Shreeram society Account opened");
        String html = build(customerAccount);
        messageHelper.setText(html, true);
	    try {
	    	javaMailSender.send(message);
	    } catch (MailException e) {
	       e.printStackTrace();
	    }
	}
	
		
		return false;
	}
	
	public String build(CustomerAccount customerAccount) {
		final Context ctx = new Context();
	    ctx.setVariable("name", customerAccount.getCustomerDetail().getCdeFirstName() + " " + customerAccount.getCustomerDetail().getCdeLastName());
	    ctx.setVariable("customerAccount", customerAccount);
	    ctx.setVariable("accountNumberStartFrom", accountNumberStartFrom);
	    return this.templateEngine.process("Mail/customerregistrationmail", ctx);
    }
}
