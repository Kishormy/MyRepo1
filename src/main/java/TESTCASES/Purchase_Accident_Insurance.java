package TESTCASES;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.mail.EmailException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.Logs;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Generic.Excel_data;
import REPOSITORY.Acc_GateKeeper_Page;
import REPOSITORY.Accident_Page;
import REPOSITORY.CI_GateKeeper_Page;
import REPOSITORY.Cart_Page;
import REPOSITORY.Checkout_Disclosures;
import REPOSITORY.Checkout_Page;
import REPOSITORY.Critical_Illness_page;
import REPOSITORY.Registration_Page;
import REPOSITORY.Review_Submit;
import REPOSITORY.Shop_Page;
import REPOSITORY.Thank_you;

public class Purchase_Accident_Insurance {
	WebDriver driver;
	Excel_data excel;
	Logger log = Logger.getLogger(Logs.class);
	Shop_Page shop;
	Critical_Illness_page critical_Illnesspage;
	Registration_Page registration;
	CI_GateKeeper_Page ci_GateKeeper_Page;
	Checkout_Page checkout;
	Checkout_Disclosures checkout_Disclosures;
	Review_Submit review_Submit;
	Accident_Page acc;
	Acc_GateKeeper_Page acc_GateKeeper_Page;
	

	@BeforeSuite
	public void OpenBroswer() throws IOException {
		excel = new Excel_data();
		PropertyConfigurator.configure(".//Test_data//log4j.properties");
		System.setProperty("webdriver.gecko.driver", "F:/Automation files/SPRAOI/Drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		// System.setProperty("webdriver.chrome.driver", "E:/SELENIUM/JAR
		// files/chromedriver.exe");
		// driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.info("Browser is opened");
		String Dev = excel.Get_Data(22, 1);
		String Qa = excel.Get_Data(23, 1);
		String Qa2 = excel.Get_Data(24, 1);
		log.info("Executing Purchase Accident Insurance");
		driver.get(Dev);
		log.info("Landed to AFLAC storefront");
	}

	@Test(priority = 0)
	public void Choose_Accident() throws IOException, InterruptedException {
		shop = new Shop_Page(driver);
		log.info("Page title is " + "\"" + driver.getTitle() + "\"");
		shop.Choose_Accident();
	}

	@Test(priority = 1, dependsOnMethods = { "Choose_Accident" })
	public void Get_Quote2() throws IOException, InterruptedException {
		acc = new Accident_Page(driver);
		acc.GetAccident_AdvantageA();
	}

	@Test(priority = 2, dependsOnMethods = { "Get_Quote2" })
	public void Customer_Registration() throws IOException, InterruptedException {
		registration = new Registration_Page(driver);
		registration.Fill_Customer_details();
	}

	@Test(priority = 3, dependsOnMethods = { "Customer_Registration" })
	public void Checkout_Add_Dependents() throws IOException, InterruptedException {
		checkout = new Checkout_Page(driver);
		checkout.Add_Spouse();
		checkout.Add_Child();
	}

	@Test(priority = 4, dependsOnMethods = { "Checkout_Add_Dependents" })
	public void Answer_ACC_Questions() throws IOException, InterruptedException {
		acc_GateKeeper_Page = new Acc_GateKeeper_Page(driver);
		acc_GateKeeper_Page.Answer_Acc_Questions_typ1();
	}

	@Test(priority = 5, dependsOnMethods = { "Answer_ACC_Questions" })
	public void Checkout_From_Cart() throws IOException, InterruptedException {
		Cart_Page cart = new Cart_Page(driver);
		cart.Cart_Checkout();
	}

	@Test(priority = 6, dependsOnMethods = { "Checkout_From_Cart" })
	public void Checkout_Add_beneficiary() throws IOException, InterruptedException {
		checkout = new Checkout_Page(driver);
		checkout.Add_Beneficiary();
	}

	@Test(priority = 7, dependsOnMethods = { "Checkout_Add_beneficiary" })
	public void Checkout_Add_creditcarddetials() throws IOException, InterruptedException {
		checkout.Add_creditcard_Visa();
	}

	@Test(priority = 8, dependsOnMethods = { "Checkout_Add_creditcarddetials" })
	public void Checkout_FIll_Disclosures() throws IOException, InterruptedException {
		checkout_Disclosures = new Checkout_Disclosures(driver);
		checkout_Disclosures.Fill_Disclosure();
	}

	@Test(priority = 9, dependsOnMethods = { "Checkout_FIll_Disclosures" })
	public void Review_And_Submit() throws IOException, InterruptedException {
		review_Submit = new Review_Submit(driver);
		review_Submit.Review_Submit_Method();
	}

	@Test(priority = 10, dependsOnMethods = { "Review_And_Submit" })
	public void Check_Thank_You_Page() throws IOException, InterruptedException, EmailException {
		Thank_you thank_you = new Thank_you(driver);
		thank_you.Check_Thank_you_Page();
	}

	@AfterSuite
	public void CloseBroswer() {
		log.info("Purchased Accident Insurance Executed Successfully ");
		log.info("Browser has been closed");
		driver.close();
	}

}
