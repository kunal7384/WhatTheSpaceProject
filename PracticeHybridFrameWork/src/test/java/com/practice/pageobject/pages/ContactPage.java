package com.practice.pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	
	WebDriver driver;
	

	@FindBy(xpath="//a[contains(text(),'Contact')]")
	WebElement btn_contact;
	
	
	@FindBy(name="contact_u[name]")
	WebElement txt_contactname;
	
	
	@FindBy(id="exampleInputEmail")
	WebElement txt_contactemail;
	
	
	
	@FindBy(id="telephone")
	WebElement txt_contactphone;
	
	
	
	@FindBy(id="description")
	WebElement txt_contactmsg;
	
	@FindBy(name="button")
	WebElement btn_sendmsg;
	

	
	public ContactPage(WebDriver driver)
	{
		
		this.driver = driver;
	PageFactory.initElements(driver, this);
		
	}
	
	
	public void clickonContact()
	{
		
		btn_contact.click();
		
	}

	public void setContactName(String cName)
	{
		
		txt_contactname.clear();	
	txt_contactname.sendKeys(cName);
		
		
	}
	
	public void setContactEmail(String cEmail)
	{
		
		txt_contactemail.clear();
	txt_contactemail.sendKeys(cEmail);
		
		
	}
	
	public void setContactPhone(String cphone)
	{
		txt_contactphone.clear();
	txt_contactphone.sendKeys(cphone);
		
		
	}
	
	
	public void setContactMsg(String cmessage)
	{
		txt_contactmsg.clear();	
	txt_contactmsg.sendKeys(cmessage);
		
		
	}
	
	public void clickonSendMsg()
	{
		
		btn_sendmsg.click();
		
	}
	
}
