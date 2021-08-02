package REPOSITORY;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Generic.Excel_data;

public class Accident_Page {
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
	WebElement Adv_A_Plan;
	@FindBy(xpath = "//a[@id='ctl00_mpBody_ctl02_rptPlanInfo_ctl02_rptPaymentSchedules_ctl01_lbSeeOptions']")
	WebElement Adv_B_Plan;
	@FindBy(id = "ctl00_mpBody_ctl02_btnContinue")
	WebElement Next;

	public Accident_Page(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}

	public void GetAccident_AdvantageA() throws IOException, InterruptedException {
		excel = new Excel_data();
		Thread.sleep(2000);
		FindPlan_dev.click();
		log.info("Clicked on FIND YOUR PLAN AND GET A QUOTE button");
		DateOfBirth.sendKeys(excel.Get_Data(1, 1));
		My_Spouse.click();
		log.info("Clicked on MY SPOUSE checkbox");
		My_Children.click();
		log.info("Clicked on MY CHILDREN checkbox");
		Get_Quote.click();
		log.info("Clicked on GET QUOTE button");
		Thread.sleep(2000);
		Adv_A_Plan.click();
		log.info("Selected \"Monthly Payments of $51.07 PLAN\"");
		Thread.sleep(2000);
		Next.click();
		log.info("Clicked on NEXT button");
		Thread.sleep(2000);
	}
	public void GetAccident_AdvantageB() throws IOException, InterruptedException {
		excel = new Excel_data();
		Thread.sleep(2000);
		FindPlan_dev.click();
		log.info("Clicked on FIND YOUR PLAN AND GET A QUOTE button");
		DateOfBirth.sendKeys(excel.Get_Data(1, 1));
		My_Spouse.click();
		log.info("Clicked on MY SPOUSE checkbox");
		My_Children.click();
		log.info("Clicked on MY CHILDREN checkbox");
		Get_Quote.click();
		log.info("Clicked on GET QUOTE button");
		Thread.sleep(2000);
		Adv_B_Plan.click();
		log.info("Selected \"Monthly Payments of $58 PLAN\"");
		Thread.sleep(2000);
		Next.click();
		log.info("Clicked on NEXT button");
		Thread.sleep(2000);
	}
}
