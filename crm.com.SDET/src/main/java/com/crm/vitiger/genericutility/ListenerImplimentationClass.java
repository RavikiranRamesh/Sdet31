package com.crm.vitiger.genericutility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * 
 * @author Ravikiran
 * This class is used for Implementation of Listeners class
 *
 */

public class ListenerImplimentationClass implements ITestListener {

	public void onTestStart(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"------->start");
		System.out.println(result.getThrowable());
	}

	public void onTestSuccess(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"----->Script Execution Sucess");
		System.out.println(result.getThrowable());
	}

	public void onTestFailure(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"----->Scrit Execution Fail");
		System.out.println(result.getThrowable());
		WebDriverUtility wLib = new WebDriverUtility();
		try {
			String path = wLib.takeScreenshot(BaseClass.rDriver, methodname);
			System.out.println(path);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"------>Script Execution Skip");
		System.out.println(result.getThrowable());
	}


	public void onStart(ITestContext context) {
		
		System.out.println("------>Script Execution Started");
		
	}

	public void onFinish(ITestContext context) {
		
		System.out.println("------>Suite Ended");
	}
	 

}
