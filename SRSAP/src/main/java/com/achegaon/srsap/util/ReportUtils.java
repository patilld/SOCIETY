package com.achegaon.srsap.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

/**
 * The ReportUtils
 * 
 * @author Lalit Patil Freelancer
 * @version $1.0 $, $Date: 28-08-2018 $
 * 
 */

@Component
public class ReportUtils {
	
	public String downloadFile(HttpServletResponse response, File filePath) throws IOException {
		
    	if(filePath.exists()) {
    		File fr = new File(filePath.getAbsolutePath());
    		response.setContentType("application/pdf");
    		response.setHeader("Content-Disposition", "attachment; filename=" + filePath.getName());
    		OutputStream os = null;
    		FileInputStream fis = null;
    		try {
	    		os = response.getOutputStream();
	    		fis = new FileInputStream(fr);
	    		byte fileContent[] = new byte[(int) filePath.length()];
	    		fis.read(fileContent);
	    		os.write(fileContent);
	    		os.flush();
    		}
    		catch(Exception e) {
    			e.printStackTrace();
    		}
    		finally {
    			if(os != null) {
    				os.close();
    			}
    			if(fis != null) {
    				fis.close();
    			}
    		}
    	}
	    return null;
	}
}
