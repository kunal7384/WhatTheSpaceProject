package com.practice.testcases;

import java.io.File;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.practice.utility.ConfigReader;
import com.practice.utility.ReadExcelData;
import com.practice.utility.WriteExcel;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;


public class BaseClass {
	
	ConfigReader con = new ConfigReader();
	public static WebDriver driver;
	public String baseURl =con.getUrl();
	public String userName =con.getUsername();
	public String passWord =con.getPassword();
	WriteExcel excel ;
	

	static final Logger LOGGER =LogManager.getLogger(BaseClass.class.getName());
	@Parameters("browser") 
	@BeforeClass
	
	public void setup(String browser)
	{
	
		LOGGER.info(" Driver Initialised");
	if(browser.equalsIgnoreCase("chrome"))	
		
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.out.println(System.getProperty("user.dir"));
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/Driver/geckodriver.exe");
			driver = new FirefoxDriver();
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		
		driver.get(con.getUrl());
	}
		
	
	@AfterClass
	
	public void close()
	{
		
		driver.close();
		
	}
	
	
	public void add_screenShot(String testname) throws IOException
	{
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
	
		 File target = new File(System.getProperty("user.dir")+"/ScreenShot/" +testname +".PNG");
		 FileUtils.copyFile(source, target); 
		
		
	}
	
	
	public String[][] getExceldataforlogin(String path , String sheetname) throws IOException
	{
		
		
		ReadExcelData excel = new ReadExcelData();
		return excel.getExcelData(System.getProperty("user.dir")+"/src/test/java/com/practice/testdata/logindata.xls", "Sheet1");
		
	}
	
	
	public boolean isAlertisPresent()
	{
		try
		{
			driver.switchTo().alert();
			return true;
			
		} catch (NoAlertPresentException e) {
			
			System.out.println("Alert is not Present");
			
			return false;
		}
	
	
	
	}
	
	
}

