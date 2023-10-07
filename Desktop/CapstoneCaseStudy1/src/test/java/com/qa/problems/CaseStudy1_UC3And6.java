package com.qa.problems;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CaseStudy1_UC3And6 extends GenericFunctions {	
	@Test
	@Parameters({"Invalidusername","Invalidpassword"})
	public void useCaseThree(String Invalidusername, String Invalidpassword) throws InterruptedException {
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		try {
			driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(Invalidusername);
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(Invalidpassword);
			driver.findElement(By.xpath("//input[@id='login-button']")).click();
			System.out.println("UseCaseThree:  "+"Unable to login to the portal");
			String errorMessage=driver.findElement(By.xpath("//*[contains(text(),'Epic sadface: Username and password do not match any user in this service')]")).getText();
			Assert.assertTrue(errorMessage.contains("Username and password do not match any user in this service"), "Invalid login error message not displayed");
			String ActualTitle=driver.getTitle();
			String ExpectedTitle="Swag Labss";
			System.out.println("UseCaseSix Title :  "+ActualTitle);
			Assert.assertNotEquals(ActualTitle, ExpectedTitle);		
		}
		 catch (Exception e) {
			e.printStackTrace();
		}	
	}
    @AfterMethod
    public void tearDown(ITestResult result) {
            GenericFunctions.captureScreenshot(driver, result.getName());
    }
}
