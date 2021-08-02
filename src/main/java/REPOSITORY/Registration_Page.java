package REPOSITORY;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Generic.Excel_data;

public class Registration_Page {
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

	@FindBy(id = "ctl00_mpBody_lnkLogin")
	WebElement Sign_In;
	@FindBy(id="firstname")
	WebElement Firstname;
	@FindBy(id = "middleinitial")
	WebElement MIddle_Intial;
	@FindBy(id = "lastname")
	WebElement LastName;
	@FindBy(id = "ctl00_mpBody_register1_BirthStateAbbr")
	WebElement BirthState;
	@FindBy(id = "GenderID")
	WebElement Gender;
	@FindBy(id = "Address1")
	WebElement Address1;
	@FindBy(id = "Address2")
	WebElement Address2;
	@FindBy(id = "City")
	WebElement City;
	@FindBy(id = "StateAbbr")
	WebElement State;
	@FindBy(id = "ctl00_mpBody_register1_phone_txtPhoneNumber")
	WebElement Phone1;
	@FindBy(id = "phonetype")
	WebElement Phonetype1;
	@FindBy(id = "ctl00_mpBody_register1_phone2_txtPhoneNumber")
	WebElement Phone2;
	@FindBy(id = "ctl00_rep_nav_ctl02_hlNav")
	WebElement Phonetype2;
	@FindBy(id = "ctl00_mpBody_register1_emailAddress_txtEmailAddress")
	WebElement EMail1;
	@FindBy(id = "ctl00_mpBody_register1_emailAddress2_txtEmailAddress")
	WebElement EMail2;
	@FindBy(id = "LoginPWD")
	WebElement LoginPWD;
	@FindBy(id = "LoginPWD2")
	WebElement LoginPWD2;
	@FindBy(id = "SecurityQuestion")
	WebElement SecurityQuestion;
	@FindBy(id = "SecurityQuestionAnswer")
	WebElement Answer;
	@FindBy(id = "ctl00_mpBody_register1_chkAcknowledgeRegistrationTerms")
	WebElement Aknowledge_Register;
	@FindBy(id = "ctl00_mpBody_register1_ddlCustomerCorrespondenceDeliveryMethodPaper")
	WebElement Delivery_Preference;
	@FindBy(id = "ctl00_mpBody_register1_btnRegister")
	WebElement Next;
	@FindBy(id = "ctl00_mpBody_register1_btnModalErrorAddressUseMy")
	WebElement UseSameAddress;
	

	public Registration_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void Fill_Customer_details() throws IOException, InterruptedException {
		PropertyConfigurator.configure(".//Test_data//log4j.properties");
		Random random = new Random();		
		int postfix = random.nextInt(50000);
		String email = "User"+postfix+"@aflactest.com";
		excel = new Excel_data();
		excel.Write_Data(71, 1, email);
		Firstname.sendKeys(excel.Get_Data(2,1));
		MIddle_Intial.sendKeys(excel.Get_Data(3,1));
		LastName.sendKeys(excel.Get_Data(4,1));
		Select Bstate = new Select(BirthState);
		Bstate.selectByVisibleText(excel.Get_Data(5,1));
		Select gender = new Select(Gender);
		gender.selectByVisibleText(excel.Get_Data(6,1));		
		Address1.sendKeys(excel.Get_Data(7,1));
		Address2.sendKeys(excel.Get_Data(8,1));
		City.sendKeys(excel.Get_Data(9,1));
		Select state = new Select(State);
		state.selectByVisibleText(excel.Get_Data(10,1));
		log.info("Customer EMail is "+email);
		Phone1.sendKeys(excel.Get_Data(12,1));
		Phone2.sendKeys(excel.Get_Data(13,1));
		Phonetype1.sendKeys(excel.Get_Data(14,1));
		Phonetype2.sendKeys(excel.Get_Data(15,1));
		EMail1.sendKeys(email);
		EMail2.sendKeys(email);
		LoginPWD.sendKeys(excel.Get_Data(16,1));
		LoginPWD2.sendKeys(excel.Get_Data(16,1));
		Select securityQuestion = new Select(SecurityQuestion);
		securityQuestion.selectByVisibleText(excel.Get_Data(18,1));
		Answer.sendKeys(excel.Get_Data(19,1));
		Aknowledge_Register.click();
		Select delivery_Preference = new Select(Delivery_Preference);
		delivery_Preference.selectByVisibleText(excel.Get_Data(20,1));
		log.info("Entered customer details");
		Next.click();
		log.info("Clicked on NEXT button");
		Thread.sleep(12000);
		UseSameAddress.click();
		log.info("Clicked on USE SAME ADDRESS");
		Thread.sleep(12000);

		
	}

	public void Click_Sign_In() throws InterruptedException  {

		Sign_In.click();
		Thread.sleep(5000);
	}

}
