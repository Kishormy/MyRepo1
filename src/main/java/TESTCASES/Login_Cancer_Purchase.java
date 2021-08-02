package TESTCASES;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.mail.EmailException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.Logs;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Generic.Excel_data;
import REPOSITORY.Cancer_GateKeeper_Page;
import REPOSITORY.Cancer_Page;
import REPOSITORY.Cart_Page;
import REPOSITORY.Checkout_Disclosures;
import REPOSITORY.Checkout_Page;
import REPOSITORY.Critical_Illness_page;
import REPOSITORY.Login_Page;
import REPOSITORY.Registration_Page;
import REPOSITORY.Review_Submit;
import REPOSITORY.Shop_Page;
import REPOSITORY.Thank_you;

public class Login_Cancer_Purchase {
	WebDriver driver;
	Excel_data excel;
	Logger log = Logger.getLogger(Logs.class);
	Shop_Page shop;
	Critical_Illness_page critical_Illnesspage;
	Registration_Page registration;
	Cancer_GateKeeper_Page cancer_GateKeeper_Page;
	Checkout_Page checkout;
	Checkout_Disclosures checkout_Disclosures;
	Review_Submit review_Submit;
	Cancer_Page cancer_Page;
	Cart_Page cart;
	Login_Page login;

	@BeforeSuite
	public void OpenBroswer() throws IOException {
//		excel = new Excel_data();
		PropertyConfigurator.configure(".//Test_data//log4j.properties");
//		System.setProperty("webdriver.gecko.driver", "F:/Automation files/SPRAOI/Drivers/geckodriver.exe");
//		driver = new FirefoxDriver();
		 System.setProperty("webdriver.chrome.driver", "F:/Automation files/SPRAOI/Drivers/chromedriver.exe");
		 driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.info("Browser is opened");
		String Dev = excel.Get_Data(22, 1);
		String Qa = excel.Get_Data(23, 1);
		String Qa2 = excel.Get_Data(24, 1);
		driver.get(Dev);
		driver.get("https://insure-dev.aflac.com/cms/default.aspx");
		log.info("Executing Purchase Cancer Insurance");
		log.info("Landed to AFLAC storefront");
	}

	@Test(priority = 0)
	public void Choose_Cancer() throws IOException, InterruptedException {
		shop = new Shop_Page(driver);
		log.info("Page title is " + "\"" + driver.getTitle() + "\"");
		shop.Choose_Cancer();
	}

	@Test(priority = 1,dependsOnMethods = { "Choose_Cancer" })
	public void Get_Quote2() throws IOException, InterruptedException {
		cancer_Page = new Cancer_Page(driver);
		cancer_Page.Get_Cancer_Option_1();
	}

	@Test(priority = 2,dependsOnMethods = { "Get_Quote2" })
	public void Login() throws IOException, InterruptedException {
		registration = new Registration_Page(driver);
		login = new Login_Page(driver);
		registration.Click_Sign_In();
		login.Valid_Login_Purchase();
	}

	@Test(priority = 3,dependsOnMethods = { "Login" })
	public void Answer_Cancer_Questions() throws IOException, InterruptedException {
		cancer_GateKeeper_Page = new Cancer_GateKeeper_Page(driver);
		cancer_GateKeeper_Page.Answer_Cancer_Questions_type1();
	}

	@Test(priority = 4,dependsOnMethods = { "Answer_Cancer_Questions" })
	public void Checkout_From_Cart() throws IOException, InterruptedException {
		cart = new Cart_Page(driver);
		cart.Cart_Checkout();
	}

	
	@Test(priority = 5,dependsOnMethods = { "Checkout_From_Cart" })
	public void Checkout_Add_BankDetails() throws IOException, InterruptedException {
		checkout = new Checkout_Page(driver);
		checkout.Add_Checking_Account();
	}

	@Test(priority = 6,dependsOnMethods = { "Checkout_Add_BankDetails" })
	public void Checkout_FIll_Disclosures() throws IOException, InterruptedException {
		checkout_Disclosures = new Checkout_Disclosures(driver);
		checkout_Disclosures.Fill_Disclosure();
	}

	@Test(priority = 7,dependsOnMethods = { "Checkout_FIll_Disclosures" })
	public void Review_And_Submit() throws IOException, InterruptedException {
		review_Submit = new Review_Submit(driver);
		review_Submit.Review_Submit_Method();
	}

	@Test(priority = 8,dependsOnMethods = { "Review_And_Submit" })
	public void Check_Thank_You_Page() throws IOException, InterruptedException, EmailException {
		Thank_you thank_you = new Thank_you(driver);
		thank_you.Check_Thank_you_Page();
	}

	@AfterSuite
	public void CloseBroswer() {
		log.info("Purchased Cancer Insurance Executed Successfully ");
		log.info("Browser has been closed");
		driver.close();
	}

}
