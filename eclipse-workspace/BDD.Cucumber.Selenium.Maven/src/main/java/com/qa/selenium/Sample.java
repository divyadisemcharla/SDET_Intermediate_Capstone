package com.qa.selenium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
public class Sample {
	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\disem\\eclipse-workspace\\BDD.Cucumber.Selenium.Maven\\src\\main\\resources\\driverexes\\msedgedriver.exe");
//		WebDriverManager.chromedriver().setUp();
		EdgeOptions options= new EdgeOptions();
		options.addArguments("--ignore-certificate-errors");
		WebDriver driver= new EdgeDriver(options);	
		driver.get("https://www.zauca.com/");
		driver.manage().window().maximize();
		JavascriptExecutor js= (JavascriptExecutor)driver;
		System.out.println(driver.findElement(By.xpath("//h1[@class='hero-title']")).getText());
		System.out.println(driver.findElement(By.tagName("h1")).getAttribute("class"));
		List<WebElement> l=driver.findElements(By.tagName("div"));
		ArrayList a= new ArrayList();
		System.out.println(l.size());
		for(WebElement i:l) {
			System.out.println(i.getAttribute("class"));
			a.add(i.getAttribute("class"));
		}
		Collections.sort(a);
		System.out.println("===============================================================");
		for(Object j:a) {
			System.out.println(j);
		}
		
		/*	long height= (long)js.executeScript("return document.body.scrollHeight;");
		System.out.println("document height is "+height);
		long width= (long)js.executeScript("return document.body.scrollWidth;");
		System.out.println("document width is "+width);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		//js.executeScript("window.scrollTo(0,1519);");
		try {
		driver.findElement(By.xpath("//a[@title='Dominican Republic Independence Day 2023']")).click();
		}
		catch(NoSuchElementException e) {
		js.executeScript("window.scrollBy(0,2000);");
		}*/
		//driver.findElement(By.id("searchinput")).sendKeys("hello");
				
		//driver.quit();
		
	}

}
