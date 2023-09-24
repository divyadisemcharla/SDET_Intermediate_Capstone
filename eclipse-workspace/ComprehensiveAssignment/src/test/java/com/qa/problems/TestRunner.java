package com.qa.problems;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features = "src/test/resources/Features", glue="com.qa.stepdefinition", tags="@Sample",plugin = {"pretty", "html:target/cucumber-reports"}, dryRun=false
		)
public class TestRunner extends AbstractTestNGCucumberTests {

}
