package com.demo;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class FluentWaitDemo {
	
static WebDriver driver = null;

			// customize pollling freq...
			// define exception handling

	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
		driver = new ChromeDriver();
		
		//declaration
		Wait<WebDriver> mywait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);
				
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.manage().window().maximize();
		
		WebElement usernameField = mywait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                System.out.println("Checking for the presence of Username field...");
                WebElement element = driver.findElement(By.xpath("input[placeholder='Username']"));
                if (element.isDisplayed()) {
                    return element;
                } else {
                    return null; // Continue polling until condition is met
                }
            }
            
        });

		usernameField.sendKeys("Admin");

        
       
    

		
		
		
		
		WebElement passwordElement = mywait.until(new Function<WebDriver, WebElement>() {
		     public WebElement apply(WebDriver driver) {
		       return driver.findElement(By.name("password"));
		     }
		   });
		
		
		passwordElement.sendKeys("admin123");
		
		
		WebElement loginButtonElement = mywait.until(new Function<WebDriver, WebElement>() {
		     public WebElement apply(WebDriver driver) {
		       return driver.findElement(By.xpath("//button[text()=' Login ']"));
		     }
		   });
		
		
		loginButtonElement.click();
		
		
		
	}

}


