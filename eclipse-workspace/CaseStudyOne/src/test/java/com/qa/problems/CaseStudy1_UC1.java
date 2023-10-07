package com.qa.problems;


import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


public class CaseStudy1_UC1 extends GenericFunctions {
	@Test
	public void useCaseOne() throws InterruptedException {
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		try {
			Thread.sleep(1000);
			String ActualTitle=driver.getTitle();
			String ExpectedTitle="Swag Labs";
			System.out.println("UseCaseOne Title is :  "+ActualTitle);
			Assert.assertEquals(ActualTitle, ExpectedTitle,"Matched");
			}
		 catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
    @AfterMethod
    public void tearDown(ITestResult result) {
            GenericFunctions.captureScreenshot(driver, result.getName());
    }


}
