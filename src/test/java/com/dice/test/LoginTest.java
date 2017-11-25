package com.dice.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.dice.pages.LoginPage;
import com.dice.pages.ProfilePage;
import com.dice.utils.ExcelReader;

public class LoginTest extends BaseTest {

	private LoginPage loginPage;
	private ProfilePage profilePage;
	private final static String EXPECTED_PROFILE_TITLE_PAGE = "Seeker Dashboard - Profileaa";
	private final static String EXPECTED_PROFILE_NAME = "RommelTest LardizabalTest";
	Logger logger = Logger.getLogger(LoginTest.class);
	
	@Test(groups = {"positive"})
	public void positiveLoginTest() {
		loginPage = new LoginPage(driver);

		// Open dice login page https://dice.com/dashboard/login
		loginPage.openLoginPage();

		// Fill up email and password

		loginPage.fillUpEmailAndPassword("rj.lardizabal22@gmail.com", "Selenium123");
		// Click Login button, wait for page to load

		profilePage = loginPage.clickSubmitButton();
		// Verifications
		// -Verify title of the page is correct

		String actualTitle = profilePage.getTitle();
		Assert.assertTrue(EXPECTED_PROFILE_TITLE_PAGE.equals(actualTitle),
				"Page Title is not expected. Actual" + actualTitle + "Expected:" + EXPECTED_PROFILE_TITLE_PAGE);

		// Assert.assertEquals(driver.getTitle(),"Seeker Dashboard - Profile");

		Assert.assertTrue(profilePage.isCorrectProfileLoaded(EXPECTED_PROFILE_NAME),
				"Profile Name is not expected" + EXPECTED_PROFILE_NAME + "Actual " + profilePage.getProfileName());

	}

	@Test(groups = {"negative"})
	public void negativeLoginTest() {
		String expectedErrorMsg = "Email and/or password incorrect.";
		loginPage = new LoginPage(driver);

		// Open dice login page https://dice.com/dashboard/login
		loginPage.openLoginPage();

		// Fill up email and password

		loginPage.fillUpEmailAndPassword("rj.lardizabal2dsadasdas2@gmail.com", "Selenium123");
		// Click Login button, wait for page to load

		loginPage.clickSubmitButton();
		// Verifications
		// -Verify title of the page is correct

		String actualErrorMessage = loginPage.getErrorMessage();

		Assert.assertTrue(actualErrorMessage.contains(expectedErrorMsg),
				"Expected Value is " + expectedErrorMsg + "\nActual Error Message is " + actualErrorMessage);

	}
	
	
	@Test(dataProvider = "NegativeTest" , priority=2, groups= {"broken","negative"})
	public void negativeTestWithDataProvider(String email,String password) {
		String expectedErrorMsg = "Email and/or password incorrect.";
		loginPage = new LoginPage(driver);

		// Open dice login page https://dice.com/dashboard/login
		loginPage.openLoginPage();

		// Fill up email and password

		loginPage.fillUpEmailAndPassword(email,password);
		// Click Login button, wait for page to load

		loginPage.clickSubmitButton();
		// Verifications
		// -Verify title of the page is correct

		String actualErrorMessage = loginPage.getErrorMessage();

		Assert.assertTrue(actualErrorMessage.contains(expectedErrorMsg),
				"Expected Value is " + expectedErrorMsg + "\nActual Error Message is " + actualErrorMessage);

		
	}
	
	
	@DataProvider(name="NegativeTest")
	public Object[][] invalidPasswords() throws IOException{
		ExcelReader excelReader = new ExcelReader();
		return 		excelReader.getExcelData("src/test/resources/TestData.xlsx", "Sheet1");

	}
}
