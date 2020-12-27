package com.ecom.CiCdDemoApp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import okhttp3.OkHttpClient;

@SpringBootApplication
public class CiCdDemoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CiCdDemoAppApplication.class, args);
	}
	/*
	public static void initWebDriver() {
		OkHttpClient OkHttpClient = new OkHttpClient().newBuilder().connectTimeout(1000000, TimeUnit.SECONDS)
				.readTimeout(1000, TimeUnit.SECONDS)
				.writeTimeout(1000000, TimeUnit.SECONDS).build();
		OkHttpClient.retryOnConnectionFailure();
		System.setProperty("webdriver.chrome.driver",
				 "E:\\simplilearn\\PracticeProjects\\CiCdDemoApp\\driver\\chromedriver.exe") ;
		WebDriver driver = new ChromeDriver();
		RunEnvironment.setWebDriver(driver);
	}
	*/
	public static void shutDownDriver() {
		RunEnvironment.getWebDriver().quit();
	}

}
