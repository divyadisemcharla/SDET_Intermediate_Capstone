package com.qa.stepdefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripStepDefinition {
	private WebDriver driver;

	@Given("MakeMyTrip application is launched")
		public void LaunchWebSiteURL() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver= new ChromeDriver(options);
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
	}
	
	@When("User click Flights and select RoundTrip")
	public void MakeMyTripRoundTrip() throws InterruptedException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@title, 'notification-frame')]")));
//			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='wewidgeticon we_close']"))).click();
			Thread.sleep(1000);
			Actions action = new Actions(driver);
			//Clicking outside			
			action.moveByOffset(0, 0).click().build().perform();
//			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@title, 'Sign in')]")));
//			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='commonModal__close']"))).click();
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
			//Selecting RoundTrip option
			driver.findElement(By.xpath("//li[@data-cy='roundTrip']/span")).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@And("User select fromCity {string} and toCity {string}")
	public void MakeMyTripSelectCity(String FromCity, String ToCity) throws InterruptedException {
		try {			
			// Find and click on the "From" city input field
			WebElement fromCityInput = driver.findElement(By.xpath("//input[@id='fromCity']"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", fromCityInput);
			Thread.sleep(3000);
			fromCityInput.sendKeys(FromCity);  
			Thread.sleep(3000);
			// Sleep for a while to allow the city suggestions to appear
			driver.findElement(By.xpath("(//li[@role='option'])[1]")).click();
			// Find and click on the "To" city input field
			WebElement toCityInput = driver.findElement(By.xpath("//input[@id='toCity']"));
			toCityInput.click();
			Thread.sleep(3000);
			toCityInput.sendKeys(ToCity);
			Thread.sleep(1000); // Sleep for a while to allow the city suggestions to appear
			driver.findElement(By.xpath("(//li[@role='option'])[1]")).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@And("User select Departure and Return dates")
	public void MakeMyTripSelectCity() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			Actions action = new Actions(driver);
			// Find and click on the "Departure Date" input field
			WebElement departureDateInput = driver.findElement(By.id("departure"));
			js.executeScript("arguments[0].click();", departureDateInput);
			// Select the desired departure date (assuming it's a valid date in the date picker)
			action.moveByOffset(0, 0).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@And("User clicks on Search button")
	public void MakeMyTripSearch() {
		try {
			// Find and click on the "Search" button
			WebElement searchButton = driver.findElement(By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']"));
			searchButton.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@And("User validate search page is displayed")
	public void MakeMyTripSearchedPage() {
		try {
			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='font24 blackFont whiteText appendBottom20 journey-title makeFlex spaceBetween bottom']")));
			// Verifying the search page is displayed    
			WebElement searchPage = driver.findElement(By.xpath("//p[@class='font24 blackFont whiteText appendBottom20 journey-title makeFlex spaceBetween bottom']"));
			searchPage.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Then("User quits from the browser")
	public void CloseBrowser() {
		try {
			// Close the browser
			driver.close();
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
