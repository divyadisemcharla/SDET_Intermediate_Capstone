package com.qa.problems;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class CaseStudy1_UC2And5 extends GenericFunctions {
	@Test
	@Parameters({"username","password"})
	public void useCaseTwo(String username, String password) throws InterruptedException {
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		try {
			driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
			driver.findElement(By.xpath("//input[@id='login-button']")).click();
			System.out.println("UseCase Two: Logged in to the saucedemo portal successfully");
			String ActualTitle=driver.getTitle();
			String ExpectedTitle="Swag Labs";
			System.out.println("UseCaseFive Title is : "+ActualTitle);
			Assert.assertEquals(ActualTitle, ExpectedTitle,"Matched");
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
