package com.practice.testcases;


import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.practice.pageobject.pages.SignUpPage;

public class SignUpTest extends BaseClass{
	
	
	 static final Logger LOGGER =LogManager.getLogger(BaseClass.class.getName());
	SignUpPage signup ;
	String excepted1 ="email: can't be blank\n" + 
			"password: can't be blank\n" + 
			"first_name: can't be blank\n" + 
			"last_name: can't be blank";
			
	
	String excepted2 ="first_name: can't be blank"; 
			
	
	
	String excepted3 ="last_name: can't be blank"; 
	
	
	String excepted4 ="email: can't be blank"; 
	
	String excepted5 ="password: can't be blank\n" +
			                "password_confirmation: doesn't match Password";
	
	
	// Without Entering Any data Click On Create Account 
	@Test(priority=1,description="Sign up-Balnk Data and click on Sign up Button")
	
	public void without_entering_click_createAccount() throws InterruptedException, IOException
	{
		
		signup = new SignUpPage(driver);
		LOGGER.info("Click on Signup Link");
		signup.click_signUp();
		Thread.sleep(1000);
		LOGGER.info("Click on create account Link");
		signup.click_createacc();
		Thread.sleep(1000);
		if(isAlertisPresent()==true)
		{
			
			Alert ale = driver.switchTo().alert();
			String capture_msg = ale.getText();
			System.out.println(capture_msg);
			System.out.println("=========TC1=======================");
			Thread.sleep(1000);
			ale.accept();
			
			Assert.assertEquals(capture_msg, excepted1);
		
			
		}
		
		
		else
		{
			
			System.out.println("Alert is not Present and Test CAses Failed");
			
		}
		
	}
         @Test(priority=2,description="Sign Up:Filled out all fields and Remove the first name field")
      // Remove the first name File 
	public void remove_firstname() throws InterruptedException, IOException
	{
        		LOGGER.info("Enter Last Name");
		signup.enter_lastName("narola");
		LOGGER.info("Enter Email");
		signup.enter_email("abc@gmail.com");
		LOGGER.info("Enter password");
		signup.enter_password("password");
		LOGGER.info("Enter copnfirm password");
		signup.enter_cpassword("password");
		LOGGER.info("Click on create account link");
		signup.click_createacc();
		Thread.sleep(2000);
		if(isAlertisPresent()==true)
		{
			Thread.sleep(2000);
			Alert ale = driver.switchTo().alert();
			String capture_msg = ale.getText();
			System.out.println(capture_msg);
			
			System.out.println("=========TC2=======================");
			Thread.sleep(2000);
			ale.accept();
			
			Assert.assertEquals(capture_msg, excepted2);
			
		}
		
		
		else
		{
			
			System.out.println("Alert is not Present and Test CAses Failed");
			
		}
		
	}
	
         @Test(priority=3,description="Sign Up:Filled out all fields and Remove the Last name field")
         // Remove the Last name File 
   	public void remove_lasttname() throws InterruptedException, IOException
   	{
        	 LOGGER.info("Enter First name");
   	    signup.enter_firstName("Kunal");
   	 LOGGER.info("Remove LAst Name");
   		signup.enter_lastName("");
   	 LOGGER.info("Enter Email");
   		signup.enter_email("abc@gmail.com");
   	 LOGGER.info("Enter password");
   		signup.enter_password("password");
   	 LOGGER.info("Enter confirm password");
   		signup.enter_cpassword("password");
   	 LOGGER.info("Clikc on create account");
   		signup.click_createacc();
   		Thread.sleep(2000);
   		if(isAlertisPresent()==true)
   		{
   			Thread.sleep(2000);
   			Alert ale = driver.switchTo().alert();
   			String capture_msg = ale.getText();
   			System.out.println(capture_msg);
   			
   			System.out.println("=========TC3=======================");
   			Thread.sleep(2000);
   			ale.accept();
   		
			Assert.assertEquals(capture_msg, excepted3);
   			
   		}
   		
   		
   		else
   		{
   			
   			System.out.println("Alert is not Present and Test CAses Failed");
   			
   		}
   		
   	}

         @Test(priority=4,description="Sign Up:Filled out all fields and Remove the email field")
         // Remove the Email from Email Filed 
   	public void remove_email() throws InterruptedException, IOException
   	{
        	 LOGGER.info("Enter First name");
   	    signup.enter_firstName("Kunal");
   	 LOGGER.info("Enter Last name");
   		signup.enter_lastName("Dhote");
   	 LOGGER.info("Remove Email");
   		signup.enter_email("");
   	 LOGGER.info("Enter Password");
   		signup.enter_password("password");
   	 LOGGER.info("Enter confirm Password");
   		signup.enter_cpassword("password");
   	 LOGGER.info("click on create account");
   		signup.click_createacc();
   		Thread.sleep(2000);
   		if(isAlertisPresent()==true)
   		{
   			Thread.sleep(2000);
   			Alert ale = driver.switchTo().alert();
   			String capture_msg = ale.getText();
   			System.out.println(capture_msg);
   			System.out.println("=========TC4=======================");
   			Thread.sleep(2000);
   			ale.accept();
   			
			Assert.assertEquals(capture_msg, excepted4);
   			
   		}
   		
   		
   		else
   		{
   			
   			System.out.println("Alert is not Present and Test CAses Failed");
   			
   		}
   		
   	}
         
         
         
         @Test(priority=5,description="Sign Up:Filled out all fields and Remove the password field")
         // Remove the password
   	public void remove_password() throws InterruptedException, IOException
   	{
        	 LOGGER.info("Enter First Name");
   	    signup.enter_firstName("Kunal");
    	 LOGGER.info("Enter Last Name");
   		signup.enter_lastName("Dhote");
    	 LOGGER.info("Enter Email");
   		signup.enter_email("kd@gmail.com");
    	 LOGGER.info("Remove Password");
   		signup.enter_password("");
    	 LOGGER.info("Enter Confirm Password");
   		signup.enter_cpassword("password");
    	 LOGGER.info("Click on Create account");
   		signup.click_createacc();
   		Thread.sleep(2000);
   		if(isAlertisPresent()==true)
   		{
   			Thread.sleep(2000);
   			Alert ale = driver.switchTo().alert();
   			String capture_msg = ale.getText();
   			System.out.println(capture_msg);
   			System.out.println("=========TC5=======================");
   			Thread.sleep(2000);
   			ale.accept();
   			driver.navigate().refresh();

			Assert.assertEquals(capture_msg, excepted5);
   			
   		}
   		
   		
   		else
   		{
   			
   			System.out.println("Alert is not Present and Test CAses Failed");
   			
   		}
   		
   	}
         
         
}
