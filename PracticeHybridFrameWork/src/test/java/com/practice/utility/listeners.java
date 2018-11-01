package com.practice.utility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.practice.testcases.BaseClass;



public class listeners implements ITestListener  {
  BaseClass base;
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		//hey i am done
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		//
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//screenshot

		try {
			base = new BaseClass();
			base.add_screenShot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("TEST CASE EXECUTION START"+arg0.getName());
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
		System.out.println("TEST CASE PASSED SUCESSFULLY"+arg0.getName());
		
	}

}
