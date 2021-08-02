package REPOSITORY;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.Excel_data;

public class Review_Submit {
	Logger log = Logger.getLogger(Logs.class);
	Properties prop = new Properties();
	WebDriver driver;
	Excel_data excel;
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
	

	@FindBy(id = "ctl00_mpBody_btnCheckout")
	WebElement submit;	
	@FindBy(xpath = "//a[Contains(text(),'Change Payment Method')]")
	WebElement Change_PM;	
	@FindBy(id = "ctl00_mpBody_cicCartItems_RepeaterCartItems_ctl01_hlEdit")
	WebElement Change;	
	@FindBy(id = "ctl00_mpBody_cicCartItems_RepeaterCartItems_ctl01_hlDelete")
	WebElement Remove;
	
	
	public Review_Submit(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void Review_Submit_Method() throws IOException, InterruptedException {
		submit.click();
		log.info("Order is submited");
		Thread.sleep(8000);
		log.info("Order is in progress");
	    Thread.sleep(8000);
	}
}
