package com.dice.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject<T> {
	protected WebDriver driver;
	protected WebDriverWait wait;
	private JavascriptExecutor js;

	protected BasePageObject(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10000);
		js = (JavascriptExecutor) driver;
	}

	public BasePageObject() {
		// TODO Auto-generated constructor stub
	}


	protected void type(String text, WebElement element) {
		element.sendKeys(text);

	}

	protected void waitForVisibilityOf(WebElement element, int timeoutInSeconds) {
		// wait.until(ExpectedConditions.visibilityOf(element));

		int attempts = 0;
		while (attempts < 2) {
			try {
				waitFor(ExpectedConditions.visibilityOf(element), timeoutInSeconds);

			} catch (StaleElementReferenceException e) {
				// TODO: handle exception
			}
			attempts++;
		}

	}

	private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds) {
		timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30;
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(condition);

	}


	protected void waitForPageToLoad() {
		wait.until(driver -> js.executeScript("return document.readyState").equals("complete"));
	}
	
	public String getTitle() {
		return driver.getTitle();
	}

}
