package utilities;

import java.io.File;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;

import TestCases.BaseClass;
public class MyListener extends BaseClass implements ITestListener  {
	public void onTestFailure(ITestResult result) {
		String filepath = null;
		System.out.println("Test Failed, screenshot captured as "+result.getMethod().getMethodName());
		try {
			 filepath =(String) screenshot(result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		extentTest.fail(MediaEntityBuilder.createScreenCaptureFromPath(filepath).build());
	    
		
		}
	public void onTestStart(ITestResult result) {
		System.out.println("Test started");
	}
	public void onTestSuccess(ITestResult result) {
		extentTest.pass("This TestCase Is Passed" );
		System.out.println("Test success");
		
	}

}
