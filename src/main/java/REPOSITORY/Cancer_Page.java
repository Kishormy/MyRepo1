package REPOSITORY;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.Excel_data;

public class Cancer_Page {
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
	@FindBy(xpath = "//img[@id='ctl00_mpBody_imgLogoFullWidth']")
	WebElement criticalHeroimage;
	@FindBy(xpath = "ctl00_rep_nav_ctl03_hlNav")
	WebElement Signout;

	@FindBy(id = "btnGetPlanQuote")
	WebElement FindPlan_dev;
	@FindBy(xpath = "//a[@class='btn btn-primary btn-orange btn-padding low-contrast']")
	WebElement FindPlan_qa;
	@FindBy(id = "txtDateOfBirth")
	WebElement DateOfBirth;
	@FindBy(id = "ctl00_mpBody_ctl02_ddlExposureCustomAttribute1")
	WebElement HSA;
	@FindBy(id = "ctl00_mpBody_ctl02_ddlExposureTobaccoUse")
	WebElement Tobacco;
	@FindBy(id = "ctl00_mpBody_ctl02_chkTierSelectionSpouse")
	WebElement My_Spouse;
	@FindBy(id = "ctl00_mpBody_ctl02_chkTierSelectionChildren")
	WebElement My_Children;
	@FindBy(xpath = "//input[@id='ctl00_mpBody_ctl02_btnGetRates']")
	WebElement Get_Quote;

	@FindBy(xpath = "//a[@id='ctl00_mpBody_ctl02_rptPlanInfo_ctl01_rptPaymentSchedules_ctl01_lbSeeOptions']")
	WebElement Option1_Plan;
	@FindBy(xpath = "//a[@id='ctl00_mpBody_ctl02_rptPlanInfo_ctl02_rptPaymentSchedules_ctl01_lbSeeOptions']")
	WebElement Option2_Plan;
	@FindBy(xpath = "//a[@id='ctl00_mpBody_ctl02_rptPlanInfo_ctl03_rptPaymentSchedules_ctl01_lbSeeOptions']")
	WebElement Option3_Plan;
	@FindBy(id = "ctl00_mpBody_ctl02_btnContinue")
	WebElement Next;

	public Cancer_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void Get_Cancer_Option_1() throws IOException, InterruptedException {
		excel = new Excel_data();
		Thread.sleep(2000);
		FindPlan_dev.click();
		log.info("Clicked on FIND YOUR PLAN AND GET A QUOTE button");
		DateOfBirth.sendKeys(excel.Get_Data(1, 1));
		// My_Spouse.click();
		// log.info("Clicked on MY SPOUSE checkbox");
		// My_Children.click();
		// log.info("Clicked on MY CHILDREN checkbox");
		Get_Quote.click();
		log.info("Clicked on GET QUOTE button");
		Thread.sleep(2000);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,1000)");
		Get_Quote.click();
		Thread.sleep(2000);
		Option1_Plan.click();
		log.info("Selected \"Monthly Payments of $16.93 PLAN\"");
		Thread.sleep(2000);
		Next.click();
		log.info("Clicked on NEXT button");
		Thread.sleep(2000);
	}

	public void Get_Cancer_Option_2() throws IOException, InterruptedException {
		excel = new Excel_data();
		Thread.sleep(2000);
		FindPlan_dev.click();
		log.info("Clicked on FIND YOUR PLAN AND GET A QUOTE button");
		DateOfBirth.sendKeys(excel.Get_Data(1, 1));
		// My_Spouse.click();
		// log.info("Clicked on MY SPOUSE checkbox");
		// My_Children.click();
		// log.info("Clicked on MY CHILDREN checkbox");
		Get_Quote.click();
		log.info("Clicked on GET QUOTE button");
		Thread.sleep(2000);
		Option2_Plan.click();
		log.info("Selected \"Monthly Payments of $33.50 PLAN\"");
		Thread.sleep(2000);
		Next.click();
		log.info("Clicked on NEXT button");
		Thread.sleep(2000);
	}

	public void Get_Cancer_Option_3() throws IOException, InterruptedException {
		excel = new Excel_data();
		Thread.sleep(2000);
		FindPlan_dev.click();
		log.info("Clicked on FIND YOUR PLAN AND GET A QUOTE button");
		DateOfBirth.sendKeys(excel.Get_Data(1, 1));
		// My_Spouse.click();
		// log.info("Clicked on MY SPOUSE checkbox");
		// My_Children.click();
		// log.info("Clicked on MY CHILDREN checkbox");
		Get_Quote.click();
		log.info("Clicked on GET QUOTE button");
		Thread.sleep(2000);
		Option3_Plan.click();
		log.info("Selected \"Monthly Payments of $47.37 PLAN\"");
		Thread.sleep(2000);
		Next.click();
		log.info("Clicked on NEXT button");
		Thread.sleep(2000);
	}
}
