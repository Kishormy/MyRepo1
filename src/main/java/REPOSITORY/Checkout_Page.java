package REPOSITORY;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Generic.Excel_data;
import junit.framework.Assert;

public class Checkout_Page {

	Logger log = Logger.getLogger(Logs.class);
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
	@FindBy(xpath = "ctl00_rep_nav_ctl03_hlNav")
	WebElement Signout;

	@FindBy(id = "ctl00_mpBody_btnOKPL")
	WebElement Beneficiary_OK_popup;
	@FindBy(id = "ctl00_mpBody_repeaterBeneficiaries_ctl01_btnAddOptionalBeneficiary")
	WebElement Add_Beneficiary_Button;
	@FindBy(id = "ctl00_mpBody_rblBeneficiaryType_0")
	WebElement Individualtype;
	@FindBy(id = "ctl00_mpBody_rblBeneficiaryType_1")
	WebElement Trusttype;
	@FindBy(id = "ctl00_mpBody_btnChooseBeneficiaryContinue")
	WebElement Next_1;
	@FindBy(id = "ctl00_mpBody_btnChooseBeneficiaryCancel")
	WebElement Cancel_1;
	@FindBy(id = "ctl00_mpBody_lnkLogin")
	WebElement Sign_In;

	@FindBy(id = "ctl00_mpBody_firstname")
	WebElement Firstname;
	@FindBy(id = "ctl00_mpBody_middleinitial")
	WebElement MIddle_Intial;
	@FindBy(id = "ctl00_mpBody_lastname")
	WebElement LastName;
	@FindBy(id = "ctl00_mpBody_birthdate_txtDateOfBirth")
	WebElement ben_DOB;
	@FindBy(id = "ctl00_mpBody_phone_txtPhoneNumber")
	WebElement Phone1;
	@FindBy(id = "ddlPhoneType")
	WebElement Phonetype1;
	@FindBy(id = "ctl00_mpBody_relationship")
	WebElement Relationship;
	@FindBy(id = "ctl00_mpBody_btnSaveModifyBeneficiary")
	WebElement Save;
	@FindBy(id = "ctl00_mpBody_btnCancelModifyBeneficiary")
	WebElement Cancel;

	@FindBy(xpath = "//li[contains(text(),'First Name is Required.')]")
	WebElement FirstName_Req;
	@FindBy(id = "//li[contains(text(),'Last Name is Required.')]")
	WebElement LastName_Req;
	@FindBy(id = "//li[contains(text(),'Relationship is Required.')]")
	WebElement Relationship_reg;
	@FindBy(id = "ctl00_mpBody_lbContinue")
	WebElement Next;

	@FindBy(id = "ctl00_mpBody_btnCancelDBC")
	WebElement PleaseConfirm_Cancel;
	@FindBy(id = "ctl00_mpBody_btnContinueDBC")
	WebElement PleaseConfirm_Continue;

	@FindBy(id = "ctl00_mpBody_PaymentMethodID")
	WebElement SelectPM;
	@FindBy(id = "CreditCardTypeID")
	WebElement Cart_Type;
	@FindBy(id = "ctl00_mpBody_Customer_addCreditCard1_CardNumber_txtCreditCard")
	WebElement Card_number;
	@FindBy(id = "ctl00_mpBody_Customer_addCreditCard1_BillName")
	WebElement Name_on_card;
	@FindBy(id = "ctl00_mpBody_Customer_addCreditCard1_expMonth")
	WebElement Exp_Month;
	@FindBy(id = "ctl00_mpBody_Customer_addCreditCard1_expYear")
	WebElement Exp_Year;
	@FindBy(id = "ctl00_mpBody_Customer_addCreditCard1_cvn")
	WebElement Card_Verfication_Number;
	@FindBy(id = "draftdate")
	WebElement Draftdate;
	@FindBy(id = "ctl00_mpBody_Customer_addCreditCard1_chkBillingadress")
	WebElement My_Billing_Checkbox;

	@FindBy(id = "ctl00_mpBody_Customer_addCheckingAccount1_BillName")
	WebElement Account_Holder_Name;
	@FindBy(id = "ctl00_mpBody_Customer_addCheckingAccount1_BankName")
	WebElement Bank_Name;
	@FindBy(id = "ctl00_mpBody_Customer_addCheckingAccount1_BankCity")
	WebElement Bank_City;
	@FindBy(id = "ctl00_mpBody_Customer_addCheckingAccount1_BankStateAbbr")
	WebElement Bank_State;
	@FindBy(id = "ctl00_mpBody_Customer_addCheckingAccount1_BankPostalCode")
	WebElement Bank_Zipcode;
	@FindBy(id = "ctl00_mpBody_Customer_addCheckingAccount1_PaymentMethodAccountUsageID")
	WebElement Account_type;
	@FindBy(id = "ctl00_mpBody_Customer_addCheckingAccount1_chkBillingadress")
	WebElement Billingcheckbox_Checkingaccount;
	@FindBy(id = "ctl00_mpBody_Customer_addCheckingAccount1_BankRoutingNumber")
	WebElement Routing_No;
	@FindBy(id = "ctl00_mpBody_Customer_addCheckingAccount1_BankAccountNumber")
	WebElement Account_No;
	@FindBy(id = "ctl00_mpBody_Customer_addCheckingAccount1_BankAccountNumberConfirm")
	WebElement Confirm_Account_No;

	@FindBy(id = "ctl00_mpBody_Customer_addManualACH_Savings1_BillName")
	WebElement Account_Holder_Name_savings;
	@FindBy(id = "ctl00_mpBody_Customer_addManualACH_Savings1_BankName")
	WebElement Bank_Name_savings;
	@FindBy(id = "ctl00_mpBody_Customer_addManualACH_Savings1_BankCity")
	WebElement Bank_City_Savings;
	@FindBy(id = "ctl00_mpBody_Customer_addManualACH_Savings1_BankStateAbbr")
	WebElement Bank_State_savings;
	@FindBy(id = "ctl00_mpBody_Customer_addManualACH_Savings1_BankPostalCode")
	WebElement Bank_Zipcode_Savings;
	@FindBy(id = "ctl00_mpBody_Customer_addCheckingAccount1_PaymentMethodAccountUsageID")
	WebElement Billingcheckbox_Savings;
	@FindBy(id = "ctl00_mpBody_Customer_addManualACH_Savings1_BankRoutingNumber")
	WebElement Routing_No_Savings;
	@FindBy(id = "ctl00_mpBody_Customer_addManualACH_Savings1_BankAccountNumber")
	WebElement Account_No_savings;
	@FindBy(id = "ctl00_mpBody_Customer_addManualACH_Savings1_BankAccountNumberConfirm")
	WebElement Confirm_Account_No_savings;
	@FindBy(id = "ctl00_mpBody_btnAddPaymentMethod")
	WebElement Next_PM;

	@FindBy(id = "ctl00_mpBody_rep_currentDependents_ctl01_btnAddDependent")
	WebElement Add_Spouse_Button;
	@FindBy(id = "ctl00_mpBody_rep_currentDependents_ctl02_btnAddDependent")
	WebElement Add_Child_Button;
	@FindBy(id = "ctl00_mpBody_firstname")
	WebElement Firstname_Dep;
	@FindBy(id = "ctl00_mpBody_middleinitial")
	WebElement MIddle_Intial_Dep;
	@FindBy(id = "ctl00_mpBody_lastname")
	WebElement LastName_Dep;
	@FindBy(id = "ctl00_mpBody_birthdate_txtDateOfBirth")
	WebElement DOB_Dep;
	@FindBy(id = "ctl00_mpBody_EcomDependentTypeID")
	WebElement Dep_type;
	@FindBy(id = "ctl00_mpBody_GenderID")
	WebElement Dep_Gender;
	@FindBy(id = "ctl00_mpBody_btn_add")
	WebElement Save_Dep;
	@FindBy(id = "ctl00_mpBody_btn_cancel_add")
	WebElement Cancel_Dep;

	@FindBy(xpath = "//li[contains(text(),'First Name is Required.')]")
	WebElement FirstName_Req_Dep;
	@FindBy(id = "//li[contains(text(),'Last Name is Required.')]")
	WebElement LastName_Req_Dep;
	@FindBy(id = "//li[contains(text(),'Dependent Type is Required.')]")
	WebElement Relationship_reg_Dep;
	@FindBy(id = "//li[contains(text(),'Gender is Required.')]")
	WebElement Gender_reg;
	@FindBy(id = "ctl00_mpBody_lbContinue")
	WebElement Next_Dep;
	@FindBy(id = "ctl00_mpBody_btnCancelCD")
	WebElement PleaseConfirm_Cancel_DEP;
	@FindBy(id = "ctl00_mpBody_btnContinueCD")
	WebElement PleaseConfirm_Continue_DEP;

	public Checkout_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void MoveToPayment() throws IOException, InterruptedException {
		Beneficiary_OK_popup.click();
		Next.click();
	}

	public void Add_Beneficiary() throws IOException, InterruptedException {
		Beneficiary_OK_popup.click();
		Add_Beneficiary_Button.click();
		Individualtype.click();
		Next_1.click();
		excel = new Excel_data();
		Firstname.sendKeys(excel.Get_Data(32, 1));
		MIddle_Intial.sendKeys(excel.Get_Data(33, 1));
		LastName.sendKeys(excel.Get_Data(34, 1));
		Relationship.sendKeys(excel.Get_Data(36, 1));
		ben_DOB.sendKeys(excel.Get_Data(1, 1));
		Phone1.sendKeys(excel.Get_Data(37, 1));
		Phonetype1.sendKeys(excel.Get_Data(38, 1));
		Save.click();
		Next.click();
		log.info("Beneficiary Added successfully");
		Thread.sleep(3000);
		PleaseConfirm_Continue.click();
		Thread.sleep(5000);

	}
	public void Add_Beneficiary_for_accident() throws IOException, InterruptedException {
		Add_Beneficiary_Button.click();
		Individualtype.click();
		Next_1.click();
		excel = new Excel_data();
		Firstname.sendKeys(excel.Get_Data(32, 1));
		MIddle_Intial.sendKeys(excel.Get_Data(33, 1));
		LastName.sendKeys(excel.Get_Data(34, 1));
		Relationship.sendKeys(excel.Get_Data(36, 1));
		ben_DOB.sendKeys(excel.Get_Data(1, 1));
		Phone1.sendKeys(excel.Get_Data(37, 1));
		Phonetype1.sendKeys(excel.Get_Data(38, 1));
		Save.click();
		Next.click();
		log.info("Beneficiary Added successfully");
		Thread.sleep(3000);
		PleaseConfirm_Continue.click();
		Thread.sleep(5000);

	}

	public void Validate_Beneficiary() throws IOException {
		Beneficiary_OK_popup.click();
		Individualtype.click();
		Next_1.click();
		excel = new Excel_data();
		Save.click();
		Assert.assertTrue("Validated",
				(FirstName_Req.isDisplayed() && LastName_Req.isDisplayed() && Relationship_reg.isDisplayed()));
	}

	public void Add_creditcard_Visa() throws IOException, InterruptedException {
		Select PM = new Select(SelectPM);
		PM.selectByVisibleText((excel.Get_Data(40, 1)));
		Select Card = new Select(Cart_Type);
		Card.selectByVisibleText(excel.Get_Data(41, 1));
		Card_number.sendKeys(excel.Get_Data(42, 1));
		Name_on_card.sendKeys(excel.Get_Data(43, 1));
		Exp_Month.sendKeys(excel.Get_Data(44, 12));
		Exp_Year.sendKeys(excel.Get_Data(45, 2));
		Card_Verfication_Number.sendKeys(excel.Get_Data(46, 1));
		// DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
		// Calendar c = Calendar.getInstance();
		// c.add(Calendar.DATE, 5);
		// Draftdate.sendKeys(dateFormat.format(c.getTime()));
		Draftdate.sendKeys("10/02/2019");
		My_Billing_Checkbox.click();
		Next_PM.click();
		log.info("Credit Card details[VISA] Added successfully");
		Thread.sleep(20000);
	}

	public void Add_creditcard_MasterCard() throws IOException, InterruptedException {
		Select PM = new Select(SelectPM);
		PM.selectByVisibleText(excel.Get_Data(40, 1));
		Select Card = new Select(Cart_Type);
		Card.selectByVisibleText(excel.Get_Data(41, 2));
		Card_number.sendKeys(excel.Get_Data(42, 2));
		Name_on_card.sendKeys(excel.Get_Data(43, 2));
		Exp_Month.sendKeys(excel.Get_Data(44, 12));
		Exp_Year.sendKeys(excel.Get_Data(45, 2));
		Card_Verfication_Number.sendKeys(excel.Get_Data(46, 2));
		// DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		// Calendar c = Calendar.getInstance();
		// c.add(Calendar.DATE, 5);
		// Draftdate.sendKeys(dateFormat.format(c.getTime()));
		Draftdate.sendKeys("10/02/2019");
		My_Billing_Checkbox.click();
		Next_PM.click();
		log.info("Credit Card details[MASTER CARD] Added successfully");
		Thread.sleep(5000);
	}

	public void Add_Checking_Account() throws IOException, InterruptedException {
		excel = new Excel_data();
		Select PM = new Select(SelectPM);
		// PM.selectByVisibleText(excel.Get_Data(40, 2));
		PM.selectByValue("2");
		Account_Holder_Name.sendKeys(excel.Get_Data(48, 1));
		Bank_Name.sendKeys(excel.Get_Data(49, 1));
		Bank_City.sendKeys(excel.Get_Data(50, 1));
		Bank_State.sendKeys(excel.Get_Data(51, 1));
		Bank_Zipcode.sendKeys(excel.Get_Data(52, 1));
		Select Accounttype = new Select(Account_type);
		Accounttype.selectByVisibleText(excel.Get_Data(53, 1));
		// DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		// Calendar c = Calendar.getInstance();
		// c.add(Calendar.DATE, 5);
		// Draftdate.sendKeys(dateFormat.format(c.getTime()));
		Draftdate.sendKeys("10/02/2019");
		Billingcheckbox_Checkingaccount.click();
		Routing_No.sendKeys(excel.Get_Data(54, 1));
		Account_No.sendKeys(excel.Get_Data(55, 1));
		Confirm_Account_No.sendKeys(excel.Get_Data(56, 1));
		Next_PM.click();
		log.info("Checking account details Added successfully");
		Thread.sleep(5000);
	}

	public void Add_Saving_Account() throws IOException, InterruptedException {
		excel = new Excel_data();
		Select PM = new Select(SelectPM);
		// PM.selectByVisibleText(excel.Get_Data(40, 2));
		PM.selectByValue("4");
		Account_Holder_Name_savings.sendKeys(excel.Get_Data(48, 1));
		Bank_Name_savings.sendKeys(excel.Get_Data(49, 1));
		Bank_City_Savings.sendKeys(excel.Get_Data(50, 1));
		Bank_State_savings.sendKeys(excel.Get_Data(51, 1));
		Bank_Zipcode_Savings.sendKeys(excel.Get_Data(52, 1));
		// DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		// Calendar c = Calendar.getInstance();
		// c.add(Calendar.DATE, 5);
		// Draftdate.sendKeys(dateFormat.format(c.getTime()));
		Draftdate.sendKeys("10/02/2019");
		Billingcheckbox_Savings.click();
		Routing_No_Savings.sendKeys(excel.Get_Data(54, 1));
		Account_No_savings.sendKeys(excel.Get_Data(55, 1));
		Confirm_Account_No_savings.sendKeys(excel.Get_Data(56, 1));
		Next_PM.click();
		log.info("Saving account details Added successfully");
		Thread.sleep(5000);
	}

	public void Add_Spouse() throws IOException, InterruptedException {
		Add_Spouse_Button.click();
		excel = new Excel_data();
		Firstname.sendKeys(excel.Get_Data(32, 1));
		MIddle_Intial.sendKeys(excel.Get_Data(33, 1));
		LastName.sendKeys(excel.Get_Data(34, 1));
		DOB_Dep.sendKeys(excel.Get_Data(1, 2));
		Select Dtype = new Select(Dep_type);
		Dtype.selectByVisibleText(excel.Get_Data(39, 1));
		Select gen = new Select(Dep_Gender);
		gen.selectByVisibleText(excel.Get_Data(6, 1));
		Save_Dep.click();
		log.info("Spouse Added successfully");
		Thread.sleep(3000);

	}

	public void Add_Child() throws IOException, InterruptedException {
		Add_Child_Button.click();
		excel = new Excel_data();
		Firstname.sendKeys(excel.Get_Data(32, 1));
		MIddle_Intial.sendKeys(excel.Get_Data(33, 1));
		LastName.sendKeys(excel.Get_Data(34, 1));
		// DOB_Dep.sendKeys(excel.Get_Data(1, 3));
		// Select Dtype = new Select(Dep_type);
		// Dtype.selectByVisibleText(excel.Get_Data(39, 1));
		Select gen = new Select(Dep_Gender);
		gen.selectByVisibleText(excel.Get_Data(6, 1));
		Save_Dep.click();
		log.info("Child Added successfully");
		Thread.sleep(3000);
		Next_Dep.click();
		Thread.sleep(1000);
		PleaseConfirm_Continue_DEP.click();
		Thread.sleep(5000);

	}
}
