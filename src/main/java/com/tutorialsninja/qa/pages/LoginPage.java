package com.tutorialsninja.qa.pages;

import java.security.PrivateKey;
import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(id ="input-email")
	private WebElement emailAddressField;
	
	@FindBy (name = "password")
	private WebElement passwordField;
	
	@FindBy(xpath ="//input[@type=\"submit\"]")
	private WebElement loginButton;
	
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
     private WebElement emailPasswordNoMatchWarning;
	
	public void enterEmailAddress(String emailText) {
		emailAddressField.sendKeys(emailText);
	}
	
	public AccountPage login(String emailText, String passwordText) {
		enterEmailAddress(emailText);
		enterPassword(passwordText);
		clickOnloginButton();
		return new AccountPage(driver);
	}

	
	/*
	 * public AccountPage login(String emailText, String passwordText) {
	 * emailAddressField.sendKeys(emailText); loginButton.click(); return new
	 * AccountPage(driver); }
	 */

	public void enterPassword(String passwordText) {
		passwordField.sendKeys(passwordText);
	}

	
	  public AccountPage clickOnloginButton() { 
	loginButton.click();
	return new AccountPage(driver); }
	 
	
	public String retriverEmailPasswordNotMatchingWarningMessageText() {
	String warningText=	emailPasswordNoMatchWarning.getText();
	return warningText;
	}

}
