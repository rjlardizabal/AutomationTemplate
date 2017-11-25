package com.dice.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;




public class FirstTest extends BaseTest {
	

	@Test
	public void firstTestMethod() {

		driver.get("http://www.dice.com");
		System.out.println("Dice Opened. Test Passed");

	}

}
