package REPOSITORY;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.mail.EmailException;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.Excel_data;
import Generic.Send_Email;

public class Thank_you {

	Logger log = Logger.getLogger(Logs.class);
	WebDriver driver;
	Excel_data excel;
	Send_Email send;
	
	@FindBy(id = "ctl00_hl_logoImage1")
	WebElement Aflac_Logo;
	@FindBy(id = "ctl00_rep_nav_ctl00_hlNav")
	WebElement Shop;
	@FindBy(id = "ctl00_rep_nav_ctl01_hlNav")
	WebElement Contact_us;
	@FindBy(id = "ctl00_rep_nav_ctl02_hlNav")
	WebElement FAQ;
	@FindBy(id = "ctl00_HyperLink1")
	WebElement Cart;
	@FindBy(id = "highContrast")
	WebElement Contrast_Toggle;
	@FindBy(id = "ctl00_rep_nav_ctl03_hlNav")
	WebElement Signout;

	@FindBy(tagName = "h3")
	WebElement Thankyou;
	@FindBy(xpath = "//h4/span[starts-with(text(),'Reference')]")
	WebElement Reference_NO;
	@FindBy(id = "ctl00_mpBody_orderDetails1_rep_order_ctl00_rep_subitems_ctl01_rptDocuments_ctl00_cbDownloadAgreement")
	WebElement Aknowledge_doc;
	@FindBy(id = "ctl00_mpBody_orderDetails1_rep_order_ctl00_rep_subitems_ctl02_lblTotal")
	WebElement Total_Price;
	@FindBy(xpath = "//div[@class='productTitle']")
	WebElement ProductTitle;
	@FindBy(xpath = "//div[@class='productCode']")
	WebElement productCode;
	@FindBy(xpath = "//div[@class='productTier']")
	WebElement productTier;

	public Thank_you(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void Check_Thank_you_Page() throws IOException, InterruptedException, EmailException {
		send = new Send_Email();
		Aknowledge_doc.click();
		log.info(Thankyou.getText());
		log.info(Reference_NO.getText());
		log.info("Total price of the product is " + Total_Price.getText());
		log.info("Product Title is " + "\"" + ProductTitle.getText() + "\"");
		log.info("Product Code is " + "\"" + productCode.getText() + "\"");
		log.info("Product Tier is " + "\"" + productTier.getText() + "\"");
		String thankyou = Thankyou.getText();
		String reference_NO = Reference_NO.getText();
		String total_Price = Total_Price.getText();
		String productTitle = ProductTitle.getText();
		String productcode = productCode.getText();
		String producttier = productTier.getText();
		Thread.sleep(20000);
		send.Send_Email_method(thankyou,reference_NO,total_Price,productTitle,productcode,producttier);
	}

}
