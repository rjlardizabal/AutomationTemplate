package com.dice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePageObject {

	private static final String URL = "https://www.dice.com/dashboard/login";

	@FindBy(id = "email")
	private WebElement emailField;
	
	@FindBy(id = "password")
	private WebElement passwordField;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement signInButton;
	
	
	@FindBy(xpath="//span[@data-automation-id='login-failure-help-message']")
	private WebElement lbl_errorMessage;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void openLoginPage() {
		driver.get(URL);
	}

	public void fillUpEmailAndPassword(String email, String Password) {
		type(email, emailField);
		type(Password, passwordField);
		
	}
	
	public ProfilePage clickSubmitButton() {
		signInButton.click();
		waitForPageToLoad();
		return new ProfilePage(driver);
		
	}

	public String getErrorMessage() {
		return lbl_errorMessage.getText();
	}
	
}
