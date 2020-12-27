package com.ecom.CiCdDemoApp;

import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import static org.testng.Assert.assertEquals;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class ProfileUploadTest {

	WebDriver driver;
	final String siteUrl = "https://github.com/login";
	final String driverPath = "E:\\simplilearn\\PracticeProjects\\CiCdDemoApp\\driver\\chromedriver.exe";

	@BeforeTest
	public void loadBrowser() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
	}
/*
	@Test
	public void loadGitHomePage() {

		Reporter.log("Chrome :::: loadGitHomePage :: Thread Id :: " + Thread.currentThread());
		driver.get(siteUrl);
		assertEquals(siteUrl, driver.getCurrentUrl());
	}
*/
	@Test
	public void UploadProfilePicTest() throws InterruptedException, IOException {
		Reporter.log("Chrome :::: UploadProfilePicTest :: Thread Id :: " + Thread.currentThread());
		driver.get(siteUrl);
		Thread.sleep(1000);
		//Login to Git
		WebElement email = driver.findElement(By.xpath("//*[@id=\"login_field\"]"));
		email.sendKeys("madhulika.vish@gmail.com");
		Thread.sleep(1000);
		WebElement pass = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		pass.sendKeys("62348LIka");
		Thread.sleep(1000);
		WebElement submitbtn = driver.findElement(By.xpath("//*[@id=\"login\"]/div[4]/form/input[14]"));
		submitbtn.click();
		Thread.sleep(2000);

		//Load Settings Page
		final String settingsUrl = "https://github.com/settings/profile";
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(settingsUrl);
		Thread.sleep(1000);
		
		//Click edit button on profile pic
		WebElement editbtn = driver.findElement(By.xpath("//*[@id=\"js-pjax-container\"]/div/div/div[2]/div[2]/div[2]/dl/dd/div/details/summary/div"));
		editbtn.click();
		Thread.sleep(200);

		//select Upload Photo option
		WebElement addFile = driver.findElement(By.xpath("//*[@id=\"js-pjax-container\"]/div/div/div[2]/div[2]/div[2]/dl/dd/div/details/details-menu/label"));
		addFile.click();
		Thread.sleep(3000);

		//Choose Image
		Runtime.getRuntime().exec("E:\\simplilearn\\AutoIT Scripts\\profileUpload.exe");
		Thread.sleep(7000); // delay to upload image

		//confirm selected image to upload
		WebElement setprofile = driver.findElement(By.xpath("/html/body/details/details-dialog/form/div[2]/button"));
		setprofile.click();
		Thread.sleep(7000);
	}

	@AfterTest
	public void terminateBrowser() {
		driver.close();
	}

}
