package com.dice.test;

import org.testng.annotations.Test;

public class SecondTest extends BaseTest {

	@Test
	public void secondTestMethod() {

		driver.get("http://www.linkedin.com");
		System.out.println("LinkedIn Opened. Test Passed");

	}

}
