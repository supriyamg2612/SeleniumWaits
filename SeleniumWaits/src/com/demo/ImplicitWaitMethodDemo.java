package com.demo;

import java.time.Duration;
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWaitMethodDemo {
	
static WebDriver driver = null;

	
	public static void main(String[] args)  {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
	//	driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);  (For Selenium - 3)


		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		
		
		driver.findElement(By.name("username")).sendKeys("Admin");
	}

}