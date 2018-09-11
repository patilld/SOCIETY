package com.achegaon.srsap.util.locale;

/**
 * This is the MessageByLocaleService for accessing messageSource
 * 
 * @author Lalit Patil Freelancer
 * @version $1.0 $, $Date: 26-08-2018 $
 * 
 */

public interface MessageByLocaleService {

	public String getMessage(String id);
	public String getMessage(String id, Object args[]);
}
