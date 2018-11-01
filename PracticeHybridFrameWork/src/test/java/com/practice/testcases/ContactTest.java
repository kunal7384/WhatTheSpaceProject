package com.practice.testcases;




import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.practice.pageobject.pages.ContactPage;

public class ContactTest extends BaseClass{
	
	ContactPage contact;
	final String contact_Heading ="//span[contains(@class,'content-header wow fadeIn')]";
	
	final String contact_Name="Kunal";
	final String contact_Email ="abcd@gmail.com";
	final String contact_Mobile="1236547895";
	final String contact_Msg="This message description for Testig Purpose. \n Testing new line.\nTesting second new line.";
	
	final String contact_exceptedMsg="Name can't be blank";
	
	final String contact_exceptedMsg1="Email can't be blank";
	
	final String contact_exceptedMsg2="Phone can't be blank";
	
	final String contact_exceptedMsg3="Message can't be blank";
	
	@Test(priority=21 ,description="Verify contact page Title")
	
	public void verifyConatctPageTitle()
	{
		
	contact = new ContactPage(driver);
	contact.clickonContact();
	org.testng.Assert.assertTrue(driver.findElement(By.xpath(contact_Heading)).isDisplayed(),"Get In TOuch is not Dispaly");
		
		System.out.println("Touch With us is display");
		
		
		
	}
	
	//Keep Name field blank and click on send mesage 
	
	@Test(priority=22 ,description="Keeping Name field blank and click on send Message button")
	public void removeName()
	{
		
		
		contact.setContactEmail(contact_Email);
		contact.setContactPhone(contact_Mobile);
		contact.setContactMsg(contact_Msg);
		contact.clickonSendMsg();
		String actualMsg=driver.findElement(By.xpath("//h3[contains(text(),\"Name can't be blank\")]")).getText();
		System.out.println("For Name::"+actualMsg);
		if(actualMsg.equals(contact_exceptedMsg))
		{
			
		org.testng.Assert.assertTrue(true);	
			
		}
		else
		{
			
			org.testng.Assert.assertTrue(false);	
		}
		
	}
	
	
	//Keep Name field blank and click on send mesage 
	
		@Test(priority=23 ,description="Keeping Enail field blank and click on send Message button")
		public void removeEmail()
		{
			
		contact.setContactName(contact_Name);
		
		contact.setContactEmail("");
		contact.setContactPhone(contact_Mobile);
		contact.setContactMsg(contact_Msg);
		contact.clickonSendMsg();
		String actualMsg=driver.findElement(By.xpath("//h3[contains(text(),\"Email can't be blank\")]")).getText();
		System.out.println("For Email::"+actualMsg);
		if(actualMsg.equals(contact_exceptedMsg1))
		{
			
		org.testng.Assert.assertTrue(true);	
			
		}
		else
		{
			
			org.testng.Assert.assertTrue(false);	
		}
		
			
		}
		
		@Test(priority=24 ,description="Keeping Mobile field blank and click on send Message button")
		public void removeMobile()
		{
	     contact.setContactName(contact_Name);
	     contact.setContactEmail(contact_Email);
	     contact.setContactPhone("");
	     contact.setContactMsg(contact_Msg);
	     contact.clickonSendMsg();
			
	     String actualMsg=driver.findElement(By.xpath("//h3[contains(text(),\"Phone can't be blank\")]")).getText();
			System.out.println("For Mobile::"+actualMsg);
			
			
			if(actualMsg.equals(contact_exceptedMsg2))
			{
				
				org.testng.Assert.assertTrue(true);
				
			}
			else
			{
				
				org.testng.Assert.assertTrue(false);
				
			}
	
		}
		
		@Test(priority=25 ,description="Keeping Message field blank and click on send Message button")
		public void removeMsg()
		{
			
			  contact.setContactName(contact_Name);
			  contact.setContactEmail(contact_Email);
			  contact.setContactPhone(contact_Mobile);
			  contact.setContactMsg("");
			  contact.clickonSendMsg();
			
				
			     String actualMsg=driver.findElement(By.xpath("//h3[contains(text(),\"Message can't be blank\")]")).getText();
					System.out.println("For Message::"+actualMsg);
					
				if(actualMsg.equals(contact_exceptedMsg3))
				{
					
					org.testng.Assert.assertTrue(true);
					
					contact.clickonContact();
					
				}
				else
				{
					org.testng.Assert.assertTrue(false);
					
					
				}
					
		}
		
     
		     
		    
	     
	
}