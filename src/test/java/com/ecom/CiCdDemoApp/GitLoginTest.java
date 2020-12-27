package com.ecom.CiCdDemoApp;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class GitLoginTest {
	
	WebDriver driver;
	final String siteUrl = "https://github.com/login";
	final String driverPath = "E:\\simplilearn\\PracticeProjects\\CiCdDemoApp\\driver\\chromedriver.exe";

	@BeforeTest
	public void loadBrowser() {
	System.setProperty("webdriver.chrome.driver",driverPath);
	driver = new ChromeDriver();
	}
	
	@Test
	public void loadGitHomePage() {
		Reporter.log("Chrome :::: loadGitHomePage :: Thread Id :: " + Thread.currentThread());
		driver.get(siteUrl);
		assertEquals(siteUrl, driver.getCurrentUrl());
	}
	
	@Test
	public void loginGit() throws InterruptedException {
		Thread.sleep(1000);
		WebElement email = driver.findElement(By.xpath("//*[@id=\"login_field\"]"));
		email.sendKeys("madhulika.vish@gmail.com");
		Thread.sleep(1000);
		WebElement pass = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		pass.sendKeys("62348LIka");
		Thread.sleep(1000);
	    WebElement submitbtn = driver.findElement(By.xpath("//*[@id=\"login\"]/div[4]/form/input[14]"));
	    submitbtn.click();
	}
	
	@AfterTest
	public void terminateBrowser() {
		driver.close();
	}

}
