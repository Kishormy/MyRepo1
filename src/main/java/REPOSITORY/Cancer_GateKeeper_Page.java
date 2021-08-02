package REPOSITORY;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cancer_GateKeeper_Page {
	Logger log = Logger.getLogger(Logs.class);
	Properties prop = new Properties();
	WebDriver driver;

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

	@FindBy(id = "ctl00_mpBody_gen_repeaterQuestions_ctl00_rblResponse_0")
	WebElement Q1_Yes;
	@FindBy(id = "ctl00_mpBody_gen_repeaterQuestions_ctl00_rblResponse_1")
	WebElement Q1_NO;
	@FindBy(id = "ctl00_mpBody_gen_repeaterQuestions_ctl01_repeaterDependentsList_ctl00_dlResponse_0")
	WebElement Q2_Yes;
	@FindBy(id = "ctl00_mpBody_gen_repeaterQuestions_ctl02_rblResponse_0")
	WebElement Q2_Yes_yes;
	@FindBy(id = "ctl00_mpBody_gen_repeaterQuestions_ctl02_rblResponse_1")
	WebElement Q2_Yes_no;
	@FindBy(id = "ctl00_mpBody_gen_repeaterQuestions_ctl01_repeaterDependentsList_ctl00_dlResponse_1")
	WebElement Q2_NO;
	@FindBy(id = "ctl00_mpBody_gen_repeaterQuestions_ctl03_rblResponse_0")
	WebElement Q3_Yes;
	@FindBy(id = "ctl00_mpBody_gen_repeaterQuestions_ctl03_rblResponse_1")
	WebElement Q3_NO;
	@FindBy(id = "ctl00_mpBody_gen_repeaterQuestions_ctl05_rblResponse_0")
	WebElement Q4_Yes;
	@FindBy(id = "ctl00_mpBody_gen_repeaterQuestions_ctl05_rblResponse_1")
	WebElement Q4_NO;
	@FindBy(id = "ctl00_mpBody_gen_repeaterQuestions_ctl09_repeaterDependentsList_ctl00_dlResponse_0")
	WebElement Q5_Yes;
	@FindBy(id = "ctl00_mpBody_gen_repeaterQuestions_ctl09_repeaterDependentsList_ctl00_dlResponse_1")
	WebElement Q5_NO;
	@FindBy(id = "ctl00_mpBody_gen_repeaterQuestions_ctl10_repeaterDependentsList_ctl00_dlResponse_0")
	WebElement Q6_Yes;
	@FindBy(id = "ctl00_mpBody_gen_repeaterQuestions_ctl10_repeaterDependentsList_ctl00_dlResponse_1")	
	WebElement Q6_NO;
	@FindBy(id = "ctl00_mpBody_gen_repeaterQuestions_ctl11_repeaterDependentsList_ctl00_dlResponse_0")
	WebElement Q7_Yes;
	@FindBy(id = "ctl00_mpBody_gen_repeaterQuestions_ctl11_repeaterDependentsList_ctl00_dlResponse_1")
	WebElement Q7_NO;
	@FindBy(id = "ctl00_mpBody_gen_repeaterQuestions_ctl12_repeaterDependentsList_ctl00_dlResponse_0")
	WebElement Q8_Yes;
	@FindBy(id = "ctl00_mpBody_gen_repeaterQuestions_ctl12_repeaterDependentsList_ctl00_dlResponse_1")	
	WebElement Q8_NO;
	@FindBy(id = "ctl00_mpBody_gen_lbBackBottom")
	WebElement Back;
	@FindBy(id = "ctl00_mpBody_gen_btnCheckout")
	WebElement Next;
	@FindBy(id = "//div[@id='ctl00_mpBody_gen_vsGateKeeper']//ul//li")
	WebElement Q2_req;

	
	public Cancer_GateKeeper_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void Answer_Cancer_Questions_type1() throws InterruptedException{
		Q1_NO.click();
		Q2_NO.click();
		Q3_NO.click();
		Q4_NO.click();
		Q5_NO.click();
		Q6_NO.click();
		Q7_NO.click();
		Q8_NO.click();
		Next.click();
		log.info("Answered for all the questions and clicked on NEXT button");
		Thread.sleep(2000);
	}

}
