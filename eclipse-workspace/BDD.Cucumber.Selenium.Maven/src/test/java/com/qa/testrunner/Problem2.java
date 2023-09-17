package com.qa.testrunner;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Problem2 {	
	WebDriver driver;
	
	@BeforeMethod
	public void LaunchBrowser() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver= new ChromeDriver(options);		 
	}
	@Test
	public void MakeMyTrip() throws InterruptedException {
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			//Clicking outside
			Actions action = new Actions(driver);
			action.moveByOffset(0, 0).click().build().perform();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//li[@data-cy='roundTrip']/span")).click();
			// Find and click on the "From" city input field
			WebElement fromCityInput = driver.findElement(By.xpath("//input[@id='fromCity']"));
			js.executeScript("arguments[0].click();", fromCityInput);
			Thread.sleep(3000);
			fromCityInput.sendKeys("Hyderabad");  
			Thread.sleep(3000);
			// Sleep for a while to allow the city suggestions to appear
			driver.findElement(By.xpath("(//li[@role='option'])[1]")).click();
			// Find and click on the "To" city input field
			WebElement toCityInput = driver.findElement(By.xpath("//input[@id='toCity']"));
			toCityInput.click();
			Thread.sleep(3000);
			toCityInput.sendKeys("MAA");
			Thread.sleep(1000); // Sleep for a while to allow the city suggestions to appear
			// toCityInput.sendKeys(Keys.RETURN);
			driver.findElement(By.xpath("(//li[@role='option'])[1]")).click();
			// Find and click on the "Departure Date" input field
			WebElement departureDateInput = driver.findElement(By.id("departure"));
			js.executeScript("arguments[0].click();", departureDateInput);
			// Select the desired departure date (assuming it's a valid date in the date picker)
			action.moveByOffset(0, 0).click().build().perform();
			// Find and click on the "Search" button
			WebElement searchButton = driver.findElement(By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']"));
			searchButton.click();
			// Sleep for a while to observe the results
			Thread.sleep(10000);
			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='font24 blackFont whiteText appendBottom20 journey-title makeFlex spaceBetween bottom']")));
			// Verifying the search page is displayed    
			WebElement searchPage = driver.findElement(By.xpath("//p[@class='font24 blackFont whiteText appendBottom20 journey-title makeFlex spaceBetween bottom']"));
			searchPage.isDisplayed();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@AfterMethod
	 public void closeBrowser() throws InterruptedException {
		try {
			// Close the browser
			driver.close();
			Thread.sleep(2000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
