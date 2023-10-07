package com.qa.problems;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GenericFunctions {
	public static WebDriver driver;
	
	@BeforeSuite
	public void LaunchBrowser() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver= new ChromeDriver(options);		
		System.out.println("Browser Launched");
	}
	
	//Method to capture screenshot
	   public static void captureScreenshot(WebDriver driver, String screenshotName) {
	        try {
	            TakesScreenshot ts = (TakesScreenshot) driver;
	            File source = ts.getScreenshotAs(OutputType.FILE);
	            String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	            String destination = "Screenshots/" + screenshotName + "_" + timeStamp + ".png";
	            File finalDestination = new File(destination);
	            FileUtils.copyFile(source, finalDestination);
	            System.out.println("Screenshot captured: " + finalDestination.getAbsolutePath());
	        } catch (IOException e) {
	            System.out.println("Exception while taking screenshot: " + e.getMessage());
	        }
	    }
	@AfterSuite
	 public void closeBrowser() throws Exception {
		try {
			// Close the browser
			driver.quit();
			System.out.println("Browser is closed");
			Thread.sleep(2000);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
