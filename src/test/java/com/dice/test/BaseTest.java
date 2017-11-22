package com.dice.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.log4testng.Logger;

import com.dice.utils.BrowserFactory;

public class BaseTest {

	protected WebDriver driver;
	protected Logger log = Logger.getLogger(BaseTest.class);
	
	@Parameters({"browser"})
	@BeforeMethod
	protected void methodSetUp(String browser) {

		log.info("Method set up");
		driver = BrowserFactory.getDriver(browser);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	protected void methodTearDown() {
		System.out.println("Method Tear Down");
		driver.quit();
	}

}
