package com.dice.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestListener implements ITestListener {

	public TestListener()   {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getTestContext().getCurrentXmlTest().getName() + "Test Succesfully started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getTestContext().getCurrentXmlTest().getName() + "Test Succesfully started");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getTestContext().getCurrentXmlTest().getName() + "Test Succesfully failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
