package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.Advice.This;

public class HomePage {
	WebDriver driver;
	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountDropMenu;

	@FindBy(linkText = "Login")
	private WebElement loginOption;
	
	@FindBy(linkText ="Register")
	private WebElement registerOption;
	
	@FindBy(name ="search")
	private WebElement searchBoxField;
	
	
	
	@FindBy(xpath = "//div[@id=\"search\"]/descendant::button")
	private WebElement searchButton;

	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMyAccount() {
		myAccountDropMenu.click();
	}
	public void selectLoginOption() {
		loginOption.click();
	}
	
	
	public LoginPage navigateToLoginPage() {
		myAccountDropMenu.click();
		loginOption.click();
		return new LoginPage(driver);
	}
	
	public void selectRegisterOption() {
		registerOption.click();
	}
	
	public void enterProductIntoSearchBoxField(String productText) {
		searchBoxField.sendKeys(productText);
		}
	
	public void clickOnSearchButton() {
		searchButton.click();
	}

}
