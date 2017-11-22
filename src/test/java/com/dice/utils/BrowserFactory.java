package com.dice.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	public BrowserFactory() {
		// TODO Auto-generated constructor stub
	}

	public static WebDriver getDriver(String browser) {
		WebDriver driver = null;

		switch (browser) {
		case "firefox":
			//System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
			driver = new FirefoxDriver();
			break;

		case "chrome":
			//System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();

			break;

		default:
			break;
		}

		return driver;
	}

}
