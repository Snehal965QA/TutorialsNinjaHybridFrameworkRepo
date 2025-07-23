package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.tutorialsninja.qa.baseClass.Base;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.SearchPage;



//Updated command - Added more details

public class SearchTest extends Base {

	public SearchTest() {
		super();
	}
	public  WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browserName"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void verifySearchValidProduct() {

		HomePage homePage = new HomePage(driver);
		homePage.enterProductIntoSearchBoxField(dataProp.getProperty("validProduct"));
		homePage.clickOnSearchButton();
		SearchPage searchPage = new SearchPage(driver);
		Assert.assertTrue(searchPage.displayStatusOfHPValidProduct(), "validProduct");

	}

	@Test(priority = 2)
	public void verifySearchWithInvalidProduct() {
		HomePage homePage = new HomePage(driver);
		homePage.enterProductIntoSearchBoxField(dataProp.getProperty("invalidProduct"));
		homePage.clickOnSearchButton();
		SearchPage searchPage = new SearchPage(driver);
		String actualSearchMessage = searchPage.retrieveNoProductMessageText();
		Assert.assertEquals(actualSearchMessage, "ab"+dataProp.getProperty("noProductTextInSearch"),
				"No products displayed");

	}

	@Test(priority = 3 ,dependsOnMethods = {"verifySearchWithInvalidProduct"})
	public void verifySearchWithoutInvalidProduct() {
		HomePage homePage = new HomePage(driver);
		homePage.clickOnSearchButton();
		SearchPage searchPage = new SearchPage(driver);
		String actualSearchMessage = searchPage.retrieveNoProductMessageText();

		Assert.assertEquals(actualSearchMessage, dataProp.getProperty("noProductTextInSearch"),
				"No products displayed");

	}

}
