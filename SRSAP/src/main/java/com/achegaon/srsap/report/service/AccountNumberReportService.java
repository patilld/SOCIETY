package com.achegaon.srsap.report.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.achegaon.srsap.domain.CustomerAccount;
import com.achegaon.srsap.repository.CustomerAccountRepository;
import com.achegaon.srsap.util.CustomerServiceUtils;
import com.achegaon.srsap.util.ReportUtils;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * The AccountNumberReportService for AccountNumberReportController
 * 
 * @author Lalit Patil Freelancer
 * @version $1.0 $, $Date: 29-08-2018 $
 * 
 */

@Service
public class AccountNumberReportService {
	
	@Autowired
	private CustomerAccountRepository customerAccountRepository;
	
	@Autowired
	private CustomerServiceUtils customerServiceUtils;
	
	@Autowired
	private ReportUtils reportUtils;
	
	@Value("${accountNumber.startFrom}")
	private Integer accountNumberStartFrom;
	
	@Value("${srsap.directory}")
	private String srsapDirectory;
	
	public List<CustomerAccount> getCustomerAccount() {
		return customerAccountRepository.findCustomerAccountByOrderByCustomerDetail_CdeFirstNameAsc();
	}
	
	class HeaderFooter extends PdfPageEventHelper {
	    
		public void onStartPage(PdfWriter writer, Document document) {
	    	Font header = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLDITALIC);
	    	PdfContentByte cb = writer.getDirectContent();
	    	Phrase header1 = new Phrase("Shreeram Society Achegaon Pune", header);
	    	ColumnText.showTextAligned(cb, Element.ALIGN_CENTER, header1, (document.right() - document.left()) / 2 + document.leftMargin(), document.top() + 20, 0);
	    	Font fheader = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLDITALIC);
	    	Phrase header2 = new Phrase("Account number", fheader);
	    	ColumnText.showTextAligned(cb, Element.ALIGN_CENTER, header2, (document.right() - document.left()) / 2 + document.leftMargin(), document.top() + 5, 0);
	    }

	    public void onEndPage(PdfWriter writer, Document document) {
	    	Font ffooter = new Font(Font.FontFamily.TIMES_ROMAN, 5, Font.BOLDITALIC);
	    	PdfContentByte cb = writer.getDirectContent();
	        Phrase footer = new Phrase("Shreeram Society Achegaon Pune", ffooter);
	        ColumnText.showTextAligned(cb, Element.ALIGN_CENTER, footer, (document.right() - document.left()) / 2 + document.leftMargin(), document.bottom() - 10, 0);
	    }
	}

	
	public void createAccountNumberPDFReport(HttpServletResponse response) {
		File reportDirectory = new File(srsapDirectory + "/Report");
		if(!reportDirectory.exists()) {
			reportDirectory.mkdirs();
		}
		
		Document document = new Document(PageSize.A4, 36, 36, 60, 36);
		try {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(reportDirectory + "/AccountNumber.pdf"));
			
			// Add header and footer
			HeaderFooter event = new HeaderFooter();
			writer.setPageEvent(event);
			
			// Open document
			document.open();
			
			// Add data table
			document.add(createPdfTable());
			
			// Close document
			document.close();
			
			// Download file
			reportUtils.downloadFile(response, new File(reportDirectory + "/AccountNumber.pdf"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			
			File file = new File(reportDirectory + "/AccountNumber.pdf");
			if(file.exists()) {
				file.delete();
			}
		}
	}
	
	public PdfPTable createPdfTable() throws DocumentException {
		
		List<CustomerAccount> customerAccountList = customerAccountRepository.findCustomerAccountByOrderByCustomerDetail_CdeFirstNameAsc();
		
		PdfPTable table = new PdfPTable(3);
		table.setWidths(new int[]{1, 3, 2});
		PdfPCell cell;
		Font tableHeaderFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLDITALIC);
		Font tableDataFont = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.ITALIC);
		cell = new PdfPCell(new Phrase("Sr. No", tableHeaderFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
        
		cell = new PdfPCell(new Phrase("Customer Name", tableHeaderFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase("Account Number", tableHeaderFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
        int i = 0;
        for(CustomerAccount customerAccount : customerAccountList) {
        	
        	i = i + 1;
        	cell = new PdfPCell(new Phrase(Integer.toString(i), tableDataFont));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
        	
        	String customerName = customerAccount.getCustomerDetail().getCdeTitle() + " " + customerAccount.getCustomerDetail().getCdeFirstName() + " " + customerAccount.getCustomerDetail().getCdeMiddleName() + " "+ customerAccount.getCustomerDetail().getCdeLastName();
        	cell = new PdfPCell(new Phrase(customerName, tableDataFont));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            
            String customerAccountNumber = customerServiceUtils.getCustomerAccountNumber(customerAccount, accountNumberStartFrom);
            cell = new PdfPCell(new Phrase(customerAccountNumber, tableDataFont));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
        }
		return table;
	}

}
