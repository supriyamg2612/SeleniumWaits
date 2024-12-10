package com.demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitMethodDemo {
	
static WebDriver driver = null;

	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
		driver = new ChromeDriver();
		
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(5));  //Declaration
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.manage().window().maximize();
		
		WebElement usernameElement = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		
		
		// in explicit wait identification of webelement is inclusive. it returns webelement directly
		
		usernameElement.sendKeys("Admin"); 
		
		//driver.findElement(By.name("username")).sendKeys("Admin");   // no need to use findelement method
	}

}