package com.practice.testcases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.practice.pageobject.pages.ListingPage;

public class ListingTest extends BaseClass {
	
	ListingPage listing;
	
	final String  excepted_title_of_ListingPage ="5 NYC Real Estate & Apartments for Sale";
	
	
	final String sortbyValue="$\n" + 
			"Est. Payment: $1,600.0\n" + 
			"$\n" + 
			"Est. Payment: $24,030.0\n" + 
			"$1,200.0\r\n" + 
			"Est. Payment: $1,200.0\n" + 
			"$18,000.0\n" + 
			"Est. Payment: $15,000.0\n" + 
			"$1,800.0\n" + 
			"Est. Payment: $1,500.0";
	final String low_to_High="http://52.221.226.245/buildings?utf8=%E2%9C%93&sort_by=rent_asc&property_type=&location=&size_from=&size_to=&psf_from=&psf_to=&maps=";
	
	
	
	final String high_to_Low ="http://52.221.226.245/buildings?utf8=%E2%9C%93&sort_by=rent&property_type=&location=&size_from=&size_to=&psf_from=&psf_to=&maps=";
	
	@Test(priority=26)
	public void listingpageTest() throws InterruptedException
	{
		
	listing = new ListingPage(driver);
	
	listing.clickonListing();
	
	Assert.assertTrue(driver.findElement(By.xpath("//a[@class='btn site-default site-default-blank']")).isDisplayed(),"Search button is not present");

	}
	
	@Test(priority=27)
	public void verifyListingPageTitle()
	{
		
		String actualtitle = driver.findElement(By.xpath("//*[@class='listing-title']")).getText();
		if(actualtitle.equals(excepted_title_of_ListingPage))
		{
			
			Assert.assertTrue(true);

		}
		
		else
		{
			Assert.assertTrue(false);
			
		}
		
	}
	
	@Test(priority=28)
	public void verifyListing_Sort() throws InterruptedException
	{
		listing.ListingSort();
		
		
	// If we click on Sort (Deafualt option)
		
		List<WebElement> sortby = driver.findElements(By.xpath("//*[@class='price']"));
		
		           for(WebElement ele : sortby)
		             {
			            
			            String aa= ele.getText();
			             System.out.println("============="+"Sort By Defualt"+"=============");
			             System.out.println(aa);
		             
		             } 
		            
		            
		           
		           
		             }
	
	@Test(priority=29)
 	public void verifyListing_lowtohigh() throws InterruptedException
 	{
		 
		 Thread.sleep(1000);
 		
 		
 		listing.lowtohigh();
 		
 		String actual_url = driver.getCurrentUrl();
 		
 		List<WebElement> sortbylowtohigh = driver.findElements(By.xpath("//*[@class='price']"));
 		for(int i=0;i<sortbylowtohigh.size();i++)
        {
           
            String elementlowtohigh = sortbylowtohigh.get(i).getText();
            
            System.out.println("============="+"Low to High"+"=============");
            
            System.out.println("Low to High"+elementlowtohigh);
            
            if(actual_url.equals(low_to_High)) {
            	Assert.assertTrue(true);
            	
            }
          
            else
            {
            	
            	Assert.assertTrue(false);
            }
        }
        } 
 		
 
 		@Test(priority=30)
 	 	public void verifyListing_hightolow() throws InterruptedException
 	 	{
 			 
 			 Thread.sleep(1000);
 			 
 			 listing.hightolow();
 			 String actual_url = driver.getCurrentUrl();
 			 
 	 		List<WebElement> sortbyhightolow = driver.findElements(By.xpath("//*[@class='price']"));
 	 		for(int i=0;i<sortbyhightolow.size();i++)
 	        {
 	           
 	            String elementhightolow = sortbyhightolow.get(i).getText();
 	            
 	            System.out.println("============="+" High to low "+"=============");
 	            
 	            System.out.println("High to Low"+elementhightolow);
 	            
 	            if(actual_url.equals(high_to_Low))
 	            {
 	            	
 	            Assert.assertTrue(true);	
 	            	
 	            }
 	            
 	            else
 	            {
 	            	
 	            	 Assert.assertTrue(false);	
 	            }
 	}
}
}