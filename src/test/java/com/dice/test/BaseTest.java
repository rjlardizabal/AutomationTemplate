package com.dice.test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.log4testng.Logger;

import com.dice.utils.BrowserFactory;

public class BaseTest {

	public WebDriver driver;
	protected Logger log = Logger.getLogger(BaseTest.class);
	
	
	
	@Parameters({"browser"})
	@BeforeMethod
	public void methodSetUp(String browser) {
		System.out.println("eto muna");
		driver = BrowserFactory.getDriverofBrowser(browser);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	protected void methodTearDown(ITestResult result) throws IOException {
//		if(result.getStatus()==ITestResult.FAILURE) {
//			takeScreenshot(driver,result.getName());
//			System.out.println("I should be taking a screenshot");
//			
//		}
//		
		driver.quit();
		
	}

	private void takeScreenshot(WebDriver driver, String testName) throws IOException {
		
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(file, new File("/Screenshots/"+testName+".png"));
		System.out.println("creating a file on path "+"/Screenshots/"+testName+".png");
		
	}

	public WebDriver getCurrentDriver() {
		return driver;	}

}
