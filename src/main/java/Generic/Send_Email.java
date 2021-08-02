package Generic;

import java.io.IOException;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

import REPOSITORY.Thank_you;

public class Send_Email {

	public void Send_Email_method(String thankyou, String reference_NO, String total_Price, String productTitle,
			String productcode, String producttier) throws EmailException, IOException {
		// public static void main(String[] args) throws EmailException,
		// IOException{
		Excel_data excel;
		Thank_you th;
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath("E:/SELENIUM/SPRAOI/AFLAC/test-output/emailable-report.html");
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("Aflac DEV Automation End Result");
		attachment.setName("Test_Report");

//		Email email = new SimpleEmail();
		MultiPartEmail email = new MultiPartEmail();
		excel = new Excel_data();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator(excel.Get_Data(59, 1), excel.Get_Data(60, 1)));
		email.setSSLOnConnect(true);
		email.setFrom(excel.Get_Data(59, 1), excel.Get_Data(59, 2));
		email.setSubject(excel.Get_Data(69, 1));

		email.setMsg(
				"Dear All,\n\nBelow is the Aflac DEV storefront's automation test result,\n\n*Product purchased successefully\n*Purchased Product is \"productTitle\".\n*Product code is \"productcode\"and Product tier is \"producttier\"\n*Price is \"total_Price\"\n*Reference number is \"reference_NO\"\n\nRegards,\nTesting Team");
		// email.addCc("abhishek.bhat@spraoi.ai");
		 email.addTo("kyogesh@empoweredbenefits.com");
		 email.addTo("kishormy1991@gmail.com");
		email.addTo(excel.Get_Data(61, 1));
		email.attach(attachment);
		email.send();
	}

}
