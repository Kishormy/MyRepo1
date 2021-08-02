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
import junit.framework.Assert;

public class Login_Page {

	Logger log = Logger.getLogger(Logs.class);
	Properties prop = new Properties();
	WebDriver driver;
	Excel_data excel;
	@FindBy(id = "ctl00_hl_logoImage1")
	WebElement Aflac_Logo;
	@FindBy(id = "ctl00_mpBody_txtZipCode")
	WebElement Zipcode;

	@FindBy(id = "ctl00_mpBody_txtZipCodeFromDialog")
	WebElement Popup_Zipcode;
	@FindBy(id = "ctl00_mpBody_btnZipCodeOk")
	WebElement Popup_Next;
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
	@FindBy(id = "ctl00_mpBody_ucAccountInformation_btnRegister")
	WebElement Verify_Demographics;
	@FindBy(id = "ctl00_mpBody_ucAccountInformation_btnModalErrorAddressUseMy")
	WebElement UseSameAddress;
	
	

	@FindBy(id = "ctl00_mpBody_login1_EmailAddress_txtEmailAddress")
	WebElement Email;
	@FindBy(id = "ctl00_mpBody_login1_loginPassword")
	WebElement Password;
	@FindBy(id = "ctl00_mpBody_login1_btn_login")
	WebElement Sign_in_btn;
	@FindBy(xpath = "//li[contains(text(),'Password is Required.')]")
	WebElement Password_req;
	@FindBy(xpath = "//li[contains(text(),'Email Address is Required.')]")
	WebElement EMail_req;
	@FindBy(xpath = "//li[contains(text(),'Invalid login.')]")
	WebElement Invalid_login;

	public Login_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void Valid_Login() throws IOException {
		excel = new Excel_data();
		Email.sendKeys(excel.Get_Data(27, 1));
		Password.sendKeys(excel.Get_Data(28, 1));
		Sign_in_btn.click();
		Assert.assertTrue("Logged -in Successfully", driver.getTitle().contains("Verfiy Demographics"));
	}
	
	
	public void send_email() throws IOException{
		Email.sendKeys(excel.Get_Data(27, 1));
			}
	
	public void Valid_Login_Purchase() throws IOException, InterruptedException {
		excel = new Excel_data();
		Email.sendKeys(excel.Get_Data(71, 1));
		Password.sendKeys(excel.Get_Data(16, 1));
		Sign_in_btn.click();
		Thread.sleep(5000);
		Verify_Demographics.click();
		Thread.sleep(11000);
		UseSameAddress.click();
		log.info("Clicked on USE SAME ADDRESS");
		Thread.sleep(12000);
	}

	public void InValid_Login() throws IOException {
		excel = new Excel_data();
		Email.clear();
		Password.clear();
		Email.sendKeys(excel.Get_Data(29, 1));
		Password.sendKeys(excel.Get_Data(30, 1));
		Sign_in_btn.click();
		Assert.assertTrue("Validated", Invalid_login.isDisplayed());
	}

	public void Validation_Login() throws IOException {
		excel = new Excel_data();
		Email.clear();
		Password.clear();
		Email.sendKeys("");
		Password.sendKeys("");
		Sign_in_btn.click();
		Assert.assertTrue("Validated", (EMail_req.isDisplayed() && Password_req.isDisplayed()));
	}
}
