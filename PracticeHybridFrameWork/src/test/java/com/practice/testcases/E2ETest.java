package com.practice.testcases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.Test;

import com.practice.pageobject.pages.LoginDataDrivenPage;
import com.practice.pageobject.pages.LoginPage;
import com.practice.pageobject.pages.ViewProfileDataDrivenPage;

public class E2ETest extends BaseClass {
	
	SignUpTest signup;
	
	InvalidLoginTest invalid;
	
	LoginTest login;
	
	 LoginDataDrivenTest loginddt;
	 
	 LoginPage loginpage;
	 
	 LoginDataDrivenPage loginddtpage;
	 
	 ListingTest listing;
	 
	 ViewProfileTest viewTest ;
	public static ViewProfileDatadrivenTest viewprofile;
	
	
	ViewProfileDataDrivenPage view;
	
	ContactTest contacttest;
	@Test(priority=31)
	
	public void SignUp() throws InterruptedException, IOException
	{
		
		signup = new SignUpTest();
		signup. without_entering_click_createAccount();
		signup.remove_firstname();
		signup.remove_lasttname();
		signup.remove_email();
		signup.remove_password();
		
	}
	
	
@Test(priority=32)
	
	public void invalidLogin() throws InterruptedException
	
	{
	invalid =new InvalidLoginTest();
	invalid.balnk_fields();
	invalid.balnk_password_fields();
	invalid.balnk_Email_fields();
	
	
	}

      @Test(priority=33 )

     public void validLogin() throws InterruptedException, IOException

      {
    	  Thread.sleep(1000);
                login = new LoginTest(); 
                Thread.sleep(1000);
                 login.verifu_Login();
                 Thread.sleep(1000);
               loginpage = new LoginPage(driver);
               loginpage.click_Login();

          }

      @Test(priority=34 ,dataProvider="logintest",dataProviderClass= LoginDataDrivenTest.class )

      public void loginDataDriven(String userid , String userpass) throws InterruptedException, IOException

       {
    	  loginddt = new LoginDataDrivenTest();
    	  
    	  Thread.sleep(1000);
    	 
    	  loginddt.logindata_driver(userid, userpass);
     
       }
      
     
      @Test(priority=35 )

      public void viewProfile() throws InterruptedException 

      
      {
    	driver.navigate().refresh();  
    	viewTest = new ViewProfileTest();
    	viewTest.login();
    	Thread.sleep(1000);
    	viewTest.edit_profile_remove_firstname();
    	Thread.sleep(1000);
    	viewTest.remove_lastName();
    	viewTest.remove_mobile();
    	viewTest.remove_firstname_withoutfilling_cutrrent_password();
    	Thread.sleep(1000);
    	viewTest.remove_lasname_withoutfilling_cutrrent_password();
    	viewTest.remove_mobile_withoutfilling_cutrrent_password();
    	
    	  
    	  
      }
      
      
      
      @Test(priority=36 )

      public void contact() 
      {
    	contacttest= new ContactTest();
    	contacttest.verifyConatctPageTitle();
    	contacttest.removeName();
    	contacttest.removeEmail();
    	contacttest.removeMobile();
    	contacttest.removeMsg();
    	  
    	  
    	  
      }
      
      @Test(priority=37 )

      public void verifyListing() throws InterruptedException 
      
      {
    	  
    	listing= new ListingTest();
    	
    	listing.listingpageTest();
    	listing.verifyListingPageTitle();
    	listing.verifyListing_Sort();
    	listing.verifyListing_lowtohigh();
    	listing.verifyListing_hightolow();
    	  
    	  
    	  
      }
      
      
       

}
