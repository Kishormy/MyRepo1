package REPOSITORY;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Generic.Excel_data;

public class Critical_Illness_page {
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
	@FindBy(xpath ="//img[@id='ctl00_mpBody_imgLogoFullWidth']")
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
	WebElement $10K_Plan;
	@FindBy(xpath = "//a[@id='ctl00_mpBody_ctl02_rptPlanInfo_ctl01_rptPlanInfoChildren_ctl01_rptPaymentSchedulesChildren_ctl01_lbSeeOptions']")
	WebElement $10K_Plan_Benfits;
	@FindBy(xpath = "//a[@id='ctl00_mpBody_ctl02_rptPlanInfo_ctl02_rptPaymentSchedules_ctl01_lbSeeOptions']")
	WebElement $15K_Plan;
	@FindBy(xpath = "//a[@id='ctl00_mpBody_ctl02_rptPlanInfo_ctl02_rptPlanInfoChildren_ctl01_rptPaymentSchedulesChildren_ctl01_lbSeeOptions']")
	WebElement $15K_Plan_Benfits;
	@FindBy(xpath = "//a[@id='ctl00_mpBody_ctl02_rptPlanInfo_ctl03_rptPaymentSchedules_ctl01_lbSeeOptions']")
	WebElement $20K_Plan;
	@FindBy(xpath = "//a[@id='ctl00_mpBody_ctl02_rptPlanInfo_ctl03_rptPlanInfoChildren_ctl01_rptPaymentSchedulesChildren_ctl01_lbSeeOptions']")
	WebElement $20K_Plan_Benfits;
	@FindBy(xpath = "//a[contains(text(),'Next')]")
	WebElement Next;
	
		
	
	public Critical_Illness_page(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}
	
	public void GetCriticalQuote() throws IOException, InterruptedException{
		PropertyConfigurator.configure(".//Test_data//log4j.properties");
		excel = new Excel_data();
		Thread.sleep(2000);
		FindPlan_dev.click();
		log.info("Clicked on FIND YOUR PLAN AND GET A QUOTE button");
		DateOfBirth.sendKeys(excel.Get_Data(1,1));
		log.info("Entered DOB");
		Select hsa = new Select(HSA);
		hsa.selectByVisibleText("No");	
		log.info("Selected NO for the question \"I have a Health Savings Account (HSA)? \"");
		Select tobacco = new Select(Tobacco);
		tobacco.selectByVisibleText("No");	
		log.info("Selected NO for the question \"Has anyone to be covered used tobacco products or products containing nicotine of any type in the last 12 months? \"");
		Get_Quote.click();		
		log.info("Clicked on GET QUOTE button");
		Thread.sleep(2000);
		$10K_Plan.click();
		log.info("Selected \"Monthly Payments of $10.67 PLAN\" under \"$10K cash diagnosis benefit Individual Only\"");
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
//		actions.moveToElement(Next).click().build().perform();
		Next.click();
		log.info("Clicked on NEXT button");
		Thread.sleep(2000);
	}	
	
	public void GetCriticalQuote2() throws IOException, InterruptedException{
		PropertyConfigurator.configure(".//Test_data//log4j.properties");
		excel = new Excel_data();
		FindPlan_dev.click();
		log.info("Clicked on FIND YOUR PLAN AND GET A QUOTE button");
		DateOfBirth.sendKeys(excel.Get_Data(1,1));
		log.info("Entered DOB");
		Select hsa = new Select(HSA);
		hsa.selectByVisibleText("No");	
		log.info("Selected NO for the question \"I have a Health Savings Account (HSA)? \"");
		Select tobacco = new Select(Tobacco);
		tobacco.selectByVisibleText("No");	
		log.info("Selected NO for the question \"Has anyone to be covered used tobacco products or products containing nicotine of any type in the last 12 months? \"");
		Get_Quote.click();		
		log.info("Clicked on GET QUOTE button");
		Thread.sleep(2000);
		$10K_Plan.click();
		log.info("Selected \"Monthly Payments of $10.67 PLAN\" under \"$10K cash diagnosis benefit Individual Only\"");
		Thread.sleep(2000);
		Next.click();
		log.info("Clicked on NEXT button");
		Thread.sleep(2000);
	}	
}
