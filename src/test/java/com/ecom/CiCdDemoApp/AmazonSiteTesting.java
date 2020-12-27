package com.ecom.CiCdDemoApp;


import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class AmazonSiteTesting {
	WebDriver driver;
    final String siteUrl = "https://www.amazon.in/";
	final String driverPath= "E:\\simplilearn\\PracticeProjects\\CiCdDemoApp\\driver\\chromedriver.exe" ;
	
  @BeforeTest
  public void launchBrowser() {
	  System.setProperty("webdriver.chrome.driver",driverPath);
	  driver = new ChromeDriver();
	  driver.get(siteUrl);	  
  }
  
  @Test
  public void loadAmazonHomePage() {
	  assertEquals(siteUrl,driver.getCurrentUrl());
  }

  @Test
  public void verifyAmazonHomePageTitle() {
	 Reporter.log("Chrome :::: verifyAmazonHomePageTitle :: Thread Id :: "+Thread.currentThread());
	 String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
	 assertEquals(expectedTitle, driver.getTitle());
  }
  
  @AfterTest
  public void terminateBrowser() {
	  driver.close();
  }


}
