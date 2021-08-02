package REPOSITORY;

import java.awt.event.WindowAdapter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.Excel_data;

public class Checkout_Disclosures {
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
	@FindBy(id = "ctl00_HyperLink1")
	WebElement Cart;
	@FindBy(id = "highContrast")
	WebElement Contrast_Toggle;
	@FindBy(id = "ctl00_rep_nav_ctl03_hlNav")
	WebElement Signout;
	
	@FindBy(id = "ctl00_mpBody_ucStoreDisclosures_cbDownloadAgreement")
	WebElement Aknowledge_Doc_checkbox;
	@FindBy(id = "ctl00_mpBody_ucStoreDisclosures_rptDocumentsProducts_ctl00_hlDownloadAllDocuments")
	WebElement View_All_Docs;
	@FindBy(tagName = "small")
	WebElement Initial_Text;
	@FindBy(id = "ctl00_mpBody_ucStoreDisclosures_rep_product_terms_ctl01_txtElectronicInitials")
	WebElement Initial;
	@FindBy(id = "ctl00_mpBody_ucStoreDisclosures_rep_product_terms_ctl01_cbAcceptPaymentTerms")
	WebElement Payment_Terms_Condition;
	@FindBy(id = "ctl00_mpBody_ucStoreDisclosures_rep_product_terms_ctl01_electronicSignatureTC")
	WebElement E_signature;
	@FindBy(id = "ctl00_mpBody_ucStoreDisclosures_rep_product_terms_ctl01_lblFullName2TC")
	WebElement E_signature_Text;
	@FindBy(id = "ctl00_mpBody_ucStoreDisclosures_lbContinue")
	WebElement Next;

	public Checkout_Disclosures(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void Fill_Disclosure() throws IOException, InterruptedException {
		Aknowledge_Doc_checkbox.click();
		log.info("Checking Aknowledge to download documents");
		View_All_Docs.click();
		log.info("Clicked on VIEW ALL DOCUMENTS button");
		Thread.sleep(10000);
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	    driver.close();
	    driver.switchTo().window(tabs2.get(0));
	    String initial = Initial_Text.getText();
	    String initial2 = initial.replace(")", "");
	    String initial3 = initial2.replace("(", "");
	    Initial.sendKeys(initial3);
	    log.info("Entered Intials");
	    Payment_Terms_Condition.click();
	    E_signature.sendKeys(E_signature_Text.getText());   
	    log.info("Entered Signature");
	    Next.click();
	    log.info("Redirecting to \"REVIEW AND SUBMIT\" page");
	    Thread.sleep(10000);
	}

}
