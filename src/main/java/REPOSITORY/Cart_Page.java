package REPOSITORY;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.Excel_data;

public class Cart_Page {
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
	@FindBy(xpath = "//a[@id='ctl00_HyperLink1']//span[@class='cart-img'][contains(text(),'Cart')]")
	WebElement Cart;
	@FindBy(xpath = "//button[@id='highContrast']")
	WebElement Contrast_Toggle;	
	@FindBy(xpath = "ctl00_rep_nav_ctl03_hlNav")
	WebElement Signout;
	
	@FindBy(id = "ctl00_mpBody_cicCartItems_RepeaterCartItems_ctl01_hlEdit")
	WebElement Change1;
	@FindBy(id = "ctl00_mpBody_cicCartItems_RepeaterCartItems_ctl01_hlDelete")
	WebElement Remove;
	@FindBy(id = "ctl00_mpBody_cicCartItems_RepeaterCartItems_ctl02_lblTotal")
	WebElement Total_price;
	@FindBy(id = "ctl00_mpBody_hlContinueShopping")
	WebElement Add_Products;
	@FindBy(id = "ctl00_mpBody_lbCheckout")
	WebElement Checkout;
	
	public Cart_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void Cart_Checkout() throws InterruptedException{
		log.info("Total Price is "+Total_price.getText());
		Checkout.click();
		Thread.sleep(5000);
	}
	
}
