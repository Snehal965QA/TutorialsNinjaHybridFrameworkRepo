package com.tutorialsninja.qa.testcases;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.tutorialsninja.qa.baseClass.Base;
import com.tutorialsninja.qa.pages.AccountSuccessPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.RegisterPage;
import com.tutorialsninja.qa.utils.Utilities;

public class RegisterTest extends Base {
	 public WebDriver driver;

	public RegisterTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browserName"));
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		homePage.selectRegisterOption();

		/*
		 * driver =
		 * initializeBrowserAndOpenApplication(prop.getProperty("browserName"));
		 * driver.findElement(By.xpath("//span[text()='My Account']")).click();
		 * driver.findElement(By.linkText("Register")).click();
		 */
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void verifyRegisteringAnAccountWithMandatoryFields() {
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstName(dataProp.getProperty("firstName"));
		registerPage.enterlastName(dataProp.getProperty("lastName"));
		registerPage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		registerPage.enterTelephoneNumber(dataProp.getProperty("telephoneNumber"));
		registerPage.enterPasswordField(prop.getProperty("password"));
		registerPage.enterConfirmPassword(prop.getProperty("password"));
		registerPage.selectPrivacyPolicy();
		registerPage.clickOnContinueButton();
		AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
		/*
		 * driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty(
		 * "firstName"));
		 * driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty(
		 * "lastName")); driver.findElement(By.id("input-email")).sendKeys(Utilities.
		 * generateEmailWithTimeStamp());
		 * driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty(
		 * "telephoneNumber"));
		 * driver.findElement(By.id("input-password")).sendKeys("1234567890");
		 * driver.findElement(By.id("input-confirm")).sendKeys("1234567890");
		 * driver.findElement(By.name("agree")).click();
		 * driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();
		 */

		String actualSuccessHeading = accountSuccessPage.retrieveAccountSuccessPageHeading();
		Assert.assertEquals(actualSuccessHeading, dataProp.getProperty("accountSuccessfullyCreatedHeading"),
				"Account success page is not displayed");

	}

	@Test(priority = 2)
	public void verifyRegesteringAccountByProvidingAllFields() {
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstName(dataProp.getProperty("firstName"));
		registerPage.enterlastName(dataProp.getProperty("lastName"));
		registerPage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		registerPage.enterTelephoneNumber(dataProp.getProperty("telephoneNumber"));
		registerPage.enterPasswordField(prop.getProperty("password"));
		registerPage.enterConfirmPassword(prop.getProperty("password"));
		registerPage.yesNewsLetterOption();
		registerPage.selectPrivacyPolicy();
		registerPage.clickOnContinueButton();
		AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
		String actualSuccessHeading = accountSuccessPage.retrieveAccountSuccessPageHeading();
		Assert.assertEquals(actualSuccessHeading, dataProp.getProperty("accountSuccessfullyCreatedHeading"),
				"Account success page is not displayed");
		
		/*
		 * driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty(
		 * "firstName"));
		 * driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty(
		 * "lastName")); driver.findElement(By.id("input-email")).sendKeys(Utilities.
		 * generateEmailWithTimeStamp());
		 * driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty(
		 * "telephoneNumber"));
		 * driver.findElement(By.id("input-password")).sendKeys("1234567890");
		 * 
		 * driver.findElement(By.id("input-confirm")).sendKeys("1234567890");
		 * driver.findElement(By.xpath("//input[@name=\"newsletter\"][@value='1']")).
		 * click(); driver.findElement(By.name("agree")).click();
		 * driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();
		 * 
		 * new WebDriverWait(driver, Duration.ofSeconds(10))
		 * .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * "//div[@id='content']/h1"))); String actualSuccessHeading =
		 * driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		 * 
		 * // String actualSuccessHeading = //
		 * driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		 * Assert.assertEquals(actualSuccessHeading,
		 * dataProp.getProperty("accountSuccessfulyCreatedHeading"),
		 * "Account success page is not displayed");
		 */

	}

	@Test(priority = 3)
	public void verifyRegisteringAccountWithExisitingEmailAddress() {
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstName(dataProp.getProperty("firstName"));
		registerPage.enterlastName(dataProp.getProperty("lastName"));
		registerPage.enterEmailAddress(prop.getProperty("email"));

		//registerPage.enterEmailAddress(dataProp.getProperty("email"));
		
		registerPage.enterTelephoneNumber(dataProp.getProperty("telephoneNumber"));
		registerPage.enterPasswordField(prop.getProperty("password"));
		registerPage.enterConfirmPassword(prop.getProperty("password"));
		registerPage.yesNewsLetterOption();
		registerPage.selectPrivacyPolicy();
		registerPage.clickOnContinueButton();
		
		/*
		 * driver.findElement(By.xpath("//span[text()='My Account']")).click();
		 * driver.findElement(By.linkText("Register")).click();
		 * driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty(
		 * "firstName"));
		 * driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty(
		 * "lastName"));
		 * driver.findElement(By.id("input-email")).sendKeys(dataProp.getProperty(
		 * "email"));
		 * driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty(
		 * "telephoneNumber"));
		 * driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty(
		 * "password"));
		 * driver.findElement(By.id("input-confirm")).sendKeys(dataProp.getProperty(
		 * "password"));
		 * driver.findElement(By.xpath("//input[@name=\"newsletter\"][@value='1']")).
		 * click(); driver.findElement(By.name("agree")).click();
		 * driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();
		 */

		String actualWarning = registerPage.retrieveDuplicateEmailAddressWarning();
		Assert.assertTrue(actualWarning.contains(dataProp.getProperty("duplicateEmailWarning")),
				"Warning message is not displayed about duplicate");
	}

	@Test(priority = 4)
	
	public void verifyRegisteringAccountWithoutFillingAnyDetails() {
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.clickOnContinueButton();

		String actualPrivacyPolicyWarning = registerPage.retrievePrivacyPolicyWarning();
		Assert.assertTrue(actualPrivacyPolicyWarning.contains(dataProp.getProperty("privacyPolicyWarning")),
				"Privacy policy warning not displayed");

		String actualFirstNameWarning = registerPage.retrieveFirstNameWarning();
		Assert.assertTrue(actualFirstNameWarning.contains(dataProp.getProperty("firstNameWarning")),
				"First name warning not displayed");

		String actualLastNameWarning = registerPage.retrieveLastNameWarning();
		Assert.assertTrue(actualLastNameWarning.contains(dataProp.getProperty("lastNameWarning")),
				"Last name warning not displayed");

		String actualEmailWarning = registerPage.retrieveEmailWarning();
		Assert.assertTrue(actualEmailWarning.contains(dataProp.getProperty("emailWarning")),
				"Email warning not displayed");

		String actualTelephoneNumber = registerPage.retrieveTelephoneWarning();
		Assert.assertTrue(actualTelephoneNumber.contains(dataProp.getProperty("telephoneWarning")),
				"Telephone warning not displayed");

		String actualPassword = registerPage.retrievePasswordWarning();
		Assert.assertTrue(actualPassword.contains(dataProp.getProperty("passwordWarning")),
				"Password warning not displayed");
	}

	/*public void verifyRegesteringAccountWithoutFillingAnyDetails() {
		RegisterPage registerPage=new RegisterPage(driver);
		registerPage.clickOnContinueButton();
		
		
		
		 * driver.findElement(By.xpath("//span[text()='My Account']")).click();
		 * driver.findElement(By.linkText("Register")).click();
		 * driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();
		 
		
		String actualPrivacyPolicyWarning = registerPage.reterivePrivacyPolicyWarning();
		
		Assert.assertTrue(actualPrivacyPolicyWarning.contains(dataProp.getProperty("privacyPolicyWarning")),
				"Privacy policy warning not displayed");

		String actualFirstNameWarning =registerPage.retrieveFirstNameWarning();
		Assert.assertTrue(actualFirstNameWarning.contains(dataProp.getProperty("firstNameWarning")),
				"first name warning not displayed");
        String actualLastNameWarning =registerPage.retrieveLastNameWarning();
		Assert.assertTrue(actualLastNameWarning.contains(dataProp.getProperty("lastNameWarnig")),
				"last name warning not displayed");

	
		
		
		String actualEmailWarning = registerPage.retreiveEmailWarning();
		Assert.assertTrue(actualEmailWarning.contains(dataProp.getProperty("emailWarning")),
				"Email warning not displayed");

		
		String actualTelephoneNumber = registerPage.retreiveTelephoneWarning();
		Assert.assertTrue(actualTelephoneNumber.contains(dataProp.getProperty("telephoneWarning")),
				"telephone warning not displayed");

		String actualPassword = registerPage.retreivePasswordWarning();
		Assert.assertTrue(actualPassword.contains(dataProp.getProperty("passwordWarning")),
				"Password warning not displayed");
*/
	}


