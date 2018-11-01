package com.practice.testcases;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HomePageLink extends BaseClass {
	
	
	// Checking is any Link is broken or not in Home Page of the Project 
	
	
	
	 
	 @Test
	public void checkLinkBroken()
	{
		
	List<WebElement> chekalllinks =  driver.findElements(By.tagName("a"));	
	
	int total_link_size = chekalllinks.size();
	
    System.out.println("Total link on Home Page is:: "+total_link_size);
    
    
    String[] chek  = new  String[total_link_size];
              for(int i=0;i<chekalllinks.size();i++)
                    {
    	
    	      String nameOfLink=  chekalllinks.get(i).getText();
    	   
    	     System.out.println(nameOfLink);
    	      
    	        chek[i]=        chekalllinks.get(i).getAttribute("href");
    	        
    	        String ele =  chekalllinks.get(i).getAttribute("href");
    	        
    	        System.out.println(ele);
    	        verifyLinkActive(ele);
    	
                    }
    	     for(int i=0;i<chekalllinks.size();i++)
             {
    	      driver.navigate().to(chek[i]);
    	      
    	    
    	      
            }
    
	
                    
		
		
	}
	 public static void verifyLinkActive(String linkUrl)
		{
	        try 
	        {
	           URL url = new URL(linkUrl);
	           
	           HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
	           
	           httpURLConnect.setConnectTimeout(3000);
	           
	           httpURLConnect.connect();
	           
	           if(httpURLConnect.getResponseCode()==200)
	           {
	               System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
	            }
	          if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)  
	           {
	               System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
	            }
	        } catch (Exception e) {
	           
	        }
		}
}
