package REPOSITORY;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Generic.Excel_data;

public class Shop_Page {
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
	@FindBy(id = "ctl00_mpBody_txtZipCode")
	WebElement FindProducts;
	@FindBy(id = "//h5[contains(text(),'Critical Illness Insurance')]")
	WebElement Critical_Illness_Insurance;
	@FindBy(id = "//h5[contains(text(),'Accident Insurance')]")
	WebElement Accident_Insurance;
	@FindBy(id = "//h5[contains(text(),'Cancer Insurance')]")
	WebElement Cancer_Insurance;
	@FindBy(id="ctl00_mpBody_productsList_repeatProducts_ctl01_btnLearnMore")
	WebElement Critical_Getplans;
	@FindBy(xpath = "//a[@id='ctl00_mpBody_productsList_repeatProducts_ctl03_btnLearnMore']")
	WebElement Accident_Getplans;
	@FindBy(xpath = "//a[@id='ctl00_mpBody_productsList_repeatProducts_ctl05_btnLearnMore']")
	WebElement Cancer_Getplans;

	public Shop_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void Choose_Critical() throws IOException, InterruptedException {
		excel = new Excel_data();
//		WebDriverWait w1 = new WebDriverWait(driver, 10);
//		WebElement Popup_Zipcode1= w1.until(ExpectedConditions.visibilityOf(Critical_Getplans));
		Popup_Zipcode.sendKeys(excel.Get_Data(0,1));
		log.info("Entered zipcode");
		Popup_Next.click();
		log.info("Clicked on next button");
//		WebDriverWait w2 = new WebDriverWait(driver, 10);
//		WebElement Critical_Getplans1= w2.until(ExpectedConditions.elementToBeClickable(By.id("//a[@id='ctl00_mpBody_productsList_repeatProducts_ctl01_btnLearnMore']")));
		Thread.sleep(5000);
		Critical_Getplans.click();
		log.info("Clicked on  Critical illness's get plan button");
	}	

	public void Choose_Accident() throws IOException, InterruptedException {
		excel = new Excel_data();
		Popup_Zipcode.sendKeys(excel.Get_Data(0,1));
		log.info("Entered zipcode");
		Popup_Next.click();
		log.info("Clicked on next button");
		Thread.sleep(5000);
		Accident_Getplans.click();
		log.info("Clicked on  Accident Insurance's get plan button");
	}	
	
	public void Choose_Cancer() throws IOException, InterruptedException {
		excel = new Excel_data();
		Popup_Zipcode.sendKeys(excel.Get_Data(0,1));
		log.info("Entered zipcode");
		Popup_Next.click();
		log.info("Clicked on next button");
		Thread.sleep(5000);
		Cancer_Getplans.click();
		log.info("Clicked on Cancer Insurance's get plan button");
	}

}
