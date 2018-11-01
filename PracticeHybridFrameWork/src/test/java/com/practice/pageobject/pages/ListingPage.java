package com.practice.pageobject.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ListingPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//a[contains(text(),'Listing')]")
	
	WebElement btn_listing;
	
	
      @FindBy(xpath="//*[@class='listing-title']")
	
	    WebElement txt_listingTitle;


      @FindBy(id="sort_by_dropdown")
      List<WebElement> sort ;
	
	
      @FindBy(id="sort_by_dropdown")
    WebElement sorting ;
	
	
	
	public ListingPage(WebDriver driver)
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	
public void clickonListing()
{
	btn_listing.click();
}




   public void ListingSort() throws InterruptedException
        {
	sort = driver.findElements(By.id("sort_by_dropdown"));
    System.out.println( sort.size()); 
	for(int i=0;i<sort.size();i++)
	{
	String allelement = sort.get(i).getText();
	System.out.println("Select Box text "+allelement);
	
	Select select = new Select(sorting)	;
	
	if(select.isMultiple())
	{
		
	
	select.selectByIndex(1);
	
	}
	else 
	{
		Thread.sleep(1000);
		select.selectByIndex(0);
		System.out.println("Select is not multiple");
		
	}
	}
            }
             public void lowtohigh() throws InterruptedException
              {
 	  
            	 
            	 Select select = new Select(sorting)	;
            		
            		if(select.isMultiple())
            		{
            			
            		
            		select.selectByIndex(1);
            		
            		}
            		else 
            		{
            			Thread.sleep(1000);
            			select.selectByIndex(1);
            			System.out.println("Select is not multiple and we select Low to High");
            			
            		}
            		
              }
            		
            		 public void hightolow() throws InterruptedException
                     {
        	  
                   	 
                   	 Select select = new Select(sorting)	;
                   		
                   		if(select.isMultiple())
                   		{
                   			
                   		
                   		select.selectByIndex(11);
                   		
                   		}
                   		else 
                   		{
                   			Thread.sleep(1000);
                   			select.selectByIndex(2);
                   			System.out.println("Select is not multiple and we select High To Low");
                   			
                   		}
 	  
            }
}
