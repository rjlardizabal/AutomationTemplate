package com.dice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends BasePageObject {

	@FindBy(id = "mobileEditProfile")
	private WebElement editProfileButton;

	@FindBy(xpath = "//h1[@class='profile-contact-name']")
	private WebElement profileNameText;

	public ProfilePage(WebDriver driver) {
		super(driver);
		System.out.println("before init");
		PageFactory.initElements(driver, this);
	}

	public void waitProfilePageToLoad() {
		waitForVisibilityOf(editProfileButton, 20);
	}

	public boolean isCorrectProfileLoaded(String expectedProfileName) {
		
		

		return profileNameText.getText().equals(expectedProfileName);

	}
	
	
	public String getProfileName() {
		return profileNameText.getText();
		
	}
}
